package gov.va.med.pharmacy.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity(name = "PharmacyEntity")
@Table(name = "PHARMACY", schema = "ERX")
public class PharmacyEntity implements java.io.Serializable {
	

	private static final long serialVersionUID = 3354478104919026544L;

	private Long pharmacyId;
	
	private String vaStationId;
	private String ncpdpId;
	private Long npi;
	private String storeName;

	private String pharmacistLastName;
	private String pharmacistFirstName;
	private String pharmacistMiddleName;
	private String pharmacistSuffix;
	private String pharmacistPrefix;
	private String pharmacyAddressLine1;
	private String pharmacyAddressLine2;
	private String pharmacyCity;
	private String pharmacyState;
	private String pharmacyZipcode;
	
	private String crossStreet;
	
	private String pharmacyPhoneNumber;
	private String pharmacyFaxNumber;	
	private Long inboundErxEnabled;
	private Date updatedDate;
	private Date createdDate;
	private Long visn;
	private String divisionName;
	private String createdBy;
	private String updatedBy;
	// using  @Type(type="yes_no") converts boolean to Y or N.	
	private Boolean eandeCheck;

	

	public PharmacyEntity() {
	}

	public PharmacyEntity(Long pharmacyId, String vaStationId, String ncpdpId, String storeName,
			String pharmacyAddressLine1, String pharmacyCity, String pharmacyState, String pharmacyZipcode,
			String pharmacyPhoneNumber, String pharmacyFaxNumber, Long inboundErxEnabled,Boolean eandeCheck) {
		this.pharmacyId = pharmacyId;
		this.vaStationId = vaStationId;		
		this.ncpdpId = ncpdpId;
		this.storeName = storeName;
		this.pharmacyAddressLine1 = pharmacyAddressLine1;
		this.pharmacyCity = pharmacyCity;
		this.pharmacyState = pharmacyState;
		this.pharmacyZipcode = pharmacyZipcode;
		this.pharmacyPhoneNumber = pharmacyPhoneNumber;
		this.pharmacyFaxNumber = pharmacyFaxNumber;
		this.inboundErxEnabled = inboundErxEnabled;
		this.eandeCheck = eandeCheck;
	}

	public PharmacyEntity(Long pharmacyId, String createdBy, String updatedBy, 	String vaStationId, 
			String ncpdpId, Long npi, String storeName,
			String pharmacistLastName, String pharmacistFirstName, String pharmacistMiddleName,
			String pharmacistSuffix, String pharmacistPrefix, String pharmacyAddressLine1, String pharmacyAddressLine2, String pharmacyCity,
			String pharmacyState, String pharmacyZipcode,  String crossStreet, 
			String pharmacyPhoneNumber, String pharmacyFaxNumber, Long inboundErxEnabled, Date updatedDate, Date createdDate,
			Long visn, String divisionName,Boolean eandeCheck) {
		
		this.pharmacyId = pharmacyId;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.vaStationId = vaStationId;		
		this.ncpdpId = ncpdpId;
		this.npi = npi;		
		this.storeName = storeName;		
		this.pharmacistLastName = pharmacistLastName;
		this.pharmacistFirstName = pharmacistFirstName;
		this.pharmacistMiddleName = pharmacistMiddleName;
		this.pharmacistSuffix = pharmacistSuffix;
		this.pharmacistPrefix = pharmacistPrefix;
		this.pharmacyAddressLine1 = pharmacyAddressLine1;
		this.pharmacyAddressLine2 = pharmacyAddressLine2;
		this.pharmacyCity = pharmacyCity;
		this.pharmacyState = pharmacyState;
		this.pharmacyZipcode = pharmacyZipcode;
		this.crossStreet = crossStreet;
		this.pharmacyPhoneNumber = pharmacyPhoneNumber;
		this.pharmacyFaxNumber = pharmacyFaxNumber;
		this.inboundErxEnabled = inboundErxEnabled;
		this.updatedDate = updatedDate;
		this.createdDate = createdDate;
		this.visn = visn;
		this.divisionName = divisionName;
		this.eandeCheck = eandeCheck;

	}


	@Id	
	@SequenceGenerator(name="INB_PHARMACY_SEQ_GEN", sequenceName="ERX.PHARMACY_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INB_PHARMACY_SEQ_GEN")	
	@Column(name = "PHARMACY_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getPharmacyId() {
		return this.pharmacyId;
	}

	public void setPharmacyId(Long pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

	
	@Column(name = "VA_STATION_ID", nullable = false, length = 5)
	public String getVaStationId() {
		return this.vaStationId;
	}

	public void setVaStationId(String vaStationId) {
		this.vaStationId = vaStationId;
	}


	@Column(name = "NCPDP_ID", nullable = false, length = 7)
	public String getNcpdpId() {
		return this.ncpdpId;
	}

	public void setNcpdpId(String ncpdpId) {
		this.ncpdpId =  ncpdpId;
	}

	@Column(name = "NPI", precision = 22, scale = 0)
	public Long getNpi() {
		return this.npi;
	}

	public void setNpi(Long npi) {
		this.npi = npi;
	}


	@Column(name = "STORE_NAME", nullable = false, length = 35)
	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName =  storeName;
	}


	@Column(name = "PHARMACIST_LAST_NAME", length = 35)
	public String getPharmacistLastName() {
		return this.pharmacistLastName;
	}

	public void setPharmacistLastName(String pharmacistLastName) {
		this.pharmacistLastName =  pharmacistLastName;
	}

	@Column(name = "PHARMACIST_FIRST_NAME", length = 35)
	public String getPharmacistFirstName() {
		return this.pharmacistFirstName;
	}

	public void setPharmacistFirstName(String pharmacistFirstName) {
		this.pharmacistFirstName =  pharmacistFirstName;
	}

	@Column(name = "PHARMACIST_MIDDLE_NAME", length = 35)
	public String getPharmacistMiddleName() {
		return this.pharmacistMiddleName;
	}

	public void setPharmacistMiddleName(String pharmacistMiddleName) {
		this.pharmacistMiddleName =  pharmacistMiddleName;
	}

	@Column(name = "PHARMACIST_SUFFIX", length = 35)
	public String getPharmacistSuffix() {
		return this.pharmacistSuffix;
	}

	public void setPharmacistSuffix(String pharmacistSuffix) {
		this.pharmacistSuffix =  pharmacistSuffix;
	}

	@Column(name = "PHARMACIST_PREFIX", length = 35)
	public String getPharmacistPrefix() {
		return this.pharmacistPrefix;
	}

	public void setPharmacistPrefix(String pharmacistPrefix) {
		this.pharmacistPrefix =  pharmacistPrefix;
	}


	@Column(name = "PHARMACY_ADDRESS_LINE_1", nullable = false, length = 35)
	public String getPharmacyAddressLine1() {
		return this.pharmacyAddressLine1;
	}

	public void setPharmacyAddressLine1(String pharmacyAddressLine1) {
		this.pharmacyAddressLine1 =  pharmacyAddressLine1;
	}

	@Column(name = "PHARMACY_ADDRESS_LINE_2", length = 35)
	public String getPharmacyAddressLine2() {
		return this.pharmacyAddressLine2;
	}

	public void setPharmacyAddressLine2(String pharmacyAddressLine2) {
		this.pharmacyAddressLine2 =  pharmacyAddressLine2;
	}

	@Column(name = "PHARMACY_CITY", nullable = false, length = 35)
	public String getPharmacyCity() {
		return this.pharmacyCity;
	}

	public void setPharmacyCity(String pharmacyCity) {
		this.pharmacyCity =  pharmacyCity;
	}

	@Column(name = "PHARMACY_STATE", nullable = false, length = 2)
	public String getPharmacyState() {
		return this.pharmacyState;
	}

	public void setPharmacyState(String pharmacyState) {
		this.pharmacyState =  pharmacyState;
	}

	@Column(name = "PHARMACY_ZIPCODE", nullable = false, length = 10)
	public String getPharmacyZipcode() {
		return this.pharmacyZipcode;
	}

	public void setPharmacyZipcode(String pharmacyZipcode) {
		this.pharmacyZipcode =  pharmacyZipcode;
	}


	@Column(name = "CROSS_STREET", length = 35)
	public String getCrossStreet() {
		return this.crossStreet;
	}

	public void setCrossStreet(String crossStreet) {
		this.crossStreet =  crossStreet;
	}


	@Column(name = "PHARMACY_PHONE_NUMBER", nullable = false, length = 35)
	public String getPharmacyPhoneNumber() {
		return this.pharmacyPhoneNumber;
	}

	public void setPharmacyPhoneNumber(String pharmacyPhoneNumber) {
		this.pharmacyPhoneNumber =  pharmacyPhoneNumber;
	}


	@Column(name = "PHARMACY_FAX_NUMBER", length = 35)
	public String getPharmacyFaxNumber() {
		return pharmacyFaxNumber;
	}

	public void setPharmacyFaxNumber(String pharmacyFaxNumber) {
		this.pharmacyFaxNumber =  pharmacyFaxNumber;
	}

	@Column(name = "INBOUND_ERX_ENABLED", nullable = false, precision = 22, scale = 0)
	public Long getInboundErxEnabled() {
		return this.inboundErxEnabled;
	}

	public void setInboundErxEnabled(Long inboundErxEnabled) {
		this.inboundErxEnabled = inboundErxEnabled;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE", length = 7)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", length = 7)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "VISN", nullable = false, precision = 22, scale = 0)
	public Long getVisn() {
		return this.visn;
	}

	public void setVisn(Long visn) {
		this.visn = visn;
	}

	@Column(name = "DIVISION_NAME", length = 35)
	public String getDivisionName() {
		return this.divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName =  divisionName;
	}

	@Column(name = "CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy =  createdBy;
	}

	@Column(name = "UPDATED_BY")
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy =  updatedBy;
	}
	
	@Type(type="yes_no")
	@Column(name = "EANDE_CHECK", nullable = false, length = 1)
	public Boolean getEandeCheck() {
		return this.eandeCheck;
	}

	public void setEandeCheck(Boolean eandeCheck) {
		this.eandeCheck = eandeCheck;
	}

	
	// for csv, not to be removed, needs to match the hearder order.
	@javax.persistence.Transient
	public String[] getStringArray(){
		String[] stringArray = {(this.getVisn()!=null?String.valueOf(this.getVisn()):"") ,
					this.getVaStationId(),
					this.getNcpdpId(),
					this.getStoreName(),
					this.getDivisionName(),
					this.getPharmacyAddressLine1(),
					this.getPharmacyCity(),
					this.getPharmacyState(),
					this.getPharmacyPhoneNumber(),
					(this.getInboundErxEnabled()!=null?String.valueOf(this.getInboundErxEnabled()):"")					
					
		};
		
		return stringArray;
	}
}
