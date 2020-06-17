package gov.va.med.pharmacy.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ECL_CODE", schema = "ERX")
public class EclCode implements java.io.Serializable {

	
	private static final long serialVersionUID = 4602185653214195216L;
	
	private String codeType;
	private String code;
	private String definition;


	public EclCode() {
	}



	public EclCode(String codeType, String code, String definition) {
		this.codeType = codeType;
		this.code = code;
		this.definition = definition;
	}

	@Id
	@Column(name = "CODE", length = 7)
	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}

	
	
	@Column(name = "CODE_TYPE", length = 2000)
	public String getCodeType() {
		return codeType;
	}



	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}


	

	@Column(name = "DEFINITION", length = 2000)
	public String getDefinition() {
		return definition;
	}



	public void setDefinition(String definition) {
		this.definition = definition;
	}

	
	
	

}
