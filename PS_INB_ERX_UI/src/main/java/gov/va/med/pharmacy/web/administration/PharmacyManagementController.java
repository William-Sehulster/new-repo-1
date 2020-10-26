package gov.va.med.pharmacy.web.administration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.json.JsonSanitizer;

import gov.va.med.pharmacy.persistence.managepharmacy.ManagePharmacyFilter;
import gov.va.med.pharmacy.persistence.model.PharmacyEntity;
import gov.va.med.pharmacy.persistence.model.VaUser;
import gov.va.med.pharmacy.persistence.report.StationIdSelectModel;
import gov.va.med.pharmacy.persistence.report.VisnSelectModel;
import gov.va.med.pharmacy.persistence.service.PharmacyService;
import gov.va.med.pharmacy.persistence.service.TrackMessageService;
import gov.va.med.pharmacy.persistence.service.UserService;
import gov.va.med.pharmacy.utility.ESAPIValidationType;
import gov.va.med.pharmacy.utility.ESAPIValidator;
import gov.va.med.pharmacy.web.ResponseMessage;
import gov.va.med.pharmacy.web.administration.managepharmacy.PharmacyForm;
import gov.va.med.pharmacy.web.csv.CSVSupportBean;
import gov.va.med.pharmacy.web.csv.CSVView;
import net.rossillo.spring.web.mvc.CacheControl;
import net.rossillo.spring.web.mvc.CachePolicy;

@Controller
@RequestMapping(value = "/managePharm")
public class PharmacyManagementController {

	private static final String Y_STRING_VAL = "Y";

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(PharmacyManagementController.class);
	
	private static final String[] PHARM_LIST_HEADERS = { "VISN", "VA Station ID",	"NCPDP ID", "Pharmacy Name (Published)", "Pharmacy Name (Internal)", "Address", 
            "City", "State", "Phone Number","eRx Enabled"};
	
	
	private static final String ALL_VALUE = "All";
	
	@Autowired
	private PharmacyService pharmacyService;
	
	@Autowired
	private TrackMessageService trackMessageService;
	
	@Autowired
	private UserService userService;

	
	final private String[] DISALLOWED_FIELDS = new String[]{"updatedDate", "createdDate"};
	
	//TO-DO update with fields not to bind from form.
	@InitBinder
	public void initBinderFields(WebDataBinder binder) {
	    binder.setDisallowedFields(DISALLOWED_FIELDS);
	}

	
	@RequestMapping(value = "/main")
	public ModelAndView getMainPage(HttpServletRequest request) {
		
		Authentication  authentication = SecurityContextHolder.getContext().getAuthentication();	
		
		VaUser currentUser = userService.findByVAUserID((String)authentication.getPrincipal());
		
		HttpSession session = request.getSession(false);
		
		session.removeAttribute("USER_STATIONS_IDS");
		 
		session.setAttribute("USER_STATIONS_IDS", currentUser.getVaStationIds());

		ModelAndView view = new ModelAndView("managepharmacy");
		
		List<VisnSelectModel>  visnList = getVisnSelect(currentUser.getVaStationIds());
		
		view.addObject("visnList", visnList);
		
		// when redirected after add pharmacy.
		if(null!=session.getAttribute("messageData")){
			
			ResponseMessage responseMessage = (ResponseMessage) session.getAttribute("messageData");
			
			view.addObject("messageData",responseMessage);		
			
			session.removeAttribute("messageData");
		}
		
		

		return view;
	}

	@RequestMapping(value = "/getPharmacyList",  method = RequestMethod.GET)	
	public ModelAndView getPharmacyList(HttpServletRequest request, @RequestParam("json") String json) throws JsonParseException, JsonMappingException, IOException {

		ModelAndView mav = new ModelAndView(new org.springframework.web.servlet.view.json.MappingJackson2JsonView());
		
		List<PharmacyEntity> pharmacyList = new ArrayList<PharmacyEntity>();
		
		String jsonString = JsonSanitizer.sanitize(json); // Sanitize the JSON coming from client
		
		ObjectMapper jsonMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		ManagePharmacyFilter managePharmacyFilter = jsonMapper.readValue(jsonString, ManagePharmacyFilter.class);
		
		String userStationIds = getUserStationIds(request);
		

		try {
			
			if(ALL_VALUE.equalsIgnoreCase(userStationIds)){
				
				
				pharmacyList = pharmacyService.find(managePharmacyFilter);
				
			}
			else
			{
				
				 List<String> stationIdsList = new ArrayList<String>(Arrays.asList(userStationIds.split(",")));
				
				 pharmacyList =  pharmacyService.findSelectedPharmacies(managePharmacyFilter,stationIdsList);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mav.addObject("items", pharmacyList);

		return mav;
	}
	
	
	@RequestMapping(value = "/editPharmacy/{ncpdpID}",  method = RequestMethod.GET)	
	public ModelAndView editPharmacy(HttpServletRequest request, @PathVariable(value="ncpdpID") String NCPDPId) throws JsonParseException, JsonMappingException, IOException {

		//System.out.println("NCPDP Id is: "+NCPDPId);
		
		ModelAndView view = new ModelAndView("editpharmacy");
		
		PharmacyEntity pharmacyInfo = pharmacyService.findByNCPDPId(NCPDPId);
				
		view.addObject("pharmacyInfo",pharmacyInfo );
		
		Map<String, String> statesMap = getStatesHashMap();
		
        Map<Long, String> specialityMap = getSpecialityHashMap();
		
		Map<String, String> serviceLevelMap = getServiceLevelHashMap();

		view.addObject("statesMap",statesMap );
		
        view.addObject("specialityMap",specialityMap );
		
		view.addObject("serviceLevelMap",serviceLevelMap );
		
		return view;
		
	}
	
	
	@RequestMapping(value = "/updatePharmacy",  method = RequestMethod.POST)	
	public ModelAndView updatePharmacy(HttpServletRequest request,@Valid @ModelAttribute("pharmacyEditForm") PharmacyForm pharmacyForm, BindingResult bindingResult) throws  IOException {

		LOG.info("Trying to persist pharmacy information.");
		
		ResponseMessage responseMessage = new ResponseMessage();
		List<String> errorsList = new ArrayList<String>();
		
		// validation
		
		 if (bindingResult.hasErrors()) {
			 List<ObjectError> errors = bindingResult.getAllErrors();
			 
			 for (ObjectError objectError : errors) {
				 errorsList.add(objectError.getDefaultMessage());
		 }
		
       
        }
				
		ModelAndView view = new ModelAndView("editpharmacy");
		
		// we need to use find by id as NCPDP ID can change and findByNCPDPId wont work.
		PharmacyEntity pharmacyInfo = null;
		
			
		try {
			
			
			// Fortify fix.
			String userStationIds = getUserStationIds(request);
			
			boolean  stationIdFound = false;
			
			if(!"All".equalsIgnoreCase(userStationIds)){
				 
				List<String> stationIdsList = new ArrayList<String>(Arrays.asList(userStationIds.split(",")));
				
				// search the station id.
				
				for (String str: stationIdsList) {
					
					if(str.contains(HtmlUtils.htmlEscape(pharmacyForm.getVaStationId()))) {						
						// allow update.
						stationIdFound = true;
						break;
					}
				}
				 
				 
			}
			
			if(("All".equalsIgnoreCase(userStationIds)) || (stationIdFound == true)) {
				
				
				// needed for fortify scan issue for access db violation.
				String pharmacyId = ESAPIValidator.validateStringInput(pharmacyForm.getPharmacyId(), ESAPIValidationType.ACCESS_CONTROL_DB);
				
				pharmacyInfo = pharmacyService.findById(Long.valueOf(pharmacyId));	
					
					
				Date updatedDate = new Date();
				
							
				
				pharmacyInfo.setVaStationId(HtmlUtils.htmlEscape(pharmacyForm.getVaStationId()));
				pharmacyInfo.setNcpdpId(HtmlUtils.htmlEscape(pharmacyForm.getNcpdpId()));
					
				pharmacyInfo.setStoreName(HtmlUtils.htmlEscape(pharmacyForm.getStoreName()));
				pharmacyInfo.setPharmacistLastName(HtmlUtils.htmlEscape(pharmacyForm.getPharmacistLastName()));
				pharmacyInfo.setPharmacistFirstName(HtmlUtils.htmlEscape(pharmacyForm.getPharmacistFirstName()));
				pharmacyInfo.setPharmacistMiddleName(HtmlUtils.htmlEscape(pharmacyForm.getPharmacistMiddleName()));
				pharmacyInfo.setPharmacistSuffix(HtmlUtils.htmlEscape(pharmacyForm.getPharmacistSuffix()));
				pharmacyInfo.setPharmacistPrefix(HtmlUtils.htmlEscape(pharmacyForm.getPharmacistPrefix()));
				pharmacyInfo.setPharmacyAddressLine1(HtmlUtils.htmlEscape(pharmacyForm.getPharmacyAddressLine1()));
				pharmacyInfo.setPharmacyAddressLine2(HtmlUtils.htmlEscape(pharmacyForm.getPharmacyAddressLine2()));
				pharmacyInfo.setPharmacyCity(HtmlUtils.htmlEscape(pharmacyForm.getPharmacyCity()));
				pharmacyInfo.setPharmacyState(HtmlUtils.htmlEscape(pharmacyForm.getPharmacyState()));
				pharmacyInfo.setPharmacyZipcode(HtmlUtils.htmlEscape(pharmacyForm.getPharmacyZipcode()));
				pharmacyInfo.setCrossStreet(HtmlUtils.htmlEscape(pharmacyForm.getCrossStreet()));
				pharmacyInfo.setPharmacyPhoneNumber(HtmlUtils.htmlEscape(pharmacyForm.getPharmacyPhoneNumber()));
				pharmacyInfo.setPharmacyFaxNumber(HtmlUtils.htmlEscape(pharmacyForm.getPharmacyFaxNumber()));
				pharmacyInfo.setUpdatedDate(updatedDate);	
				
				pharmacyInfo.setEandeCheck(Boolean.valueOf(Y_STRING_VAL.equalsIgnoreCase(HtmlUtils.htmlEscape(pharmacyForm.geteAndeCheckEnabled()))?true:false));
				
				if( (StringUtils.isNotBlank(pharmacyForm.getVisn())) && (StringUtils.isNumeric(pharmacyForm.getVisn()))){
				
					pharmacyInfo.setVisn(Long.valueOf(pharmacyForm.getVisn()));
				}
				
				pharmacyInfo.setDivisionName(HtmlUtils.htmlEscape(pharmacyForm.getDivisionName()));
				
				pharmacyInfo.setInboundErxEnabled(Long.valueOf(pharmacyForm.getPharmacyEnabledDisabled()));
				
				if( (StringUtils.isNotBlank(pharmacyForm.getNpi())) && (StringUtils.isNumeric(pharmacyForm.getNpi()))){
					
					pharmacyInfo.setNpi(Long.valueOf(pharmacyForm.getNpi()));
				}
				
				
				if(!bindingResult.hasErrors() ) {
				
			    // get logged in user.
				Authentication  authentication = SecurityContextHolder.getContext().getAuthentication();	
				
				if(authentication!=null){
					
					String userName = (String)authentication.getPrincipal();
					pharmacyInfo.setUpdatedBy(userName);
				}
						
			    pharmacyService.updatePharmacyInfo(pharmacyInfo);
			    
				}
			}
			
			else if(stationIdFound == false)
			{
				errorsList.add("You are not allowed to update this pharamcy.");
			}
			
		
			
			
		} catch (PersistenceException e) {
			
			e.printStackTrace();
			
			Throwable  cause = e.getCause();
			
			if(cause instanceof ConstraintViolationException){
				
				
				String constraintName = ((ConstraintViolationException) cause).getConstraintName();
				
				if(constraintName.contains("NCPDP_ID")){
				
					errorsList.add("Please use unique value for NCPDP ID.");
				}
				
				if(constraintName.contains("DIVISION_NAME")){
					
					errorsList.add("Please use unique value for Division Name.");
				}
				
				if(constraintName.contains("NPI")){
					
					errorsList.add("Please use unique value for NPI.");
				}
				
				if(constraintName.contains("VA_STATION_ID")){
					
					errorsList.add("Please use unique value for VA Station ID.");
				}
				
				
			}
			else{
				
				errorsList.add("Update Failed. Unable to save record. Please contact production support.");
			}
		}
		catch (Exception e) {
			
			e.printStackTrace();			
			
			errorsList.add("Update Failed. Unable to save record. Please contact production support.");
			
			
		  }
		
		
		responseMessage.setErrorMessage(errorsList);
		
		// set success message only if everything is successful.		
		if( responseMessage.getErrorMessage().isEmpty()){
			
			responseMessage.setSuccessMessage("Pharmacy information updated successfully.");	
		}
		
	    
		view.addObject("pharmacyInfo",pharmacyInfo );
		
		Map<String, String> statesMap = getStatesHashMap();
		
		Map<Long, String> specialityMap = getSpecialityHashMap();
		
		Map<String, String> serviceLevelMap = getServiceLevelHashMap();
		
		view.addObject("statesMap",statesMap );
		
		view.addObject("specialityMap",specialityMap );
		
		view.addObject("serviceLevelMap",serviceLevelMap );
		
		view.addObject("messageData",responseMessage);		
		
		return view;	
		
	}

	
	
	
	private Map<String, String> getServiceLevelHashMap() {
		
		Map<String, String> serviceLevelMap = new LinkedHashMap<String, String>();
		
		serviceLevelMap.put("1", "New Rx");
		serviceLevelMap.put("2", "Refill");
		serviceLevelMap.put("4", "Change");
		serviceLevelMap.put("8", "RxFill");
		serviceLevelMap.put("16", "Cancel");
		serviceLevelMap.put("32", "MedHistory");
		serviceLevelMap.put("64", "Eligibility");
		serviceLevelMap.put("128", "Not Used");
		serviceLevelMap.put("256", "Resupply");
		serviceLevelMap.put("512", "Census");
		serviceLevelMap.put("1024", "CCR");
		serviceLevelMap.put("2048", "Controlled Substance (EPCS)");
		
		return serviceLevelMap;
	}

	private Map<Long, String> getSpecialityHashMap() {
		Map<Long, String> specialityMap = new LinkedHashMap<Long, String>(); 
		
		specialityMap.put(new Long(1), "Mail Order Pharmacy");
		specialityMap.put(new Long(2), "Fax Pharmacy");
		specialityMap.put(new Long(8), "Retail Pharmacy");
		specialityMap.put(new Long(16), "Speciality Pharmacy");
		specialityMap.put(new Long(32), "Long-Term Care Pharmacy");
		specialityMap.put(new Long(64), "24 Hour Pharmacy");
		return specialityMap;
	}

	private Map<String, String> getStatesHashMap() {
		Map<String, String> statesMap = new LinkedHashMap<String, String>();
		
		statesMap.put("AL","Alabama");
		statesMap.put("AK","Alaska");
		statesMap.put("AZ","Arizona");
		statesMap.put("AR","Arkansas");
		statesMap.put("CA","California");
		statesMap.put("CO","Colorado");
		statesMap.put("CT","Connecticut");
		statesMap.put("DE","Delaware");
		statesMap.put("DC","District Of Columbia");
		statesMap.put("FL","Florida");
		statesMap.put("GA","Georgia");
		statesMap.put("HI","Hawaii");
		statesMap.put("ID","Idaho");
		statesMap.put("IL","Illinois");
		statesMap.put("IN","Indiana");
		statesMap.put("IA","Iowa");
		statesMap.put("KS","Kansas");
		statesMap.put("KY","Kentucky");
		statesMap.put("LA","Louisiana");
		statesMap.put("ME","Maine");
		statesMap.put("MD","Maryland");
		statesMap.put("MA","Massachusetts");
		statesMap.put("MI","Michigan");
		statesMap.put("MN","Minnesota");
		statesMap.put("MS","Mississippi");
		statesMap.put("MO","Missouri");
		statesMap.put("MT","Montana");
		statesMap.put("NE","Nebraska");
		statesMap.put("NV","Nevada");
		statesMap.put("NH","New Hampshire");
		statesMap.put("NJ","New Jersey");
		statesMap.put("NM","New Mexico");
		statesMap.put("NY","New York");
		statesMap.put("NC","North Carolina");
		statesMap.put("ND","North Dakota");
		statesMap.put("OH","Ohio");
		statesMap.put("OK","Oklahoma");
		statesMap.put("OR","Oregon");
		statesMap.put("PA","Pennsylvania");
		statesMap.put("PR","Puerto Rico");
		statesMap.put("RI","Rhode Island");
		statesMap.put("SC","South Carolina");
		statesMap.put("SD","South Dakota");
		statesMap.put("TN","Tennessee");
		statesMap.put("TX","Texas");
		statesMap.put("UT","Utah");
		statesMap.put("VT","Vermont");
		statesMap.put("VA","Virginia");
		statesMap.put("WA","Washington");
		statesMap.put("WV","West Virginia");
		statesMap.put("WI","Wisconsin");
		statesMap.put("WY","Wyoming");
		return statesMap;
	}

	@RequestMapping(value = "/addPharmacy",  method = RequestMethod.POST)	
	public ModelAndView newPharmacy(HttpServletRequest request) throws IOException {

		ModelAndView view = new ModelAndView("addpharmacy");
		
		Map<String, String> statesMap = getStatesHashMap();
		
        Map<Long, String> specialityMap = getSpecialityHashMap();
		
		Map<String, String> serviceLevelMap = getServiceLevelHashMap();
		
		view.addObject("statesMap",statesMap );
		
        view.addObject("specialityMap",specialityMap );
		
		view.addObject("serviceLevelMap",serviceLevelMap );
		
		return view;
		
	}
	
	
	@RequestMapping(value = "/addNewPharmacy",  method = RequestMethod.POST)	
	public ModelAndView addNewPharmacy(HttpServletRequest request,@Valid @ModelAttribute("pharmacyAddForm") PharmacyForm pharmacyForm, BindingResult bindingResult) throws  IOException {

		LOG.info("Trying to persist pharmacy information.");
		
		ResponseMessage responseMessage = new ResponseMessage();
		List<String> errorsList = new ArrayList<String>();
		
		// validation
		
		boolean hasErrors = false;
		
		 if (bindingResult.hasErrors()) {
			 List<ObjectError> errors = bindingResult.getAllErrors();
			 
			 for (ObjectError objectError : errors) {
				 errorsList.add(objectError.getDefaultMessage());
		 }
		
       
			 hasErrors = true;
        }
				
		ModelAndView view = null;
		
		
		
		// we need to use find by id as NCPDP ID can change and findByNCPDPId wont work.
		PharmacyEntity pharmacyInfo = new PharmacyEntity();
		
			
		try {
		
				
			Date updatedDate = new Date();
			
			pharmacyInfo.setVaStationId(HtmlUtils.htmlEscape(pharmacyForm.getVaStationId()));
			pharmacyInfo.setNcpdpId(HtmlUtils.htmlEscape(pharmacyForm.getNcpdpId()));
				
			pharmacyInfo.setStoreName(HtmlUtils.htmlEscape(pharmacyForm.getStoreName()));
			pharmacyInfo.setPharmacistLastName(HtmlUtils.htmlEscape(pharmacyForm.getPharmacistLastName()));
			pharmacyInfo.setPharmacistFirstName(HtmlUtils.htmlEscape(pharmacyForm.getPharmacistFirstName()));
			pharmacyInfo.setPharmacistMiddleName(HtmlUtils.htmlEscape(pharmacyForm.getPharmacistMiddleName()));
			pharmacyInfo.setPharmacistSuffix(HtmlUtils.htmlEscape(pharmacyForm.getPharmacistSuffix()));
			pharmacyInfo.setPharmacistPrefix(HtmlUtils.htmlEscape(pharmacyForm.getPharmacistPrefix()));			
			pharmacyInfo.setPharmacyAddressLine1(HtmlUtils.htmlEscape(pharmacyForm.getPharmacyAddressLine1()));
			pharmacyInfo.setPharmacyAddressLine2(HtmlUtils.htmlEscape(pharmacyForm.getPharmacyAddressLine2()));
			pharmacyInfo.setPharmacyCity(HtmlUtils.htmlEscape(pharmacyForm.getPharmacyCity()));
			pharmacyInfo.setPharmacyState(HtmlUtils.htmlEscape(pharmacyForm.getPharmacyState()));
			pharmacyInfo.setPharmacyZipcode(HtmlUtils.htmlEscape(pharmacyForm.getPharmacyZipcode()));
			pharmacyInfo.setCrossStreet(HtmlUtils.htmlEscape(pharmacyForm.getCrossStreet()));
			pharmacyInfo.setPharmacyPhoneNumber(HtmlUtils.htmlEscape(pharmacyForm.getPharmacyPhoneNumber()));
			pharmacyInfo.setPharmacyFaxNumber(HtmlUtils.htmlEscape(pharmacyForm.getPharmacyFaxNumber()));
			
			pharmacyInfo.setCreatedDate(updatedDate);
			pharmacyInfo.setCreatedBy(null);
			pharmacyInfo.setUpdatedDate(updatedDate);		
		
			pharmacyInfo.setDivisionName(HtmlUtils.htmlEscape(pharmacyForm.getDivisionName()));
			pharmacyInfo.setInboundErxEnabled(Long.valueOf(HtmlUtils.htmlEscape(pharmacyForm.getPharmacyEnabledDisabled())));
			
			pharmacyInfo.setEandeCheck(Boolean.valueOf(Y_STRING_VAL.equalsIgnoreCase(HtmlUtils.htmlEscape(pharmacyForm.geteAndeCheckEnabled()))?true:false));
			

            if( (StringUtils.isNotBlank(pharmacyForm.getVisn())) && (StringUtils.isNumeric(pharmacyForm.getVisn()))){
				
				pharmacyInfo.setVisn(Long.valueOf(pharmacyForm.getVisn()));
			}
			
            if( (StringUtils.isNotBlank(pharmacyForm.getNpi())) && (StringUtils.isNumeric(pharmacyForm.getNpi()))){
				
				pharmacyInfo.setNpi(Long.valueOf(pharmacyForm.getNpi()));
			}
			
			
			if(!bindingResult.hasErrors() ) {
				
				// Now check if the user is trying to add a pharmacy outside their station id.
				String userStationIds = getUserStationIds(request);
				
				if(!"All".equalsIgnoreCase(userStationIds)){
					
					List<String> stationIdsList = new ArrayList<String>(Arrays.asList(userStationIds.split(",")));
					
					String stationId = pharmacyForm.getVaStationId();
					
					boolean allowStationId = false;
					
					for( String str: stationIdsList ){
						
						if(str.trim().contains(stationId)){
							
							allowStationId = true;
						}
					}
					
					
					
					if(allowStationId == false){
						
						hasErrors = true;
						
						errorsList.add("You can not add a new pharmacy outside of your assigned Station ID.");
					}
					
				}
				
				
				
				 // get logged in user.
				Authentication  authentication = SecurityContextHolder.getContext().getAuthentication();	
				
				if(authentication!=null){
					
					String userName = (String)authentication.getPrincipal();
					pharmacyInfo.setUpdatedBy(userName);
					pharmacyInfo.setCreatedBy(userName);
				}	
			
			if(hasErrors == false){
				
				pharmacyService.savePharmacyInfo(pharmacyInfo);				
			}
		    
		    
			}
			else
			{
				hasErrors = true;
			}
			
		} catch (PersistenceException e) {
			
			e.printStackTrace();
			
			Throwable  cause = e.getCause();
			
			if(cause instanceof ConstraintViolationException){
				
				
				String constraintName = ((ConstraintViolationException) cause).getConstraintName();
				
				if(constraintName.contains("NCPDP_ID")){
				
					errorsList.add("Please use unique value for NCPDP ID.");
				}
				
				if(constraintName.contains("DIVISION_NAME")){
					
					errorsList.add("Please use unique value for Division Name.");
				}
				
				if(constraintName.contains("NPI")){
					
					errorsList.add("Please use unique value for NPI.");
				}
				
				if(constraintName.contains("VA_STATION_ID")){
					
					errorsList.add("Please use unique value for VA Station ID.");
				}
				
			}
			else{
				
				errorsList.add("Add Failed. Unable to save record. Please contact production support.");
			}
			
			hasErrors = true;
		}
		catch (Exception e) {
			
			e.printStackTrace();			
			
			errorsList.add("Add Failed. Unable to save record. Please contact production support.");
			
            hasErrors = true;
			
		  }
		
		finally{
			
			if(hasErrors== true){
				view = new ModelAndView("addpharmacy");
			}
			else{
				view = new ModelAndView("managepharmacy");
				
				String userStationIds = "";
						
				HttpSession session = request.getSession(false);			
				
				if(null!=session.getAttribute("USER_STATIONS_IDS")){
					
					userStationIds = (String) session.getAttribute("USER_STATIONS_IDS");
				}
				
				List<VisnSelectModel>  visnList = getVisnSelect(userStationIds);
				
				view.addObject("visnList", visnList);
			}
		}
		
		responseMessage.setErrorMessage(errorsList);
		
		// set success message only if everything is successful.		
		if( responseMessage.getErrorMessage().isEmpty()){
			
			responseMessage.setSuccessMessage("Pharmacy information added successfully.");	
			
			// set in seession as this will redirect to the pharmacy management and we need to display the success message.
			HttpSession session = request.getSession(false);
			
			session.setAttribute("messageData", responseMessage);
		}
		
		view.addObject("pharmacyInfo",pharmacyInfo );
		
		Map<String, String> statesMap = getStatesHashMap();
		
		Map<Long, String> specialityMap = getSpecialityHashMap();
		
		Map<String, String> serviceLevelMap = getServiceLevelHashMap();

		view.addObject("statesMap",statesMap );
		
		view.addObject("specialityMap",specialityMap );
		
		view.addObject("serviceLevelMap",serviceLevelMap );
		
		view.addObject("messageData",responseMessage );
		
		return view;	
		
	}
	
	@RequestMapping(value = "/getPharmacyListCSV", method = {RequestMethod.GET, RequestMethod.POST})
	public void csvExport(HttpServletRequest request, @RequestParam("json") String json,HttpServletResponse response) 
			throws JsonParseException, JsonMappingException, IOException{
		
		try {
			String jsonString = JsonSanitizer.sanitize(json);
			
			String csvFileName = "PharmacyList.csv";
			
			String responseHeaderKey = "Content-Disposition";
			
			String responseHeaderValue = String.format("attachment; filename=\"%s\"",   csvFileName);
			
			ObjectMapper jsonMapper = new ObjectMapper();
			
			ManagePharmacyFilter managePharmacyFilter = jsonMapper.readValue(jsonString, ManagePharmacyFilter.class);
			
			String userStationIds = getUserStationIds(request);
			
			List<PharmacyEntity> pharmacyList;

			if(ALL_VALUE.equalsIgnoreCase(userStationIds)){
				
				 pharmacyList = pharmacyService.queryForExport(managePharmacyFilter, null);
			}
			else{
				
				 List<String> stationIdsList = new ArrayList<String>(Arrays.asList(userStationIds.split(",")));
				
				 pharmacyList = pharmacyService.queryForExport(managePharmacyFilter,stationIdsList);
			}
			
			String[][] csvData = null;
			
			if(null!= pharmacyList && pharmacyList.size()>0){
				
				csvData = populateDataRows(pharmacyList,	PHARM_LIST_HEADERS);		
				
				
			}
			else{
				
				List<PharmacyEntity> pharmacyEmptyList = new ArrayList<PharmacyEntity>();
				
				PharmacyEntity  emptyBean = new PharmacyEntity();
				pharmacyEmptyList.add(emptyBean);				
				
				csvData = populateDataRows(pharmacyEmptyList,	PHARM_LIST_HEADERS);
				
			}
			
			response.setContentType("text/csv");
			
			response.setHeader(responseHeaderKey, responseHeaderValue);
			
			CSVSupportBean csvSupportBean = new CSVSupportBean();
			
			csvSupportBean.setHeaderRow(PHARM_LIST_HEADERS);

			csvSupportBean.setDataRows(csvData);
			
			Map<String,Object> csvModel = csvSupportBean.createModel();
			
			CSVView view = new CSVView();
			
			String data = view.getStringRepresentation(csvModel);
			
			response.getOutputStream().print(data);
			
			response.getOutputStream().flush();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private String[][] populateDataRows(List<PharmacyEntity> rows, String[] headers) {
		// + 1 for the totals as the last row
		String[][] dataRows = new String[rows.size()+1][headers.length];
		for (int i = 0; i < rows.size(); i++) {
			
			String[] row = ((PharmacyEntity) rows.get(i)).getStringArray();
						
			for (int j = 0; j < headers.length; j++) {
				
				dataRows[i][j] = row[j];
				
			}
		}
		
		return dataRows;
		
	}
	
		
	private List<VisnSelectModel> getVisnSelect(String userStationIds) {
		
		List<VisnSelectModel> visnSelectModelList = new ArrayList<VisnSelectModel>();
		
		VisnSelectModel visnSelectModel = new VisnSelectModel();
		visnSelectModel.setId("All");
		visnSelectModel.setLabel("All");
		visnSelectModelList.add(visnSelectModel);

		// All means load all users in all pharmacies..
		
		if(ALL_VALUE.equalsIgnoreCase(userStationIds)){
			
			visnSelectModelList.addAll(trackMessageService.getVisns());
		}
		else{
			
			List<String> stationIdsList = new ArrayList<String>(Arrays.asList(userStationIds.split(",")));
			
			visnSelectModelList.addAll(trackMessageService.getSelectedVisns(stationIdsList));
		}
		
		return visnSelectModelList;
	}
	
	@RequestMapping(value = "/getStationIdsForSelect", method = RequestMethod.GET, produces = "application/json")
	@CacheControl(policy = {CachePolicy.NO_CACHE})
	@ResponseBody
	public List<StationIdSelectModel> getStationIdsForSelect(HttpServletRequest request, @RequestParam("visn") String visn)
			throws JsonParseException, JsonMappingException, IOException {
		

		List<StationIdSelectModel> stationIdSelectModelList = new ArrayList<StationIdSelectModel>();
		
		StationIdSelectModel stationIdSelectModel = new StationIdSelectModel();
		
		stationIdSelectModel.setId("All");
		
		stationIdSelectModel.setLabel("All");
		
		stationIdSelectModelList.add(stationIdSelectModel);
		
		
		
		
		if (visn.equalsIgnoreCase("/")) {
			visn = "";
		}
		
		
		List<PharmacyEntity> pharmacyStationIdsList = null;
		
		String userStationIds = getUserStationIds(request);
		
		// All means load all users in all pharmacies..
		
		if(ALL_VALUE.equalsIgnoreCase(userStationIds)){
			
			 pharmacyStationIdsList = pharmacyService.getStationIdsByVisn(visn);
		}
		else{
			
			List<String> stationIdsList = new ArrayList<String>(Arrays.asList(userStationIds.split(",")));
			
			pharmacyStationIdsList = pharmacyService.getSelectedStationIdsByVisn(visn, stationIdsList);
		}
				
		
		for(PharmacyEntity pharm: pharmacyStationIdsList){
			
			StationIdSelectModel stationIdModel = new StationIdSelectModel();
			
			stationIdModel.setId(pharm.getVaStationId());
			stationIdModel.setLabel(pharm.getVaStationId());
			stationIdSelectModelList.add(stationIdModel);
		}
		
		
		
		
		return stationIdSelectModelList;
	}
	
	private String getUserStationIds( HttpServletRequest request){
		
		String userStationIds = "";// Empty String to avoid NPE.
		
		HttpSession session = request.getSession(false);
		
		if(null!=session.getAttribute("USER_STATIONS_IDS")){
			
			userStationIds = (String)session.getAttribute("USER_STATIONS_IDS");
		}
		
		if(StringUtils.isBlank(userStationIds)){
		
			Authentication  authentication = SecurityContextHolder.getContext().getAuthentication();	
					
			VaUser currentUser = userService.findByVAUserID((String)authentication.getPrincipal());
			
			userStationIds = currentUser.getVaStationIds();
			
		}
		
		
		return userStationIds;
	}
	
	
}
