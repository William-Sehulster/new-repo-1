package gov.va.med.pharmacy.web.administration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gov.va.med.pharmacy.persistence.model.PharmacyEntity;
import gov.va.med.pharmacy.persistence.model.VaUser;
import gov.va.med.pharmacy.persistence.report.StationIdSelectModel;
import gov.va.med.pharmacy.persistence.service.PharmacyService;
import gov.va.med.pharmacy.persistence.service.UserService;
import gov.va.med.pharmacy.web.ResponseMessage;
import gov.va.med.pharmacy.web.administration.view.UserManagementModel;

@Controller
@RequestMapping(value = "/manageUsers")
public class UserManagementController {

	private static final String EMPTY_STRING = " ";

	private static final String ALL_VALUE_WITH_SPACE = " All ";

	private static final String ALL_VALUE = "All";

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(UserManagementController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private PharmacyService pharmacyService;
	
	private final static String USER_MANAGEMENT_MODEL = "userManagementModel";
	
	// using this character pattern as name can also contain hypen. 
	private static final String CARET = "^";

    private static final String TILDE = "~";
    
    private final static String USER_MANAGEMENT_TILES_VIEW = "manageusers.homepage";
	

	final private String[] DISALLOWED_FIELDS = new String[] { "updatedDate", "createdDate", "_csrf" };

	// TO-DO update with fields not to bind from form.
	@InitBinder
	public void initBinderFields(WebDataBinder binder) {
		binder.setDisallowedFields(DISALLOWED_FIELDS);
	}

	@RequestMapping(value = "/main")
	public ModelAndView getMainPage(HttpServletRequest request, @ModelAttribute(USER_MANAGEMENT_MODEL) UserManagementModel userManagementModel, BindingResult result, Model model) {

		ModelAndView mav = new ModelAndView(USER_MANAGEMENT_TILES_VIEW);

		 List<UserManagementModel> userRoles = getUsersAndRoles();
		 
		 // populate station ids.
		 
		 List<StationIdSelectModel> stationIdsList = getAllStationIds();
		 
	    mav.addObject("userMgmtStationIds", stationIdsList);

		mav.addObject("userMgmt", userRoles);
		
		

		return mav;
	}

	private List<StationIdSelectModel> getAllStationIds() {
		List<StationIdSelectModel> stationIdsList = new ArrayList<StationIdSelectModel>();
		 
		 List<PharmacyEntity> VaPharmacyStations = pharmacyService.getAllStations();
		 
		
         StationIdSelectModel emptytModel = new StationIdSelectModel();
		 
         emptytModel.setId(EMPTY_STRING);
		
         emptytModel.setLabel(EMPTY_STRING);
		 
		 stationIdsList.add(emptytModel);
		 
		 
		 // Set All value for drop down.
		 StationIdSelectModel stationIdSelectModel = new StationIdSelectModel();
		 
		 stationIdSelectModel.setId(ALL_VALUE);
		
		 stationIdSelectModel.setLabel(ALL_VALUE_WITH_SPACE);
		 
		 stationIdsList.add(stationIdSelectModel);
		 
		 
		 StringBuffer tempBuf;
		 // Get other values for the drop down.
		 for(PharmacyEntity pharmacy: VaPharmacyStations){
			 
			 StationIdSelectModel station = new StationIdSelectModel();
			 
			 tempBuf = new StringBuffer();
			 
			 tempBuf.append(pharmacy.getDivisionName()).append(" - ").append(pharmacy.getVaStationId());
			 
			 station.setLabel(tempBuf.toString());
			 
			 station.setId(pharmacy.getVaStationId());
			 
			 stationIdsList.add(station);
			 
		 }
		 
		 tempBuf = null;
		return stationIdsList;
	}

	private List<UserManagementModel> getUsersAndRoles() {
		
		// Filter user list by the logged in user's station ids.
		
		Authentication  authentication = SecurityContextHolder.getContext().getAuthentication();	
		
		List<VaUser> userList;
		
		VaUser currentUser = userService.findByVAUserID((String)authentication.getPrincipal());
		
		
		// All means load all users in all pharmacies..
		
		if(ALL_VALUE.equalsIgnoreCase(currentUser.getVaStationIds())){
			
			userList = userService.findAllUsers();
		}
		else{
			
			List<String> stationIdsList = new ArrayList<String>(Arrays.asList(currentUser.getVaStationIds().split(",")));
			
			userList = userService.getUsersByStationIds(currentUser.getVaStationIds(),stationIdsList);
		}
		
		

		List<UserManagementModel> userRoles = new ArrayList<UserManagementModel>();

		for (VaUser user : userList) {

			UserManagementModel userModel = new UserManagementModel();

			userModel.setFirstName(StringUtils.isEmpty(user.getFirstName())?"":user.getFirstName());
			userModel.setLastName(StringUtils.isEmpty(user.getLastName())?"":user.getLastName());
			userModel.setUserName(user.getVaUserid());
			userModel.setPharmMgr(user.getIsPharmMgr());
			userModel.setPbmAdmn(user.getIsPbmAdmn());
			userModel.setPharmUser(user.getIsPharmUser());
			userModel.setSystemAdmn(user.getIsSystemAdmn());
			userModel.setUserEnabled(user.getIsEnabled());
			
			userModel.setStationIds(user.getVaStationIds());
			
			userModel.setRecId(String.valueOf(user.getUsersId()));// this  shouldn't  null.

			userRoles.add(userModel);
		}
		return userRoles;
	}

	/**
	 * Tries to save add user and modify user with single action.
	 * 
	 */
    @RequestMapping(value = "/saveUserData",  method = RequestMethod.POST)
    public ModelAndView saveUsers(HttpServletRequest request, @ModelAttribute(USER_MANAGEMENT_MODEL) @Valid UserManagementModel userManagementModel, BindingResult result, RedirectAttributes redirectAttributes) {
        
    	ResponseMessage responseMessage = new ResponseMessage();
    	
    	List<String> errorsList = new ArrayList<String>();
    	
    	 ModelAndView mav = new ModelAndView(USER_MANAGEMENT_TILES_VIEW);
    	 
    	 if (StringUtils.isEmpty(userManagementModel.getModifiedIds()) && StringUtils.isEmpty(userManagementModel.getAddUserText()) && StringUtils.isEmpty(userManagementModel.getModifiedFields())
    			 && StringUtils.isEmpty(userManagementModel.getEnableDisableRecords())  && StringUtils.isEmpty(userManagementModel.getModifiedStationIds())){
    	
    		 result.addError(new ObjectError(USER_MANAGEMENT_MODEL, "Unable to save. User must be added or modified."));
    	 }
    	 
    	 // Show only if a new user is being added.
    	 if (StringUtils.isEmpty(userManagementModel.getStationIdsSelected()) && StringUtils.isNotEmpty(userManagementModel.getAddUserText()) ){
    	    	
    		 result.addError(new ObjectError(USER_MANAGEMENT_MODEL, "Unable to save. Station Id is required."));
    	 }
    	 
    	
        // we need to check before processing and after processing if there were any errors.
        if (result.hasErrors()) {
        	
        	List<ObjectError> errors = result.getAllErrors();
			 
			 for (ObjectError objectError : errors) {
				 errorsList.add(objectError.getDefaultMessage());
			 }
			 
			   responseMessage.setErrorMessage(errorsList);
			   mav.addObject("data",responseMessage );
			   
			   List<UserManagementModel> userRoles = getUsersAndRoles();

			   mav.addObject("userMgmt", userRoles);
			   
			   // populate station ids.
			   List<StationIdSelectModel> stationIdsList = getAllStationIds();
				 
			   mav.addObject("userMgmtStationIds", stationIdsList);
			 
            return mav;
        }

        processForm(userManagementModel, result, redirectAttributes, responseMessage);
        
        List<UserManagementModel> userRoles = getUsersAndRoles();

		mav.addObject("userMgmt", userRoles);
		
		   
		   // populate station ids.
		   List<StationIdSelectModel> stationIdsList = getAllStationIds();
			 
		   mav.addObject("userMgmtStationIds", stationIdsList);
        
        if (result.hasErrors()) {

        	List<ObjectError> errors = result.getAllErrors();
			 
			 for (ObjectError objectError : errors) {
				 errorsList.add(objectError.getDefaultMessage());
			 }
			 
			 responseMessage.setErrorMessage(errorsList);
			 mav.addObject("data",responseMessage );
			 
            return mav;
        }
       
        mav.addObject("data",responseMessage );
        
         
        return mav;
    }

    /**
     * Process form. Handles the processing of the data entered by the user.
     * 
     * @param userManagementModel the user settings model
     * @param result the result
     */
    private void processForm(UserManagementModel userManagementModel,  BindingResult result, RedirectAttributes redirectAttributes, ResponseMessage responseMessage) {
        
        
        // update data

        // Load modified ids list and process
        String modifiedIds = userManagementModel.getModifiedIds();
        
        String modifiedFields = userManagementModel.getModifiedFields();
        
        String modifiedStationdIds = userManagementModel.getModifiedStationIds();
        
        String enableDisableRecords = userManagementModel.getEnableDisableRecords();
        
        LinkedHashMap<String, VaUser> enableDisableRecordsMap = new LinkedHashMap<String,VaUser>();
        
        LinkedHashMap<String, VaUser> updatedUsersMap = new LinkedHashMap<String,VaUser>(); 
        
         // get logged in user.
		Authentication  authentication = SecurityContextHolder.getContext().getAuthentication();	
		
		boolean enableDisableOP = false;
		boolean updateOP = false;
	
		String modifiedByUser = null;
	
		if(authentication!=null){
			
			modifiedByUser = (String)authentication.getPrincipal();
					
		}
        
        try {
        
        	
               // disable records first.
        	   if (enableDisableRecords != null && enableDisableRecords.length() > 0) {
                   

                   String[] enableDisableIds = enableDisableRecords.split(",");
                   
                   long recordId = 0;
                  
                       
                       String id = null;
                       
                       for (String str : enableDisableIds) {
                           
                           id = str.substring(str.indexOf(TILDE)+1, str.indexOf(CARET));
                           recordId = Long.valueOf(id.trim());
                           
                           if(enableDisableRecordsMap.containsKey(id)){
                               
                               // if it already exists update the map values.
                               
                               VaUser vaUser = enableDisableRecordsMap.get(id);
                                  
                               
                               vaUser.setUpdatedDate(new java.util.Date());
                               
                               vaUser.setUpdatedBy(modifiedByUser);
                               
                               enableDisableRecordsMap.put(id, vaUser);
                               
                           }
                           else
                           {
                               VaUser vaUser = new VaUser();
                               
                               vaUser.setUsersId(recordId);                        
                               
                               
                               vaUser.setUpdatedDate(new java.util.Date());
                               
                               vaUser.setUpdatedBy(modifiedByUser);
                               
                               vaUser.setIsEnabled(Boolean.valueOf(false));
                               
                               enableDisableRecordsMap.put(id, vaUser);
                           }
                           
                       }
                       
               } 	
        	
        	
        if (modifiedIds != null && modifiedIds.length() > 0) {
           

            String[] updateIds = modifiedIds.split(",");
            
            long recordId = 0;
           
                
                String id = null;
                String role = null;
                String roleValue = null; 
                
                for (String str : updateIds) {
                    
                    id = str.substring(str.indexOf(TILDE)+1, str.indexOf(CARET));
                    role = str.substring(0, str.indexOf(TILDE)) ;                   
                    roleValue = str.substring(str.indexOf(CARET)+1, str.length());
                    recordId = Long.valueOf(id.trim());
                    
                    if(updatedUsersMap.containsKey(id)){
                        
                        // if it already exists update the map values.
                        
                        VaUser vaUser = updatedUsersMap.get(id);
                        
                                                
                        if(StringUtils.isNotEmpty(role) && role.contains("pharmManagerRow")){
                        	vaUser.setIsPharmMgr(Boolean.valueOf(roleValue));
                        }
                        else if(StringUtils.isNotEmpty(role) && role.contains("pbmAdminRow")){
                        	vaUser.setIsPbmAdmn(Boolean.valueOf(roleValue));
                        }
                        else if(StringUtils.isNotEmpty(role) && role.contains("pharmUserRow")){
                        	vaUser.setIsPharmUser(Boolean.valueOf(roleValue));
                        }
                        
                        else if(StringUtils.isNotEmpty(role) && role.contains("administratorRow")){
                        	vaUser.setIsSystemAdmn(Boolean.valueOf(roleValue));
                        }
                        
                        vaUser.setUpdatedDate(new java.util.Date());
                        
                        vaUser.setUpdatedBy(modifiedByUser);
                        
                        updatedUsersMap.put(id, vaUser);
                        
                    }
                    else
                    {
                        VaUser vaUser = new VaUser();
                        
                        vaUser.setUsersId(recordId);                        
                        
                        
                        if(StringUtils.isNotEmpty(role) && role.contains("pharmManagerRow")){
                        	vaUser.setIsPharmMgr(Boolean.valueOf(roleValue));
                        }
                        else if(StringUtils.isNotEmpty(role) && role.contains("pbmAdminRow")){
                        	vaUser.setIsPbmAdmn(Boolean.valueOf(roleValue));
                        }
                        else if(StringUtils.isNotEmpty(role) && role.contains("pharmUserRow")){
                        	vaUser.setIsPharmUser(Boolean.valueOf(roleValue));
                        }
                        else if(StringUtils.isNotEmpty(role) && role.contains("administratorRow")){
                        	vaUser.setIsSystemAdmn(Boolean.valueOf(roleValue));
                        }
                        
                        vaUser.setUpdatedDate(new java.util.Date());
                        
                        vaUser.setUpdatedBy(modifiedByUser);
                        
                        updatedUsersMap.put(id, vaUser);
                    }
                    
                }
                
               
                
        }
        
        // check for modified names.
        if (modifiedFields != null && modifiedFields.length() > 0) {
        	
        	 String[] updateFields = modifiedFields.split(",");
             
              long recordId = 0;
            
                 
                 String id = null;
                 String name = null;
                 String nameValue = null; 
                 
                 for (String str : updateFields) {
                	 
                	 id = str.substring(str.indexOf(TILDE)+1, str.indexOf(CARET));
                	 name = str.substring(0, str.indexOf(TILDE)) ;                   
                	 nameValue = str.substring(str.indexOf(CARET)+1, str.length());
                     recordId = Long.valueOf(id.trim());
                     
                     
                     if(updatedUsersMap.containsKey(id)){
                         
                         // if it already exists update the map values.
                         
                         VaUser vaUser = updatedUsersMap.get(id);
                         
                                                 
                         if(StringUtils.isNotEmpty(name) && name.contains("firstNameRow")){
                        	 vaUser.setFirstName(nameValue);
                         }
                         else if(StringUtils.isNotEmpty(name) && name.contains("lastNameRow")){
                        	 vaUser.setLastName(nameValue);
                         }
                         else if(StringUtils.isNotEmpty(name) && name.contains("userIDRow")){
                        	 //convert user id on update to upper case for consistency.
                        	 vaUser.setVaUserid(nameValue.toUpperCase());
                         }
                         else if(StringUtils.isNotEmpty(name) && name.contains("userIDRow")){
                        	 //convert user id on update to upper case for consistency.
                        	 vaUser.setVaUserid(nameValue.toUpperCase());
                         }
                                              
                         vaUser.setUpdatedDate(new java.util.Date());
                         
                         vaUser.setUpdatedBy(modifiedByUser);
                         
                         updatedUsersMap.put(id, vaUser);
                         
                     }
                     else
                     {
                         VaUser vaUser = new VaUser();
                         
                         vaUser.setUsersId(recordId);                        
                         
                         
                         if(StringUtils.isNotEmpty(name) && name.contains("firstNameRow")){
                         	vaUser.setFirstName(nameValue);
                         }
                         else if(StringUtils.isNotEmpty(name) && name.contains("lastNameRow")){
                         	vaUser.setLastName(nameValue);
                         } 
                         else if(StringUtils.isNotEmpty(name) && name.contains("userIDRow")){
                        	 //convert user id on update to upper case for consistency.
                        	 vaUser.setVaUserid(nameValue.toUpperCase());
                         }
                         
                         vaUser.setUpdatedDate(new java.util.Date());
                         
                         vaUser.setUpdatedBy(modifiedByUser);
                         
                         updatedUsersMap.put(id, vaUser);
                     }
                     
                 }
                	 
                 
        	
        }
        
        // check for modified stations ids.
        if (modifiedStationdIds != null && modifiedStationdIds.length() > 0) {
        	
        	 String[] updateStationIds = modifiedStationdIds.split("-");
             
              long recordId = 0;
            
                 
                 String id = null;
                 String name = null;
                 String stationIdValue = null; 
                 
                 for (String str : updateStationIds) {
                	 
                	 id = str.substring(str.indexOf(TILDE)+1, str.indexOf(CARET));
                	 name = str.substring(0, str.indexOf(TILDE)) ;                   
                	 stationIdValue = str.substring(str.indexOf(CARET)+1, str.length());
                     recordId = Long.valueOf(id.trim());
                     
                     
                     if(updatedUsersMap.containsKey(id)){
                         
                         // if it already exists update the map values.
                         
                         VaUser vaUser = updatedUsersMap.get(id);
                         
                                                 
                         if(StringUtils.isNotEmpty(name) && name.contains("stationIDRow")){
                        	 vaUser.setVaStationIds(stationIdValue);
                         }
                        
                                              
                         vaUser.setUpdatedDate(new java.util.Date());
                         
                         vaUser.setUpdatedBy(modifiedByUser);
                         
                         updatedUsersMap.put(id, vaUser);
                         
                     }
                     else
                     {
                         VaUser vaUser = new VaUser();
                         
                         vaUser.setUsersId(recordId);                        
                         
                         if(StringUtils.isNotEmpty(name) && name.contains("stationIDRow")){
                        	 vaUser.setVaStationIds(stationIdValue);
                         }
                         
                         vaUser.setUpdatedDate(new java.util.Date());
                         
                         vaUser.setUpdatedBy(modifiedByUser);
                         
                         updatedUsersMap.put(id, vaUser);
                     }
                     
                 }
                	 
                 
        	
        }
        
        List<VaUser> enableDisableUsers = new ArrayList<VaUser>(enableDisableRecordsMap.values());
        
        if (enableDisableUsers.size() > 0){
        	
        	userService.enableDisableteUsers(enableDisableUsers);
        	
        	enableDisableOP = true;
        	
        }    
        
        
        // update the users
        List<VaUser> records = new ArrayList<VaUser>(updatedUsersMap.values());
        
       if (records.size() > 0){
        	
        	userService.updateUsers(records);
        	
        	updateOP = true;
        	
        	
        }    
       
      if (updateOP == true) {
    	  
    	  responseMessage.setSuccessMessage("Records updated successfully.");
      }
        
      else if(enableDisableOP == true){
    	   
    	   responseMessage.setSuccessMessage("Records updated successfully.");
       }
       
       else{
    	   responseMessage.setSuccessMessage("Records updated successfully.");
       }
       
          // one exception for any error (add, update or delete).
       
        } catch (Exception ex) {
            result.addError(new ObjectError(USER_MANAGEMENT_MODEL, "A system problem is preventing the action to update the user at this time.  Please report this error to the  production support."));
           
        }
        
       

        // add new user.
        
        String userRoles  = userManagementModel.getUserRolesSelect();
        String addUserText = userManagementModel.getAddUserText();
        
        String userFirstName = userManagementModel.getAddFirstNameText();
        String userLastName  = userManagementModel.getAddLastNameText();
        
        String vaStationAssigned  = userManagementModel.getStationIdsSelected();
        
        String[] userRolesArray = null;
        // Add approver user if text exists in add user text field
        if (addUserText != null && addUserText.length() > 0) {

            try {
                String userName = addUserText.trim();
                userName = userName.toUpperCase();
                                       
                // Check the users table for existing record
                VaUser user = userService.findByVAUserID(userName);
                
                if (user != null) {
                    // If there is an existing user, return an error message.          
                    result.addError(new ObjectError(USER_MANAGEMENT_MODEL, "The user you are attempting to add already exists. Please review and/or update this user's existing settings."));
                    responseMessage.setSuccessMessage("");
                }
                else{
	            	  VaUser newUser = new VaUser();
	            	  
	            	     // set default values
	            	    newUser.setIsPharmMgr(Boolean.FALSE);
	                    newUser.setIsPbmAdmn(Boolean.FALSE);
	                    newUser.setIsPharmUser(Boolean.FALSE);
	                    newUser.setIsSystemAdmn(Boolean.FALSE);
	                    newUser.setIsEnabled(Boolean.TRUE);
	                    newUser.setVaStationIds(ALL_VALUE);
	                    
	            	  
	                if(StringUtils.isNotBlank(userRoles))
	                {
	            	   userRolesArray = userRoles.split(",");
	            	   
	            	   for (String str : userRolesArray) {
	            		   
	            		       if("pharmMgr".equals(str)){
	            			       newUser.setIsPharmMgr(Boolean.TRUE);
	                           }
	                           else if("pbmAdmn".equals(str)){
	                        	   newUser.setIsPbmAdmn(Boolean.TRUE);
	                           }
	                           else if("pharmUser".equals(str)){
	                        	   newUser.setIsPharmUser(Boolean.TRUE);
	                           }
	                           else if("systemAdmn".equals(str)){
	                        	   newUser.setIsSystemAdmn(Boolean.TRUE);
	                           }
	                   }
	               }
                  
	                if(StringUtils.isNotBlank(userFirstName)){
	                	
	                	 newUser.setFirstName(userFirstName);
	                }
	                
	                if(StringUtils.isNotBlank(userLastName)){
	                	
	                	 newUser.setLastName(userLastName);
	                }
	                
	                if(StringUtils.isNotBlank(vaStationAssigned)){
	                	
	                	newUser.setVaStationIds(vaStationAssigned);
	                }
	                
                    newUser.setVaUserid(userName);
                    newUser.setCreatedDate(new java.util.Date());
                    newUser.setUpdatedDate(new java.util.Date());
                    
                    
                    // get logged in user.
        			if(authentication!=null){
        				
        				String createdByUser = (String)authentication.getPrincipal();
        				newUser.setUpdatedBy(createdByUser);
        				newUser.setCreatedBy(createdByUser);
        			}
                    
        			 
                    userService.addNewVAUser(newUser);
                    
                   // If add only operation with neither update or delete
                    
                    if(enableDisableOP == false && updateOP == false){
                 	   
                    	responseMessage.setSuccessMessage("User information added successfully.");
                    }
                    
                    else{
                 	   responseMessage.setSuccessMessage("Records updated successfully.");
                    }
                    
                   
                }
               
                
            } catch (Exception ex) {
                
                result.addError(new ObjectError(USER_MANAGEMENT_MODEL, "A system problem is preventing the action to add a new user at this time.  Please report this error to the production support."));
                responseMessage.setSuccessMessage("");
                LOG.error(ex);
            }
        }
    }

}
