package gov.va.med.pharmacy.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "APP_CONFIGURATION", schema = "ERX")
public class AppConfiguration implements java.io.Serializable {

		
	private static final long serialVersionUID = -4095021165449772644L;
	
	private String key;
	private String value;
	private Date updatedDate;
	private Date createdDate;

	public AppConfiguration() {
	}

	public AppConfiguration(String key) {
		this.key = key;
	}

	public AppConfiguration(String key, String value, Date updatedDate, Date createdDate) {
		this.key = key;
		this.value = value;
		this.updatedDate = updatedDate;
		this.createdDate = createdDate;
	}

	@Id

	@Column(name = "KEY", unique = true, nullable = false, length = 15)
	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Column(name = "VALUE", length = 70)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
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
