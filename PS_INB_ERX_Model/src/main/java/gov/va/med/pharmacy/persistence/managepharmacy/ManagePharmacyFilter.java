package gov.va.med.pharmacy.persistence.managepharmacy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@Scope("session")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ManagePharmacyFilter {

	// names should be same as those in the javascript.

    private String pharmacyId;
	
	private String pharmacyFilterFormVisnSelect;
	
	private String pharmacyFilterFormStationIdSelect;
	
	private String pharmacyName;
	
	private String ncpdpId;
	
	

	public String getPharmacyId() {
		return pharmacyId;
	}

	public void setPharmacyId(String pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

	public String getPharmacyFilterFormVisnSelect() {
		return pharmacyFilterFormVisnSelect;
	}

	public void setPharmacyFilterFormVisnSelect(String pharmacyFilterFormVisnSelect) {
		this.pharmacyFilterFormVisnSelect = pharmacyFilterFormVisnSelect;
	}

	public String getPharmacyFilterFormStationIdSelect() {
		return pharmacyFilterFormStationIdSelect;
	}

	public void setPharmacyFilterFormStationIdSelect(String pharmacyFilterFormStationIdSelect) {
		this.pharmacyFilterFormStationIdSelect = pharmacyFilterFormStationIdSelect;
	}

	public String getPharmacyName() {
		return pharmacyName;
	}

	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}

	public String getNcpdpId() {
		return ncpdpId;
	}

	public void setNcpdpId(String ncpdpId) {
		this.ncpdpId = ncpdpId;
	}

	
	
}
