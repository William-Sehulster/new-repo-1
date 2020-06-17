package gov.va.med.pharmacy.web.administration.view;

import java.io.Serializable;

public class UserManagementModel implements Serializable {
	
	
	private static final long serialVersionUID = 2660290399040894546L;

	private String recId;
	
	private String deleteSelect;
	
	private String firstName;
	
	private String lastName;
	
	private String userName;

    private boolean pharmMgr;

    private boolean pbmAdmn;

    private boolean pharmUser;
    
    private boolean systemAdmn;
    
    private String addUserText;

    private String modifiedIds;

    private String modifiedFields;
    
    private String addFirstNameText;
    
    private String addLastNameText;
    
    private String userRolesSelect;
    
    private String _csrf;
    
    private boolean userEnabled;
    
    private String enableDisableRecords;
    
    private String stationIds;
    
    private String stationIdsSelected;
    
    private String modifiedStationIds;
    

	public String getRecId() {
		return recId;
	}

	public void setRecId(String recId) {
		this.recId = recId;
	}

	public String getDeleteSelect() {
		return deleteSelect;
	}

	public void setDeleteSelect(String deleteSelect) {
		this.deleteSelect = deleteSelect;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isPharmMgr() {
		return pharmMgr;
	}

	public void setPharmMgr(boolean pharmMgr) {
		this.pharmMgr = pharmMgr;
	}

	public boolean isPbmAdmn() {
		return pbmAdmn;
	}

	public void setPbmAdmn(boolean pbmAdmn) {
		this.pbmAdmn = pbmAdmn;
	}

	public boolean isPharmUser() {
		return pharmUser;
	}

	public void setPharmUser(boolean pharmUser) {
		this.pharmUser = pharmUser;
	}

	public boolean isSystemAdmn() {
		return systemAdmn;
	}

	public void setSystemAdmn(boolean systemAdmn) {
		this.systemAdmn = systemAdmn;
	}

	public String getAddUserText() {
		return addUserText;
	}

	public void setAddUserText(String addUserText) {
		this.addUserText = addUserText;
	}

	public String getModifiedIds() {
		return modifiedIds;
	}

	public void setModifiedIds(String modifiedIds) {
		this.modifiedIds = modifiedIds;
	}

	public String getModifiedFields() {
		return modifiedFields;
	}

	public void setModifiedFields(String modifiedFields) {
		this.modifiedFields = modifiedFields;
	}

	public String getAddFirstNameText() {
		return addFirstNameText;
	}

	public void setAddFirstNameText(String addFirstNameText) {
		this.addFirstNameText = addFirstNameText;
	}

	public String getAddLastNameText() {
		return addLastNameText;
	}

	public void setAddLastNameText(String addLastNameText) {
		this.addLastNameText = addLastNameText;
	}

	public String getUserRolesSelect() {
		return userRolesSelect;
	}

	public void setUserRolesSelect(String userRolesSelect) {
		this.userRolesSelect = userRolesSelect;
	}

	public String get_csrf() {
		return _csrf;
	}

	public void set_csrf(String _csrf) {
		this._csrf = _csrf;
	}

	public String getEnableDisableRecords() {
		return enableDisableRecords;
	}

	public void setEnableDisableRecords(String enableDisableRecords) {
		this.enableDisableRecords = enableDisableRecords;
	}

	public boolean isUserEnabled() {
		return userEnabled;
	}

	public void setUserEnabled(boolean userEnabled) {
		this.userEnabled = userEnabled;
	}

	public String getStationIdsSelected() {
		return stationIdsSelected;
	}

	public void setStationIdsSelected(String stationIdsSelected) {
		this.stationIdsSelected = stationIdsSelected;
	}

	public String getStationIds() {
		return stationIds;
	}

	public void setStationIds(String stationIds) {
		this.stationIds = stationIds;
	}

	public String getModifiedStationIds() {
		return modifiedStationIds;
	}

	public void setModifiedStationIds(String modifiedStationIds) {
		this.modifiedStationIds = modifiedStationIds;
	}

   



	
	
}
