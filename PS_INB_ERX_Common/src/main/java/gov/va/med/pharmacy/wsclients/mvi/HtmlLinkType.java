
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HtmlLinkType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HtmlLinkType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="alternate"/&gt;
 *     &lt;enumeration value="appendix"/&gt;
 *     &lt;enumeration value="bookmark"/&gt;
 *     &lt;enumeration value="chapter"/&gt;
 *     &lt;enumeration value="contents"/&gt;
 *     &lt;enumeration value="copyright"/&gt;
 *     &lt;enumeration value="glossary"/&gt;
 *     &lt;enumeration value="help"/&gt;
 *     &lt;enumeration value="index"/&gt;
 *     &lt;enumeration value="next"/&gt;
 *     &lt;enumeration value="prev"/&gt;
 *     &lt;enumeration value="section"/&gt;
 *     &lt;enumeration value="start"/&gt;
 *     &lt;enumeration value="stylesheet"/&gt;
 *     &lt;enumeration value="subsection"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "HtmlLinkType")
@XmlEnum
public enum HtmlLinkType {

    @XmlEnumValue("alternate")
    ALTERNATE("alternate"),
    @XmlEnumValue("appendix")
    APPENDIX("appendix"),
    @XmlEnumValue("bookmark")
    BOOKMARK("bookmark"),
    @XmlEnumValue("chapter")
    CHAPTER("chapter"),
    @XmlEnumValue("contents")
    CONTENTS("contents"),
    @XmlEnumValue("copyright")
    COPYRIGHT("copyright"),
    @XmlEnumValue("glossary")
    GLOSSARY("glossary"),
    @XmlEnumValue("help")
    HELP("help"),
    @XmlEnumValue("index")
    INDEX("index"),
    @XmlEnumValue("next")
    NEXT("next"),
    @XmlEnumValue("prev")
    PREV("prev"),
    @XmlEnumValue("section")
    SECTION("section"),
    @XmlEnumValue("start")
    START("start"),
    @XmlEnumValue("stylesheet")
    STYLESHEET("stylesheet"),
    @XmlEnumValue("subsection")
    SUBSECTION("subsection");
    private final String value;

    HtmlLinkType(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static HtmlLinkType fromValue(String v) {
        for (HtmlLinkType c: HtmlLinkType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
