
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PRPA_MT201302UV02.NonPersonLivingSubject.id complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PRPA_MT201302UV02.NonPersonLivingSubject.id"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:v3}II"&gt;
 *       &lt;attribute name="updateMode" type="{urn:hl7-org:v3}PRPA_MT201302UV02.NonPersonLivingSubject.id.updateMode" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT201302UV02.NonPersonLivingSubject.id")
public class PRPAMT201302UV02NonPersonLivingSubjectId
    extends II
{

    @XmlAttribute(name = "updateMode")
    protected PRPAMT201302UV02NonPersonLivingSubjectIdUpdateMode updateMode;

    /**
     * Gets the value of the updateMode property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT201302UV02NonPersonLivingSubjectIdUpdateMode }
     *     
     */
    public PRPAMT201302UV02NonPersonLivingSubjectIdUpdateMode getUpdateMode() {
        return updateMode;
    }

    /**
     * Sets the value of the updateMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT201302UV02NonPersonLivingSubjectIdUpdateMode }
     *     
     */
    public void setUpdateMode(PRPAMT201302UV02NonPersonLivingSubjectIdUpdateMode value) {
        this.updateMode = value;
    }

}
