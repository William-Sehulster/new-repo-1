
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *             Binary data is a raw block of bits. Binary data is a
 *             protected type that MUST not be used outside the data
 *             type specification.
 *          
 * 
 * <p>Java class for BIN complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BIN"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:v3}ANY"&gt;
 *       &lt;attribute name="representation" type="{urn:hl7-org:v3}BinaryDataEncoding" default="TXT" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BIN")
@XmlSeeAlso({
    ED.class
})
public abstract class BIN
    extends ANY
{

    @XmlAttribute(name = "representation")
    protected BinaryDataEncoding representation;

    /**
     * Gets the value of the representation property.
     * 
     * @return
     *     possible object is
     *     {@link BinaryDataEncoding }
     *     
     */
    public BinaryDataEncoding getRepresentation() {
        if (representation == null) {
            return BinaryDataEncoding.TXT;
        } else {
            return representation;
        }
    }

    /**
     * Sets the value of the representation property.
     * 
     * @param value
     *     allowed object is
     *     {@link BinaryDataEncoding }
     *     
     */
    public void setRepresentation(BinaryDataEncoding value) {
        this.representation = value;
    }

}
