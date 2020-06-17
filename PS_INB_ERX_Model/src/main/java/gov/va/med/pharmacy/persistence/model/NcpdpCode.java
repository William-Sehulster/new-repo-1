package gov.va.med.pharmacy.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "NCPDP_CODE")
public class NcpdpCode implements java.io.Serializable {

	
	private static final long serialVersionUID = -6372613220828450628L;
	
	private String ncitSubsetCode;
	private String ncpdpSubsetPrefTerm;
	private String ncitCode;
	private String ncpdpPrefTerm;
	private String ncpdpSynonym;
	private String ncitPrefTerm;
	private String ncitDefinition;
	
	public NcpdpCode() {
	
	}

	public NcpdpCode(String ncitSubsetCode, String ncpdpSubsetPrefTerm, String ncitCode, String ncpdpPrefTerm,
			String ncpdpSynonym, String ncitPrefTerm, String ncitDefinition) {
		this.ncitSubsetCode = ncitSubsetCode;
		this.ncpdpSubsetPrefTerm = ncpdpSubsetPrefTerm;
		this.ncitCode = ncitCode;
		this.ncpdpPrefTerm = ncpdpPrefTerm;
		this.ncpdpSynonym = ncpdpSynonym;
		this.ncitPrefTerm = ncitPrefTerm;
		this.ncitDefinition = ncitDefinition;
	}
	
	@Id
	@Column(name = "NCIT_SUBSET_CODE", length = 7)
	public String getNcitSubsetCode() {
		return ncitSubsetCode;
	}

	public void setNcitSubsetCode(String ncitSubsetCode) {
		this.ncitSubsetCode = ncitSubsetCode;
	}

	@Column(name = "NCPDP_SUBSET_PREF_TERM", length = 100)
	public String getNcpdpSubsetPrefTerm() {
		return ncpdpSubsetPrefTerm;
	}

	public void setNcpdpSubsetPrefTerm(String ncpdpSubsetPrefTerm) {
		this.ncpdpSubsetPrefTerm = ncpdpSubsetPrefTerm;
	}
	
	@Column(name = "NCIT_CODE", length = 7)
	public String getNcitCode() {
		return ncitCode;
	}

	public void setNcitCode(String ncitCode) {
		this.ncitCode = ncitCode;
	}

	@Column(name = "NCPDP_PREF_TERM", length = 100)
	public String getNcpdpPrefTerm() {
		return ncpdpPrefTerm;
	}

	public void setNcpdpPrefTerm(String ncpdpPrefTerm) {
		this.ncpdpPrefTerm = ncpdpPrefTerm;
	}

	@Column(name = "NCPDP_SYNONYM", length = 100)
	public String getNcpdpSynonym() {
		return ncpdpSynonym;
	}

	public void setNcpdpSynonym(String ncpdpSynonym) {
		this.ncpdpSynonym = ncpdpSynonym;
	}

	@Column(name = "NCIT_PREF_TERM", length = 100)
	public String getNcitPrefTerm() {
		return ncitPrefTerm;
	}

	public void setNcitPrefTerm(String ncitPrefTerm) {
		this.ncitPrefTerm = ncitPrefTerm;
	}

	@Column(name = "NCIT_DEFINITION", length = 2000)
	public String getNcitDefinition() {
		return ncitDefinition;
	}

	public void setNcitDefinition(String ncitDefinition) {
		this.ncitDefinition = ncitDefinition;
	}
	
	
	
	

}
