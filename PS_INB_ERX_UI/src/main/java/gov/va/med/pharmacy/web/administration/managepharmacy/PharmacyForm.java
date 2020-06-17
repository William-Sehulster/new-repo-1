package gov.va.med.pharmacy.web.administration.managepharmacy;

import org.hibernate.validator.constraints.NotBlank;

import gov.va.med.pharmacy.web.util.BlankOrLength;
import gov.va.med.pharmacy.web.util.BlankOrPattern;


public class PharmacyForm {

	
	@NotBlank(message = "Pharmacy Name (Published) is required.")
	private String storeName;
	
	// adding character length check to be safe for visn. Number between 0 and 99.
	@NotBlank(message = "VISN is required.")
	@BlankOrPattern(regexp = "^[0-9]{1,2}$",message="VISN should be a number.")
	private String visn;
	
	@NotBlank(message="VA Station ID is required.")
	@BlankOrPattern(regexp = "^(?=.*\\d)[A-Z\\d]*$",message="VA Station ID should be either numeric or upper case alphanumeric.")
	private String vaStationId;
	

	@NotBlank(message="Pharmacy Name (Internal) is required.")
	private String divisionName;
	
	@NotBlank(message = "Pharmacy Address Line 1 is required.")
	private String pharmacyAddressLine1;
	private String pharmacyAddressLine2;
	
	@NotBlank(message = "Pharmacy City is required.")
	@BlankOrPattern(regexp = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$",message="Pharmacy City should be only alphabetical letters.")
	private String pharmacyCity;
	
	@NotBlank(message = "Pharmacy State is required.")
	private String pharmacyState;
	
	@NotBlank(message = "Pharmacy Zip Code is required.")
	@BlankOrPattern(regexp = "^[0-9]{5}(?:-[0-9]{4})?$",message="Pharmacy Zip Code should be either five digits only or in XXXXX-XXXX format.")
	private String pharmacyZipcode;
	
	@NotBlank(message = "Pharmacy Phone Number (TE) is required.")
	@BlankOrPattern(regexp = "(^[2-9]\\d{2}-\\d{3}-\\d{4})|(\\d{3}-\\d{3}-\\d{4}\\s(x)\\d{3,5})$",message="Pharmacy Phone Number should be entered either in XXX-XXX-XXXX format or with extension in XXX-XXX-XXXX xXXXXX format.")
	private String pharmacyPhoneNumber;
	
	@NotBlank(message = "Pharmacy Fax Number (FX) is required.")
	@BlankOrPattern(regexp = "(^[2-9]\\d{2}-\\d{3}-\\d{4})|(\\d{3}-\\d{3}-\\d{4}\\s(x)\\d{3,5})$",message="Pharmacy Fax Number should be entered either in XXX-XXX-XXXX format or with extension in XXX-XXX-XXXX xXXXXX format.")
	private String pharmacyFaxNumber;
	
	@NotBlank(message="NCPDP ID is required.")	
	@BlankOrPattern(regexp = "^[0-9]*$",message="NCPDP ID should be a number.")
	@BlankOrLength(min=7, message="NCPDP ID  should be 7 digits.")
	private String ncpdpId;
	
	
	@NotBlank(message="NPI is required.")	
	@BlankOrPattern(regexp = "^[0-9]*$",message="NPI should be a number.")
	@BlankOrLength(min=10, message="NPI should be 10 digits.")
	private String npi;
	
	
	
	//@NotBlank(message="Active End Time is required.")
	private String pharmacyId;
	private String createdBy;
	private String updatedBy;
	private String vistaLookupId;
	private String fileId;
	private String pharmacistLastName;
	private String pharmacistFirstName;
	private String pharmacistMiddleName;
	private String pharmacistSuffix;
	private String pharmacistPrefix;
	private String pharmacistAgentLastName;	
	private String crossStreet;	
	private String inboundErxEnabled;
	private String updatedDate;
	private String createdDate;	
	private String pharmacyEnabledDisabled;
	private String eAndeCheckEnabled;
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getVisn() {
		return visn;
	}
	public void setVisn(String visn) {
		this.visn = visn;
	}
	public String getVaStationId() {
		return vaStationId;
	}
	public void setVaStationId(String vaStationId) {
		this.vaStationId = vaStationId;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public String getPharmacyAddressLine1() {
		return pharmacyAddressLine1;
	}
	public void setPharmacyAddressLine1(String pharmacyAddressLine1) {
		this.pharmacyAddressLine1 = pharmacyAddressLine1;
	}
	public String getPharmacyAddressLine2() {
		return pharmacyAddressLine2;
	}
	public void setPharmacyAddressLine2(String pharmacyAddressLine2) {
		this.pharmacyAddressLine2 = pharmacyAddressLine2;
	}
	public String getPharmacyCity() {
		return pharmacyCity;
	}
	public void setPharmacyCity(String pharmacyCity) {
		this.pharmacyCity = pharmacyCity;
	}
	public String getPharmacyState() {
		return pharmacyState;
	}
	public void setPharmacyState(String pharmacyState) {
		this.pharmacyState = pharmacyState;
	}
	public String getPharmacyZipcode() {
		return pharmacyZipcode;
	}
	public void setPharmacyZipcode(String pharmacyZipcode) {
		this.pharmacyZipcode = pharmacyZipcode;
	}
	public String getPharmacyPhoneNumber() {
		return pharmacyPhoneNumber;
	}
	public void setPharmacyPhoneNumber(String pharmacyPhoneNumber) {
		this.pharmacyPhoneNumber = pharmacyPhoneNumber;
	}
	public String getPharmacyFaxNumber() {
		return pharmacyFaxNumber;
	}
	public void setPharmacyFaxNumber(String pharmacyFaxNumber) {
		this.pharmacyFaxNumber = pharmacyFaxNumber;
	}
	public String getNcpdpId() {
		return ncpdpId;
	}
	public void setNcpdpId(String ncpdpId) {
		this.ncpdpId = ncpdpId;
	}
	public String getNpi() {
		return npi;
	}
	public void setNpi(String npi) {
		this.npi = npi;
	}
	public String getPharmacyId() {
		return pharmacyId;
	}
	public void setPharmacyId(String pharmacyId) {
		this.pharmacyId = pharmacyId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getVistaLookupId() {
		return vistaLookupId;
	}
	public void setVistaLookupId(String vistaLookupId) {
		this.vistaLookupId = vistaLookupId;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getPharmacistLastName() {
		return pharmacistLastName;
	}
	public void setPharmacistLastName(String pharmacistLastName) {
		this.pharmacistLastName = pharmacistLastName;
	}
	public String getPharmacistFirstName() {
		return pharmacistFirstName;
	}
	public void setPharmacistFirstName(String pharmacistFirstName) {
		this.pharmacistFirstName = pharmacistFirstName;
	}
	public String getPharmacistMiddleName() {
		return pharmacistMiddleName;
	}
	public void setPharmacistMiddleName(String pharmacistMiddleName) {
		this.pharmacistMiddleName = pharmacistMiddleName;
	}
	public String getPharmacistSuffix() {
		return pharmacistSuffix;
	}
	public void setPharmacistSuffix(String pharmacistSuffix) {
		this.pharmacistSuffix = pharmacistSuffix;
	}
	public String getPharmacistPrefix() {
		return pharmacistPrefix;
	}
	public void setPharmacistPrefix(String pharmacistPrefix) {
		this.pharmacistPrefix = pharmacistPrefix;
	}
	public String getPharmacistAgentLastName() {
		return pharmacistAgentLastName;
	}
	public void setPharmacistAgentLastName(String pharmacistAgentLastName) {
		this.pharmacistAgentLastName = pharmacistAgentLastName;
	}
	public String getCrossStreet() {
		return crossStreet;
	}
	public void setCrossStreet(String crossStreet) {
		this.crossStreet = crossStreet;
	}
	public String getInboundErxEnabled() {
		return inboundErxEnabled;
	}
	public void setInboundErxEnabled(String inboundErxEnabled) {
		this.inboundErxEnabled = inboundErxEnabled;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getPharmacyEnabledDisabled() {
		return pharmacyEnabledDisabled;
	}
	public void setPharmacyEnabledDisabled(String pharmacyEnabledDisabled) {
		this.pharmacyEnabledDisabled = pharmacyEnabledDisabled;
	}
	public String geteAndeCheckEnabled() {
		return eAndeCheckEnabled;
	}
	public void seteAndeCheckEnabled(String eAndeCheckEnabled) {
		this.eAndeCheckEnabled = eAndeCheckEnabled;
	}
	
	
	
	
	
	
	
	
}
