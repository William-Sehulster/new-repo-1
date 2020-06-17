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


@Entity
@Table(name = "VA_USER", schema = "ERX")
public class VaUser implements java.io.Serializable {

	private static final long serialVersionUID = -3219606897037643685L;
	private Long usersId;
	private String vaUserid;	
	private Date updatedDate;
	private Date createdDate;
	private String firstName;
	private String lastName;
	
	// using  @Type(type="yes_no") converts boolean to Y or N.		
	private Boolean isPharmMgr;
	private Boolean isPbmAdmn;
	private Boolean isPharmUser;
	private Boolean isSystemAdmn;
	private Boolean isEnabled;
	private String vaStationIds;
	
	private String createdBy;
	private String updatedBy;
	

	public VaUser() {
	}

	public VaUser(Long usersId, String vaUserid,Boolean isPharmMgr, Boolean isPbmAdmn,
			Boolean isPharmUser, Boolean isSystemAdmn, Boolean isEnabled,String vaStationIds) {
		this.usersId = usersId;
		this.vaUserid = vaUserid;		
		this.isPharmMgr = isPharmMgr;
		this.isPbmAdmn = isPbmAdmn;
		this.isPharmUser = isPharmUser;
		this.isSystemAdmn = isSystemAdmn;
		this.isEnabled = isEnabled;
        this.vaStationIds = vaStationIds;
	}

	public VaUser(Long usersId, String vaUserid, Date updatedDate, Date createdDate,
			String firstName, String lastName, Boolean isPharmMgr, Boolean isPbmAdmn, Boolean isPharmUser,
			Boolean isSystemAdmn,Boolean isEnabled,String vaStationIds, String createdBy, String updatedBy ) {
		this.usersId = usersId;
		this.vaUserid = vaUserid;		
		this.updatedDate = updatedDate;
		this.createdDate = createdDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isPharmMgr = isPharmMgr;
		this.isPbmAdmn = isPbmAdmn;
		this.isPharmUser = isPharmUser;
		this.isSystemAdmn = isSystemAdmn;	
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;		
		this.isEnabled = isEnabled;
        this.vaStationIds = vaStationIds;
	}

	@Id
	@SequenceGenerator(name="ERX_VA_USER_SEQ_GEN", sequenceName="ERX.USERS_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ERX_VA_USER_SEQ_GEN")
	@Column(name = "USERS_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getUsersId() {
		return this.usersId;
	}

	public void setUsersId(Long usersId) {
		this.usersId = usersId;
	}

	@Column(name = "VA_USERID", nullable = false, length = 20)
	public String getVaUserid() {
		return this.vaUserid;
	}

	public void setVaUserid(String vaUserid) {
		this.vaUserid = vaUserid;
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

	@Column(name = "FIRST_NAME", length = 50)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME", length = 50)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Type(type="yes_no")
	@Column(name = "IS_PHARM_MGR", nullable = false, length = 1)
	public Boolean getIsPharmMgr() {
		return this.isPharmMgr;
	}

	public void setIsPharmMgr(Boolean isPharmMgr) {
		this.isPharmMgr = isPharmMgr;
	}

	// converts boolean to Y or N.
	@Type(type="yes_no")
	@Column(name = "IS_PBM_ADMN", nullable = false, length = 1)
	public Boolean getIsPbmAdmn() {
		return this.isPbmAdmn;
	}

	public void setIsPbmAdmn(Boolean isPbmAdmn) {
		this.isPbmAdmn = isPbmAdmn;
	}

	@Type(type="yes_no")
	@Column(name = "IS_PHARM_USER", nullable = false, length = 1)
	public Boolean getIsPharmUser() {
		return this.isPharmUser;
	}

	public void setIsPharmUser(Boolean isPharmUser) {
		this.isPharmUser = isPharmUser;
	}

	@Type(type="yes_no")
	@Column(name = "IS_SYSTEM_ADMN", nullable = false, length = 1)
	public Boolean getIsSystemAdmn() {
		return this.isSystemAdmn;
	}

	public void setIsSystemAdmn(Boolean isSystemAdmn) {
		this.isSystemAdmn = isSystemAdmn;
	}
	
	@Type(type="yes_no")
	@Column(name = "IS_ENABLED", nullable = false, length = 1)
	public Boolean getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	
	@Column(name = "VA_STATION_IDS", nullable = false, length = 3000)
	public String getVaStationIds() {
		return this.vaStationIds;
	}

	public void setVaStationIds(String vaStationIds) {
		this.vaStationIds = vaStationIds;
	}
	
	@Column(name = "CREATED_BY", length = 20)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "UPDATED_BY", length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	

}
