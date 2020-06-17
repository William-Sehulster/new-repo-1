package gov.va.med.pharmacy.jaxrs.tovista.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import gov.va.med.pharmacy.jaxrs.tovista.dao.VistaInboundNcpdpMsgDao;
import gov.va.med.pharmacy.jaxrs.tovista.model.VistaInboundNcpdpMsg;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class VistaInboundNcpdpMsgDaoImpl implements VistaInboundNcpdpMsgDao {
	private DataSource dataSource;
	
	
	 public VistaInboundNcpdpMsgDaoImpl(DataSource dataSource) {
	        this.dataSource = dataSource;
	    }
	 
	public class VistaInboundNcpdpMsgRowMapper implements RowMapper<Object>
	{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
			VistaInboundNcpdpMsg vistaInboundNcpdpMsg = new VistaInboundNcpdpMsg();
			vistaInboundNcpdpMsg.setMessageId(rs.getString("message_id"));
    		vistaInboundNcpdpMsg.setRelToMessageId(rs.getString("rel_to_message_id"));
    		vistaInboundNcpdpMsg.setMessageFrom(rs.getString("message_from"));
    		vistaInboundNcpdpMsg.setMessageType(rs.getString("message_type").trim());
    		vistaInboundNcpdpMsg.setMessage(rs.getClob("message"));
    		vistaInboundNcpdpMsg.setPatientMatchDetails(rs.getString("patient_match_details"));
    		vistaInboundNcpdpMsg.setProviderMatchDetails(rs.getString("provider_match_details"));
    		vistaInboundNcpdpMsg.setDrugMatchDetails(rs.getString("drug_match_details"));
    		vistaInboundNcpdpMsg.setInboundNcpdpMsgId(rs.getLong("inbound_ncpdp_msg_id"));
    		vistaInboundNcpdpMsg.setDivisionName(rs.getString("division_name"));
    		vistaInboundNcpdpMsg.setVaStationId(rs.getString("va_station_id"));
    		vistaInboundNcpdpMsg.setPotencyUnitCode(rs.getString("rx_Potency_Unit_Code"));
    		vistaInboundNcpdpMsg.setPotencyUnitText(rs.getString("rx_Potency_Unit_Text"));
    		vistaInboundNcpdpMsg.setDrugForm(rs.getString("rx_Drug_Form"));
    		vistaInboundNcpdpMsg.setDrugFormText(rs.getString("rx_Drug_Form_Text"));
    		vistaInboundNcpdpMsg.setDrugStrengthCode(rs.getString("rx_Drug_Strength_Code"));
    		vistaInboundNcpdpMsg.setDrugStrengthText(rs.getString("rx_Drug_Strength_Text"));
    		vistaInboundNcpdpMsg.setNpi(rs.getString("npi"));
    		vistaInboundNcpdpMsg.setCancelRxDenied(rs.getString("cancel_rx_denied"));
    		vistaInboundNcpdpMsg.setRelToOutboundNcpdpMsgId(rs.getLong("rel_to_outbound_ncpdp_msg_id"));
    		
    		return vistaInboundNcpdpMsg;
		}
	}
	@Override
	public VistaInboundNcpdpMsg findById(long id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "select a.message_id as message_id,\r\n" + 
        		"        		a.rel_to_message_id as rel_to_message_id,\r\n" + 
        		"        		a.message_from as message_from, \r\n" + 
        		"        		a.inbound_ncpdp_msg_id as inbound_ncpdp_msg_id,\r\n" + 
        		"        		a.message_type as message_type,\r\n" +
        		"        		(select division_name from pharmacy where pharmacy_id = a.pharmacy_id) division_name,\r\n" + 
        		"        		(select va_station_id from pharmacy where pharmacy_id = a.pharmacy_id) va_station_id,\r\n" + 
        		"XMLSerialize(document a.message as clob) as message,\r\n" + 
        		"'PRCHK(\"firstName\")='||provider_info.providerFirstName||'|'||\r\n" + 
        		"'PRCHK(\"lastName\")='||provider_info.providerLastName||'|'||\r\n" + 
        		"'PRCHK(\"IEN\")='||provider_info.providerIEN||'|'||\r\n" + 
        		"'PRCHK(\"error\")='||provider_info.errorMessage||'|'||\r\n" + 
        		"'PRCHK(\"success\")='||provider_info.success as provider_match_details,\r\n" + 
        		"'DRGCHK(\"drugName\")='||drug_info.drugName||'|'||\r\n" + 
        		"'DRGCHK(\"IEN\")='||drug_info.drugIEN||'|'||\r\n" + 
        		"'DRGCHK(\"error\")='||drug_info.errorMessage||'|'||\r\n" + 
        		"'DRGCHK(\"success\")='||drug_info.success||'|' as drug_match_details,\r\n" + 
        		"'PACHK(\"ICN\")='||patient_info.ICN||'|'||\r\n" + 
        		"'PACHK(\"MVIerror\")='||patient_info.MVIerror||'|'||\r\n" + 
        		"'PACHK(\"firstName\")='||patient_info.firstName||'|'||\r\n" + 
        		"'PACHK(\"lastName\")='||patient_info.lastName||'|'||\r\n" + 
        		"'PACHK(\"ssn\")='||patient_info.ssn||'|'||\r\n" + 
        		"'PACHK(\"dob\")='||patient_info.dob||'|'||\r\n" + 
        		"'PACHK(\"siteMatch\")='||patient_info.siteMatch||'|'||\r\n" + 
        		"'PACHK(\"regAtStationIDs\")='||patient_info.regAtStationIDs||'|'||\r\n" + 
        		"'PACHK(\"eligStatus\")='||patient_info.eligStatus||'|'||\r\n" + 
        		"'PACHK(\"enrollStatus\")='||patient_info.enrollStatus||'|'||\r\n" + 
        		"'PACHK(\"EandEerror\")='||patient_info.EandEerror||'|'||\r\n" + 
        		"'PACHK(\"success\")='||patient_info.success  as patient_match_details,\r\n" + 
        		"t.rx_Potency_Unit_Code,\r\n" + 
        		"nvl ( (select distinct ncit_pref_term from ncpdp_code where ncit_code = t.rx_Potency_Unit_Code), 'Unknown' )rx_Potency_Unit_Text, \r\n" + 
        		"t.rx_Drug_Form,\r\n" + 
        		"(select distinct ncit_pref_term from ncpdp_code where ncit_code = t.rx_Drug_Form) rx_Drug_Form_Text,\r\n" + 
        		"t.rx_Drug_Strength_Code,\r\n" + 
        		"(select distinct ncit_pref_term from ncpdp_code where ncit_code = t.rx_Drug_Strength_Code) rx_Drug_Strength_Text,\r\n" + 
        		"        		(select npi from pharmacy where pharmacy_id = a.pharmacy_id) npi, message_status_info.cancelRxDenied cancel_rx_denied,  \r\n" + 
        		"        		        		message_status_info.relToOutboundNcpdpMsgId rel_to_outbound_ncpdp_msg_id from inbound_ncpdp_msg a,\r\n" + 
        		"                xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' as \"ns\"), '/ns:Message'\r\n" + 
        		"                passing a.message\r\n" + 
        		"                columns \r\n" + 
        		"                rx_Potency_Unit_Code varchar2(30) path '//ns:MedicationPrescribed/ns:Quantity/ns:PotencyUnitCode',\r\n" + 
        		"                rx_Drug_Form varchar2(30) path '//ns:MedicationPrescribed/ns:DrugCoded/ns:FormCode', \r\n" + 
        		"                rx_Drug_Strength_Code varchar2(30) path '//ns:MedicationPrescribed/ns:DrugCoded/ns:StrengthCode') t,        \r\n" + 
        		"                xmltable('/patientCheck' passing xmltype(nvl(a.patient_match_details,\r\n" + 
        		"                '<patientCheck></patientCheck>')) \r\n" + 
        		"        		    columns  \r\n" + 
        		"        		    ICN varchar2(35) path '//patientICN', \r\n" + 
        		"        		    MVIerror varchar2(2000) path '//mvi/errorMessage', \r\n" + 
        		"        		    firstName varchar2(35) path '//patientFirstName', \r\n" + 
        		"        		    lastName varchar2(35) path '//patientLastName', \r\n" + 
        		"        		    ssn varchar2(35) path '//patientSSN', \r\n" + 
        		"        		    dob varchar2(35) path '//patientDateOfBirth', \r\n" + 
        		"        		    siteMatch varchar2(35) path '//siteMatch', \r\n" + 
        		"        		    regAtStationIDs varchar2(35) path '//patientStationIds', \r\n" + 
        		"        		    eligStatus varchar2(35) path '//eande/eligibilityStatus', \r\n" + 
        		"        		    enrollStatus varchar2(35) path '//eande/enrollmentStatus', \r\n" + 
        		"        		    EandEerror varchar2(2000) path '//eande/errorMessage', \r\n" + 
        		"        		    success varchar2(35) path '//success' \r\n" + 
        		"        		    ) patient_info, xmltable('/drugCheck' \r\n" + 
        		"        		    passing xmltype(nvl(a.drug_match_details,'<drugCheck></drugCheck>')) \r\n" + 
        		"        		    columns  \r\n" + 
        		"        		    drugIEN varchar2(35) path '//drugIEN', \r\n" + 
        		"        		    errorMessage varchar2(2000) path '//errorMessage', \r\n" + 
        		"        		    drugName varchar2(35) path '//drugName', \r\n" + 
        		"        		    success varchar2(35) path '//success' \r\n" + 
        		"        		    ) drug_info,xmltable('/providerCheck' \r\n" + 
        		"        		    passing xmltype(nvl(a.provider_match_details,'<providerCheck></providerCheck>')) \r\n" + 
        		"        		    columns  \r\n" + 
        		"        		    providerIEN varchar2(35) path '//providerIEN', \r\n" + 
        		"        		    errorMessage varchar2(2000) path '//errorMessage', \r\n" + 
        		"        		    providerFirstName varchar2(35) path '//providerFirstName', \r\n" + 
        		"        		    providerLastName varchar2(35) path '//providerLastName', \r\n" + 
        		"        		    success varchar2(35) path '//success' \r\n" + 
        		"        		    ) provider_info,xmltable('/messageStatusDetails' \r\n" + 
        		"        		    passing xmltype(nvl(a.message_status_details,'<messageStatusDetails></messageStatusDetails>')) \r\n" + 
        		"        		    columns  \r\n" + 
        		"        		    cancelRxDenied varchar2(100) path '//cancelRxDenied', \r\n" + 
        		"					relToOutboundNcpdpMsgId number path '//relToOutboundNcpdpMsgId' \r\n" +
        		"        		    ) message_status_info    \r\n" + 
        		"        		        		where a.inbound_ncpdp_msg_id = ?";
        
        VistaInboundNcpdpMsg vistaInboundNcpdpMsg =  (VistaInboundNcpdpMsg) jdbcTemplate.queryForObject(sql, new Object[] { id },new VistaInboundNcpdpMsgRowMapper());

		return vistaInboundNcpdpMsg;

	}

}
