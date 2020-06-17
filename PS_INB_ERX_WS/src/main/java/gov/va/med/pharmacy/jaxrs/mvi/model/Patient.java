package gov.va.med.pharmacy.jaxrs.mvi.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient {

	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private String dateOfBirth;
	private String address;
	private String telephone;	
	private String socSecNum;
	private String ICN;
	private String queryReturnCode;
	private String stationIds;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSocSecNum() {
		return socSecNum;
	}
	public void setSocSecNum(String socSecNum2) {
		this.socSecNum = socSecNum2;
	}
	public String getICN() {
		return ICN;
	}
	public void setICN(String iCN) {
		this.ICN = iCN;
	}
	public String getQueryReturnCode() {
		return queryReturnCode;
	}
	public void setQueryReturnCode(String queryReturnCode) {
		this.queryReturnCode = queryReturnCode;
	}
	public String getStationIds() {
		return stationIds;
	}
	public void setStationIds(String stationIds) {
		this.stationIds = stationIds;
	}

	
	

}
