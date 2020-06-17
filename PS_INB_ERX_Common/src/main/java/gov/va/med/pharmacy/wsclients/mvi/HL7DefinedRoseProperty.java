
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HL7DefinedRoseProperty.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HL7DefinedRoseProperty"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ApplicationRoleI"/&gt;
 *     &lt;enumeration value="Cardinality"/&gt;
 *     &lt;enumeration value="MayRepeat"/&gt;
 *     &lt;enumeration value="InstancedDTsymbo"/&gt;
 *     &lt;enumeration value="DTsymbol"/&gt;
 *     &lt;enumeration value="DevelopingCommit"/&gt;
 *     &lt;enumeration value="Organization"/&gt;
 *     &lt;enumeration value="EndState"/&gt;
 *     &lt;enumeration value="HMD"/&gt;
 *     &lt;enumeration value="zhxID"/&gt;
 *     &lt;enumeration value="ID"/&gt;
 *     &lt;enumeration value="DeleteFromMIM"/&gt;
 *     &lt;enumeration value="MIM_id"/&gt;
 *     &lt;enumeration value="MandatoryInclusi"/&gt;
 *     &lt;enumeration value="MsgID"/&gt;
 *     &lt;enumeration value="ModelDate"/&gt;
 *     &lt;enumeration value="ModelDescription"/&gt;
 *     &lt;enumeration value="ModelID"/&gt;
 *     &lt;enumeration value="ModelName"/&gt;
 *     &lt;enumeration value="ModelVersion"/&gt;
 *     &lt;enumeration value="IsPrimitiveDT"/&gt;
 *     &lt;enumeration value="RcvResp"/&gt;
 *     &lt;enumeration value="IsReferenceDT"/&gt;
 *     &lt;enumeration value="RespComm_id"/&gt;
 *     &lt;enumeration value="StartState"/&gt;
 *     &lt;enumeration value="StateAttribute"/&gt;
 *     &lt;enumeration value="StateTransition"/&gt;
 *     &lt;enumeration value="IsSubjectClass"/&gt;
 *     &lt;enumeration value="V23_Fields"/&gt;
 *     &lt;enumeration value="V23_Datatype"/&gt;
 *     &lt;enumeration value="Vocab_domain"/&gt;
 *     &lt;enumeration value="Vocab_strength"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "HL7DefinedRoseProperty")
@XmlEnum
public enum HL7DefinedRoseProperty {

    @XmlEnumValue("ApplicationRoleI")
    APPLICATION_ROLE_I("ApplicationRoleI"),
    @XmlEnumValue("Cardinality")
    CARDINALITY("Cardinality"),
    @XmlEnumValue("MayRepeat")
    MAY_REPEAT("MayRepeat"),
    @XmlEnumValue("InstancedDTsymbo")
    INSTANCED_D_TSYMBO("InstancedDTsymbo"),
    @XmlEnumValue("DTsymbol")
    D_TSYMBOL("DTsymbol"),
    @XmlEnumValue("DevelopingCommit")
    DEVELOPING_COMMIT("DevelopingCommit"),
    @XmlEnumValue("Organization")
    ORGANIZATION("Organization"),
    @XmlEnumValue("EndState")
    END_STATE("EndState"),
    HMD("HMD"),
    @XmlEnumValue("zhxID")
    ZHX_ID("zhxID"),
    ID("ID"),
    @XmlEnumValue("DeleteFromMIM")
    DELETE_FROM_MIM("DeleteFromMIM"),
    @XmlEnumValue("MIM_id")
    MIM_ID("MIM_id"),
    @XmlEnumValue("MandatoryInclusi")
    MANDATORY_INCLUSI("MandatoryInclusi"),
    @XmlEnumValue("MsgID")
    MSG_ID("MsgID"),
    @XmlEnumValue("ModelDate")
    MODEL_DATE("ModelDate"),
    @XmlEnumValue("ModelDescription")
    MODEL_DESCRIPTION("ModelDescription"),
    @XmlEnumValue("ModelID")
    MODEL_ID("ModelID"),
    @XmlEnumValue("ModelName")
    MODEL_NAME("ModelName"),
    @XmlEnumValue("ModelVersion")
    MODEL_VERSION("ModelVersion"),
    @XmlEnumValue("IsPrimitiveDT")
    IS_PRIMITIVE_DT("IsPrimitiveDT"),
    @XmlEnumValue("RcvResp")
    RCV_RESP("RcvResp"),
    @XmlEnumValue("IsReferenceDT")
    IS_REFERENCE_DT("IsReferenceDT"),
    @XmlEnumValue("RespComm_id")
    RESP_COMM_ID("RespComm_id"),
    @XmlEnumValue("StartState")
    START_STATE("StartState"),
    @XmlEnumValue("StateAttribute")
    STATE_ATTRIBUTE("StateAttribute"),
    @XmlEnumValue("StateTransition")
    STATE_TRANSITION("StateTransition"),
    @XmlEnumValue("IsSubjectClass")
    IS_SUBJECT_CLASS("IsSubjectClass"),
    @XmlEnumValue("V23_Fields")
    V_23_FIELDS("V23_Fields"),
    @XmlEnumValue("V23_Datatype")
    V_23_DATATYPE("V23_Datatype"),
    @XmlEnumValue("Vocab_domain")
    VOCAB_DOMAIN("Vocab_domain"),
    @XmlEnumValue("Vocab_strength")
    VOCAB_STRENGTH("Vocab_strength");
    private final String value;

    HL7DefinedRoseProperty(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static HL7DefinedRoseProperty fromValue(String v) {
        for (HL7DefinedRoseProperty c: HL7DefinedRoseProperty.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
