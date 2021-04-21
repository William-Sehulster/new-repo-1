package gov.va.med.pharmacy.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
/**
 * Entity class for the lookup table.
 * 
 */

@Entity
@Table(name = "PHARMACY_MIGRATION", schema = "ERX")
public class PharmacyMigration implements java.io.Serializable {

	
	private static final long serialVersionUID = 4506138398612311794L;
	private String pharmacyNcpdpid;
	private Boolean migrated;	
	private Date updatedDate;
	private Date createdDate;
	
	public PharmacyMigration() {
	}

	public PharmacyMigration(String pharmacyNcpdpid) {
		this.pharmacyNcpdpid = pharmacyNcpdpid;
	}

	public PharmacyMigration(String pharmacyNcpdpid, Boolean migrated, Date updatedDate, Date createdDate) {
		this.pharmacyNcpdpid = pharmacyNcpdpid;
		this.migrated = migrated;
		this.updatedDate = updatedDate;
		this.createdDate = createdDate;
		
	}

	@Id	
	@Column(name = "PHARMACY_NCPDP_ID", unique = true, nullable = false, length = 7)
	public String getPharmacyNcpdpid() {
		return pharmacyNcpdpid;
	}

	public void setPharmacyNcpdpid(String pharmacyNcpdpid) {
		this.pharmacyNcpdpid = pharmacyNcpdpid;
	}
	
			 
	@Type(type="yes_no")	  
	@Column(name = "MIGRATED", nullable = false, length = 1)   
	public Boolean getMigrated() {
		return migrated;
	}

	public void setMigrated(Boolean migrated) {
		this.migrated = migrated;
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

	

}
