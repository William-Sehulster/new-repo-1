package gov.va.med.pharmacy.jaxrs.mvi.model;

/**
 * This class returns the response to the patient search request.
 *
 */
public class PatientSearchResponse {

	public String getPatientStationIds() {
		return patientStationIds;
	}

	public void setPatientStationIds(String patientStationIds) {
		this.patientStationIds = patientStationIds;
	}

	private Boolean success = true;
	private String errorMessage;
	private String patientFirstName;
	private String patientMiddleName;
	private String patientLastName;
	private String patientICN;
	private String patientSocSecNum;
	private String patientDateOfBirth;
	private String patientStationIds;

	public String getPatientICN() {
		return patientICN;
	}

	public void setPatientICN(String patientICN) {
		this.patientICN = patientICN;
	}

	public String getPatientSocSecNum() {
		return patientSocSecNum;
	}

	public void setPatientSocSecNum(String patientSocSecNum) {
		this.patientSocSecNum = patientSocSecNum;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public String getPatientDateOfBirth() {
		return patientDateOfBirth;
	}

	public void setPatientDateOfBirth(String patientDateOfBirth) {
		this.patientDateOfBirth = patientDateOfBirth;
	}

	public String getPatientMiddleName() {
		return patientMiddleName;
	}

	public void setPatientMiddleName(String patientMiddleName) {
		this.patientMiddleName = patientMiddleName;
	}
	

	
	
}
