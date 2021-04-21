package gov.va.med.pharmacy.web.track;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.json.JsonSanitizer;

import gov.va.med.pharmacy.persistence.model.VaUser;
import gov.va.med.pharmacy.persistence.report.VisnSelectModel;
import gov.va.med.pharmacy.persistence.service.TrackMessageService;
import gov.va.med.pharmacy.persistence.service.UserService;
import gov.va.med.pharmacy.persistence.track.NcpdpMessageListModel;
import gov.va.med.pharmacy.persistence.track.NcpdpMessageModel;
import gov.va.med.pharmacy.web.csv.CSVSupportBean;
import gov.va.med.pharmacy.web.csv.CSVView;
import net.rossillo.spring.web.mvc.CacheControl;
import net.rossillo.spring.web.mvc.CachePolicy;

@Controller
@RequestMapping(value = "/track")
public class TrackRxController {
	
	private static final String MBM_741CHE = "741CHE";

	private static final String MBM_741DUB = "741DUB";

	private static final String ALL_VALUE = "All";
	
	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(TrackRxController.class);

	@Autowired
	private TrackMessageService trackMessageService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/main")	
	public ModelAndView getMainPage(HttpServletRequest request) {
		
		Authentication  authentication = SecurityContextHolder.getContext().getAuthentication();	
		
		VaUser currentUser = userService.findByVAUserID((String)authentication.getPrincipal());
		
		HttpSession session = request.getSession(false);
		
		session.removeAttribute("USER_STATIONS_IDS");
		 
		session.setAttribute("USER_STATIONS_IDS", currentUser.getVaStationIds());
		
		ModelAndView view = new ModelAndView("trackeRx");
		
		List<VisnSelectModel>  visnList = getVisnSelect(currentUser.getVaStationIds());
		
		view.addObject("trackVisnList", visnList);
		
		return view;
	}
	
	
	private static final String[] TRACK_AUDIT_HEADERS = { "eRx Reference #", "Message Type", "Patient Name", "Patient DOB", "Patient SSN", "Drug Prescribed", "Message Id", "Prescriber Name", "Prescriber NPI","Prescriber DEA", "VISN", "Station ID", "Pharmacy Name", "Address", 
            "Relates to Message ID", "Received Date","Patient AutoCheck Status","Provider AutoCheck Status",
            "Drug AutoCheck Status","Message Status"};
	
	@RequestMapping(value = "/getMessage", method = RequestMethod.POST, produces = "application/json")
	@CacheControl(policy = {CachePolicy.NO_CACHE})
	@ResponseBody
	public NcpdpMessageModel getMessage(HttpServletRequest request, @RequestParam("json") String json)
			throws JsonParseException, JsonMappingException, IOException {

		String jsonString = JsonSanitizer.sanitize(json); // Sanitize the JSON coming from client
		
		ObjectMapper jsonMapper = new ObjectMapper();
		
		JsonNode node = jsonMapper.readValue(jsonString, JsonNode.class);
		
		String messageId = node.get("messageId").asText();

		String inboundOutbound = node.get("inboundOutbound").asText();
		
		String relatedMsgSearch = node.get("relatedMsgSearch").asText();

		return trackMessageService.findByMessageId(messageId, inboundOutbound, relatedMsgSearch);
	}
	
	// IAM request filtering issue fix -  Change form get to post method
	@RequestMapping(value = "/getMessages", method = RequestMethod.POST, produces = "application/json")
	@CacheControl(policy = {CachePolicy.NO_CACHE})
	
	public ModelAndView getMessages(HttpServletRequest request, @RequestParam("json") String json)
			throws JsonParseException, JsonMappingException, IOException {
		ModelAndView mav = new ModelAndView(new org.springframework.web.servlet.view.json.MappingJackson2JsonView());
		
		// Refactored code into a method to be shared between the UI and the CSV as both use same parameters to avoid code duplication.
		List<NcpdpMessageListModel> eRxMessageList = trackAuditSearch(request,json);
		
		mav.addObject("items", eRxMessageList);
		
		return mav;
	}


	private List<NcpdpMessageListModel> trackAuditSearch(HttpServletRequest request,String json)
			throws IOException, JsonParseException, JsonMappingException {
		String jsonString = JsonSanitizer.sanitize(json); // Sanitize the JSON coming from client
			
		ObjectMapper jsonMapper = new ObjectMapper();
		String messageType = "";
		String messageId = "%";
		String relatesToId = "%";
		String visn = "";
		String vaStationId = "";
		String fromDate = "";
		String toDate = "";
		String patientSsn = "";
		String patientSSN2017071 ="";
		String patientLastName = "%";
		String patientFirstName = "%";
		String patientDob = "";
		String prescriberNpi = "%";
		String prescriberLastName = "%";
		String prescriberFirstName = "%";
		String prescriberDEA2 = "%";
		String prescribedDrug = "%";
		String messageStatus = "";
		String inboundNcpdpMsgId = "%";
		String inboundOutbound = "";
		String numberOfRecords = "100"; // set default value to 100 records.
		
		JsonNode node = jsonMapper.readValue(jsonString, JsonNode.class);
		if (node.get("inboundNcpdpMessageId") != null){
			inboundNcpdpMsgId = node.get("inboundNcpdpMessageId").asText().trim() + '%';};
		if (node.get("messageType") != null){
			messageType = node.get("messageType").asText();}
		if (node.get("messageId") != null){
			messageId = node.get("messageId").asText().trim() + '%';}	
		if (node.get("relatedMessageId") != null){
			relatesToId = node.get("relatedMessageId").asText().trim() + '%';}
		if (node.get("trackauditVisnSelection") != null){
			visn = node.get("trackauditVisnSelection").asText();}
		if (node.get("pharmacyVaStationId") != null){
			vaStationId = node.get("pharmacyVaStationId").asText().trim(); }
		if (node.get("dateFrom") != null){
			fromDate = node.get("dateFrom").asText();}
		if (node.get("dateTo") != null){
			toDate = node.get("dateTo").asText();}
		if (node.get("patientSsn") != null){
			
			patientSSN2017071 = node.get("patientSsn").asText().trim();
			
			patientSsn = node.get("patientSsn").asText().trim().replace("-", "");
			}
		if (node.get("patientLastName") != null){
			patientLastName = node.get("patientLastName").asText().toUpperCase().trim() + '%';}
		if (node.get("patientFirstName") != null){
			patientFirstName = node.get("patientFirstName").asText().toUpperCase().trim() + '%';}
		if (node.get("patientDob") != null){
			patientDob = node.get("patientDob").asText();}
		if (node.get("prescriberNPI") != null){
			prescriberNpi = node.get("prescriberNPI").asText().trim() + '%';}
		if (node.get("prescriberLastName") != null){
			prescriberLastName = node.get("prescriberLastName").asText().toUpperCase().trim() + '%';}
		if (node.get("prescriberFirstName") != null){
			prescriberFirstName = node.get("prescriberFirstName").asText().toUpperCase().trim() + '%';}
		if (node.get("prescriberDEA2") != null){
			prescriberDEA2 = node.get("prescriberDEA2").asText().toUpperCase().trim() + '%';}
		if (node.get("prescribedDrug") != null){
			prescribedDrug = node.get("prescribedDrug").asText().toUpperCase().trim() + '%';}
		if (node.get("messageStatus") != null){
			messageStatus = node.get("messageStatus").asText();}
		if (node.get("inboundOutbound") != null){
			inboundOutbound = node.get("inboundOutbound").asText();	
		}
		
		// get record size.
		
		if (node.get("recordSizeValue") != null){
			
			numberOfRecords = node.get("recordSizeValue").asText();
		}
		
		
		// before doing search check if user has MbM station Id, otherwise return blank result.
		
		List<NcpdpMessageListModel> eRxMessageList = new ArrayList<NcpdpMessageListModel>();
		
		String userStationIds = getUserStationIds(request);
		
		// MBM - Meds by Mail.		
		boolean mbmSearchAllowed = false;		
		
		if(!ALL_VALUE.equalsIgnoreCase(userStationIds)){
			
			List<String> stationIdsList = new ArrayList<String>(Arrays.asList(userStationIds.split(",")));
			
			List<String> mbmList = new ArrayList<String>();
			
			mbmList.add(MBM_741DUB);
			
			mbmList.add(MBM_741CHE);			
			
			mbmSearchAllowed = CollectionUtils.containsAny(stationIdsList, mbmList);
		}
		else if(ALL_VALUE.equalsIgnoreCase(userStationIds)){
			
			mbmSearchAllowed = true;
		}
			eRxMessageList = trackMessageService.searchMessages(messageType, messageId, relatesToId, visn, vaStationId, fromDate, toDate, patientSsn, patientLastName,
						patientFirstName, patientDob, prescriberNpi, prescriberLastName, prescriberFirstName, prescriberDEA2, prescribedDrug, messageStatus, inboundNcpdpMsgId,
						inboundOutbound, mbmSearchAllowed, numberOfRecords, patientSSN2017071);
			
		
		return eRxMessageList;
	}
	
	private List<VisnSelectModel> getVisnSelect(String userStationIds)	{

		List<VisnSelectModel> visnSelectModelList = new ArrayList<VisnSelectModel>();
		
		VisnSelectModel visnSelectModel = new VisnSelectModel();
	
		visnSelectModel.setId(ALL_VALUE);
		visnSelectModel.setLabel(ALL_VALUE);
		visnSelectModelList.add(visnSelectModel);
		
		
		if(ALL_VALUE.equalsIgnoreCase(userStationIds)){
					
					visnSelectModelList.addAll(trackMessageService.getVisns());
				}
				else{
					
					List<String> stationIdsList = new ArrayList<String>(Arrays.asList(userStationIds.split(",")));
					
					visnSelectModelList.addAll(trackMessageService.getSelectedVisns(stationIdsList));
		}
		
		
		return visnSelectModelList;
	}

	
	@RequestMapping(value = "/getTrackAuditListCSV", method = {RequestMethod.GET})
	public void csvExport(HttpServletRequest request, @RequestParam("json") String json,HttpServletResponse response) 
			throws JsonParseException, JsonMappingException, IOException{
		
		try {
			
					
			String csvFileName = "TrackAudit.csv";
			
			String responseHeaderKey = "Content-Disposition";
			
			String responseHeaderValue = String.format("attachment; filename=\"%s\"",   csvFileName);
			
			List<NcpdpMessageListModel> eRxMessageList = trackAuditSearch(request,json);
			
			String[][] csvData = null;
			
			if (null != eRxMessageList && eRxMessageList.size() > 0) {

				csvData = populateDataRows(eRxMessageList, TRACK_AUDIT_HEADERS);
				
				csvData = populateTotalDataRows(csvData,eRxMessageList, false);
				
			} else {

				List<NcpdpMessageListModel> eRxMessageEmptyList = new ArrayList<NcpdpMessageListModel>();

				NcpdpMessageListModel emptyBean = new NcpdpMessageListModel();
				eRxMessageEmptyList.add(emptyBean);

				csvData = populateDataRows(eRxMessageEmptyList, TRACK_AUDIT_HEADERS);
				
				csvData = populateTotalDataRows(csvData,eRxMessageEmptyList, true);

			}
			
			response.setContentType("text/csv");
			
			response.setHeader(responseHeaderKey, responseHeaderValue);
			
			CSVSupportBean csvSupportBean = new CSVSupportBean();

			csvSupportBean.setHeaderRow(TRACK_AUDIT_HEADERS);

			csvSupportBean.setDataRows(csvData);

			Map<String, Object> csvModel = csvSupportBean.createModel();

			CSVView view = new CSVView();

			String data = view.getStringRepresentation(csvModel);

			response.getOutputStream().print(data);			

			response.getOutputStream().flush();		
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
			LOG.error("Error while generating Track Audit CSV", e.getMessage());
		}
		
		
	}
	
	
	private String[][] populateDataRows(List<NcpdpMessageListModel> rows, String[] headers) {
		// + 1 for the totals as the last row
		String[][] dataRows = new String[rows.size()+1][headers.length];
		for (int i = 0; i < rows.size(); i++) {
			
			String[] row = ((NcpdpMessageListModel) rows.get(i)).getStringArray();
						
			for (int j = 0; j < headers.length; j++) {
				
				dataRows[i][j] = row[j];
				
			}
		}
		
		return dataRows;
		
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
	
	
	@RequestMapping(value = "/getRelatedMessages", method = RequestMethod.GET, produces = "application/json")
	@CacheControl(policy = {CachePolicy.NO_CACHE})	
	public ModelAndView getRelatedMessages(HttpServletRequest request, @RequestParam("messageId") String messageId)
			throws JsonParseException, JsonMappingException, IOException {
		ModelAndView mav = new ModelAndView(new org.springframework.web.servlet.view.json.MappingJackson2JsonView());
		
		//String inboundNcpdpMsgId = "%";
		String inboundNcpdpMsgId = "";
		
		if (messageId != null){
			//inboundNcpdpMsgId = messageId + '%';
			inboundNcpdpMsgId = messageId;
		}
		
		// before doing search check if user has MbM station Id, otherwise return blank result.
		
		List<NcpdpMessageListModel> eRxMessageList = new ArrayList<NcpdpMessageListModel>();
		
		// MBM - Meds by Mail search allowed check is not needed for related messages, 
		// because the detail page will only be shown to the users who have either MBM or all access.
		
		eRxMessageList = trackMessageService.searchRelatedMessages(inboundNcpdpMsgId);
		
		mav.addObject("items", eRxMessageList);
		
		return mav;
	}
	
	private String[][] populateTotalDataRows(String[][] csvData,List<NcpdpMessageListModel> rows, boolean noRecordFound) {
		
		int totalHeader = 1;
		
		String[][] totalsArray = {{"",""}, {"Number of Records:",""}}; // to add space after records, first row is empty.
		
		String[][] newDataRows =  new String[csvData.length+totalsArray.length][totalHeader];
		
		if(noRecordFound == true){
			
			totalsArray[1][1] = "0";
		}
		else{
		
			totalsArray[1][1] = String.valueOf(rows.size());
		}
		
		
		System.arraycopy(csvData, 0, newDataRows, 0, csvData.length);
		
		System.arraycopy(totalsArray, 0, newDataRows, csvData.length, totalsArray.length);
		
		
		return newDataRows;
		
	}

}
