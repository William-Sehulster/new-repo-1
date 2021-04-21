package gov.va.med.pharmacy.jaxrs.tovista.dao.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

import gov.va.med.pharmacy.jaxrs.tovista.model.VistaInbound;
import gov.va.med.pharmacy.jaxrs.tovista.model.VistaInboundNcpdpMsg;
import gov.va.med.pharmacy.utility.StreamUtilities;
import gov.va.med.pharmacy.utility.VistaLinkConnectionUtility;
import gov.va.med.vistalink.rpc.RpcResponse;


/**
 * This class makes RPC call to Vista to send the Inbound NCPDP message.
 *
 */
public class VistaInboundRpc {
	
	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(VistaInboundRpc.class);
	private VistaInboundNcpdpMsgDaoImpl vistaInboundNcpdpMsgDao;
	private VistaLinkConnectionUtility vistaLinkConnectionUtility;
	private final int MAX_STR_LEN = 32000;
	private final int MAX_STR_SIZE = 32000;
	private final int EXPECTED_BUFFER_DATA = 32000;
	
	public VistaInboundNcpdpMsgDaoImpl getVistaInboundNcpdpMsgDao() {
		return vistaInboundNcpdpMsgDao;
	}
	public void setVistaInboundNcpdpMsgDao(VistaInboundNcpdpMsgDaoImpl vistaInboundNcpdpMsgDao) {
		this.vistaInboundNcpdpMsgDao = vistaInboundNcpdpMsgDao;
	}
	public VistaLinkConnectionUtility getVistaLinkConnectionUtility() {
		return vistaLinkConnectionUtility;
	}
	public void setVistaLinkConnectionUtility(VistaLinkConnectionUtility vistaLinkConnectionUtility) {
		this.vistaLinkConnectionUtility = vistaLinkConnectionUtility;
	}
	
	
	public VistaInbound sendMessage(VistaInbound sendObj) throws IOException, SQLException {


		
		VistaInbound searchResults = new VistaInbound();
		
		VistaInboundNcpdpMsg vistaInboundNcpdpMsg = new VistaInboundNcpdpMsg();

		RpcResponse rpcResponse;
		
		//10.6 RPC
		//String rpcName ="PSOERXA1 INCERX";
		
		//2017071 RPC
		String rpcName ="PSOERXI1 INCERX";
		
		String rpcContext ="PSO WEB SERVICES OPTION";
		
		ArrayList<Object> params = new ArrayList<Object>();

		vistaInboundNcpdpMsg = vistaInboundNcpdpMsgDao.findById(sendObj.getxmlInboundMessageId());
		

		//Alternate send as a String
		StringBuilder sb = new StringBuilder(EXPECTED_BUFFER_DATA);
		StringBuilder sb2 = new StringBuilder(EXPECTED_BUFFER_DATA);
		StringBuilder sb3 = new StringBuilder(EXPECTED_BUFFER_DATA);
		String xmlList = "";
		String xmlList2 = "";
		String xmlList3 = "";
	
		Reader reader = vistaInboundNcpdpMsg.getMessage().getCharacterStream();
        BufferedReader br = new BufferedReader(reader);
        String line = null;
        int i = 0;
        boolean addLine = true;
        boolean addLine2 = false;
        String messageType = "";
        String messageEndTag = "";
        
        try{
                sb.setLength(0);
                sb2.setLength(0);
                sb3.setLength(0);
                i = 0;
                
                messageType = vistaInboundNcpdpMsg.getMessageType().trim();
                
            	sb2.append("<Message><Body><" + messageType + ">");
                sb3.append("<Message><Body><" + messageType + ">");
                messageEndTag = "</" + messageType + ">";
                
               
                	while(null != (line = br.readLine())) {
                		
                		if (line.trim().equalsIgnoreCase("<Patient>")){
                			addLine = false;
                			addLine2 = true;
                		}
                		
                		//Add the message type (/NewRx, etc..), Body and Message tag to the end of the first XML segment
                		if (line.trim().equalsIgnoreCase(messageEndTag)){
                			addLine = true;
                			addLine2 = false;
                		}
                			
                		if (addLine == true){
                			sb.append(line.trim().replaceAll("[\\000]*", ""));	
                			LOG.debug("sb1("+ i +")=" +line.trim());	
                		}else if (addLine2 == true){
                			sb2.append(line.trim().replaceAll("[\\000]*", ""));
                			LOG.debug("sb2("+ i +")=" +line.trim());	
                		}else{
                			sb3.append(line.trim().replaceAll("[\\000]*", ""));
                			LOG.debug("sb3("+ i +")=" +line.trim());	
                		}
                			
                		
                		if (line.trim().equalsIgnoreCase("</Prescriber>")){
                			addLine2 = false;
                		}


                		if (sb.length() >= MAX_STR_LEN) {
                          LOG.error("MSG:" + vistaInboundNcpdpMsg.getInboundNcpdpMsgId() + " Length of StringBuffer sb (first)("+ sb.length() +")");
                		  throw new IOException("MSG:" + vistaInboundNcpdpMsg.getInboundNcpdpMsgId() + " String Buffer (first) input too long.");
                		    }
                		if (sb2.length() >= MAX_STR_LEN) {
                      	  LOG.error("MSG:" + vistaInboundNcpdpMsg.getInboundNcpdpMsgId() + " Length of StringBuffer sb2 (second)("+ sb2.length() +")");
               		      throw new IOException("MSG:" + vistaInboundNcpdpMsg.getInboundNcpdpMsgId() + " String Buffer (second) input too long.");
               		    	}
                		if (sb3.length() >= MAX_STR_LEN) {
                        	  LOG.error("MSG:" + vistaInboundNcpdpMsg.getInboundNcpdpMsgId() + " Length of StringBuffer sb3 (third)("+ sb3.length() +")");
                 		      throw new IOException("MSG:" + vistaInboundNcpdpMsg.getInboundNcpdpMsgId() + " String Buffer (third) input too long.");
                 		    }
                		i++;     		
                	}
                	               	
                	sb2.append("</" + messageType + ">" + "</Body></Message>");
                    sb3.append("</" + messageType + ">" + "</Body></Message>");


                	if (String.valueOf(sb).getBytes().length >= MAX_STR_SIZE) {
                      LOG.error("MSG:" + vistaInboundNcpdpMsg.getInboundNcpdpMsgId() + " Length of StringBuffer sb (bytes)("+ String.valueOf(sb).getBytes().length +")");
          		      throw new IOException("MSG:" + vistaInboundNcpdpMsg.getInboundNcpdpMsgId() + " String byte size of first XML segment of message too large.");
          		    }
                	if (String.valueOf(sb2).getBytes().length >= MAX_STR_SIZE) {
                	  LOG.error("MSG:" + vistaInboundNcpdpMsg.getInboundNcpdpMsgId() + " Length of StringBuffer sb2 (bytes)("+ String.valueOf(sb2).getBytes().length +")");
         		      throw new IOException("MSG:" + vistaInboundNcpdpMsg.getInboundNcpdpMsgId() + " String byte size of second XML segment of message too large.");
         		    	}
                	if (String.valueOf(sb3).getBytes().length >= MAX_STR_SIZE) {
                  	  LOG.error("MSG:" + vistaInboundNcpdpMsg.getInboundNcpdpMsgId() + " Length of StringBuffer sb3 (bytes)("+ String.valueOf(sb3).getBytes().length +")");
           		      throw new IOException("MSG:" + vistaInboundNcpdpMsg.getInboundNcpdpMsgId() + " String byte size of third XML segment of message too large.");
           		    	}
        	

        	xmlList = sb.toString(); 
        	
        	//If messageType is Error or Verify then send empty xml2 and xml3 parameters
			if (messageType.equalsIgnoreCase("Error") || messageType.equalsIgnoreCase("Verify")) {
				xmlList2 = "";
				xmlList3 = "";
			} else {
				xmlList2 = sb2.toString();
				xmlList3 = sb3.toString();
			}

        }
        
        finally{
        		StreamUtilities.safeClose(br);

        } 
	
	        
	    HashMap<String, String> providerHm = new HashMap<String, String>();
	    Arrays.asList(vistaInboundNcpdpMsg.getProviderMatchDetails().split("\\|")).forEach((temp1) -> {
	    providerHm.put(temp1.substring(temp1.indexOf('"') + 1, temp1.lastIndexOf('"')),temp1.substring(temp1.indexOf("=") + 1).trim());
	    LOG.debug(providerHm.toString());
	    });

	    HashMap<String, String> drugHm = new HashMap<String, String>();
	    Arrays.asList(vistaInboundNcpdpMsg.getDrugMatchDetails().split("\\|")).forEach((temp2) -> {
	    drugHm.put(temp2.substring(temp2.indexOf('"') + 1, temp2.lastIndexOf('"')),temp2.substring(temp2.indexOf("=") + 1).trim());
	    LOG.debug(drugHm.toString());
	    });
	    
	    HashMap<String, String> patientHm = new HashMap<String, String>();
	    Arrays.asList(vistaInboundNcpdpMsg.getPatientMatchDetails().split("\\|")).forEach((temp3) -> {
	    patientHm.put(temp3.substring(temp3.indexOf('"') + 1, temp3.lastIndexOf('"')),temp3.substring(temp3.indexOf("=") + 1).trim());
	    LOG.debug(patientHm.toString());
	    });
	    
		HashMap<String, String> codeTransHm = new HashMap<String, String>();
		if (vistaInboundNcpdpMsg.getPotencyUnitCode() != null && vistaInboundNcpdpMsg.getPotencyUnitText()!=null) {
			codeTransHm.put("PotencyUnitCode", vistaInboundNcpdpMsg.getPotencyUnitCode().concat("^").concat(vistaInboundNcpdpMsg.getPotencyUnitText()));
		};
		if (vistaInboundNcpdpMsg.getDrugForm() != null && vistaInboundNcpdpMsg.getDrugFormText()!=null) {
			codeTransHm.put("FormCode", vistaInboundNcpdpMsg.getDrugForm().concat("^").concat(vistaInboundNcpdpMsg.getDrugFormText()));
		};
		if (vistaInboundNcpdpMsg.getDrugStrengthCode() != null && vistaInboundNcpdpMsg.getDrugStrengthText()!=null ) {
			codeTransHm.put("StrengthCode", vistaInboundNcpdpMsg.getDrugStrengthCode().concat("^").concat(vistaInboundNcpdpMsg.getDrugStrengthText()));
		};
		if (vistaInboundNcpdpMsg.getProhibitRenewalRequest() != null && vistaInboundNcpdpMsg.getProhibitRenewalRequest()!=null ) {
			codeTransHm.put("PRRFlag", vistaInboundNcpdpMsg.getProhibitRenewalRequest());
		};

	    LOG.debug(codeTransHm.toString());
	    
	    //set the VistA parameters in proper order
        params.add(xmlList); //XML - xml text 
        params.add(providerHm); //PRCHK - provider check information 
        params.add(patientHm);  //PACHK - patient check information 
        params.add(drugHm); //DACHK - drug auto check
        if (vistaInboundNcpdpMsg.getVaStationId() != null){
        	params.add(vistaInboundNcpdpMsg.getVaStationId()); //STATION  - pharmacy.va_station_id
        } else {
			params.add("");									
		}
        if (vistaInboundNcpdpMsg.getDivisionName() != null && vistaInboundNcpdpMsg.getNpi() != null){
        	params.add(vistaInboundNcpdpMsg.getDivisionName().concat("^").concat(vistaInboundNcpdpMsg.getNpi()));  //DIVISION^NPI   - pharmacy.division_name^pharmacy.npi 
        } else {
			params.add("");									
		}
        if (vistaInboundNcpdpMsg.getMessageType().equalsIgnoreCase("CancelRx") && vistaInboundNcpdpMsg.getCancelRxDenied() != null){
        	params.add(String.valueOf(vistaInboundNcpdpMsg.getInboundNcpdpMsgId()).concat("^").concat(vistaInboundNcpdpMsg.getCancelRxDenied()));  // ERXREFNUM - the inbound_ncpdp_msg.inbound_ncpdp_msg_id	ERXREFNUM^1 if CancelRx = Denied
        } else if (vistaInboundNcpdpMsg.getRelToOutboundNcpdpMsgId() == 0) {
        	params.add(String.valueOf(vistaInboundNcpdpMsg.getInboundNcpdpMsgId()).concat("^^"));  // ERXREFNUM - the inbound_ncpdp_msg.inbound_ncpdp_msg_id
        } else {
        	params.add(String.valueOf(vistaInboundNcpdpMsg.getInboundNcpdpMsgId()).concat("^^V").concat(String.valueOf(vistaInboundNcpdpMsg.getRelToOutboundNcpdpMsgId())));  // ERXREFNUM - the inbound_ncpdp_msg.inbound_ncpdp_msg_id
        }
        
		params.add(codeTransHm); //C-code translations

		params.add(xmlList2); //Structured Sig segment etc. of xml (second chunk)
		
		params.add(""); //blank parameter
		
		//send a blank parameter instead of <Message><Body><RxChangeResponse></RxChangeResponse></Body></Message> when no MedicationPrescribed segment is sent
		if (xmlList3.contains("<Message><Body><RxChangeResponse></RxChangeResponse></Body></Message>")) {
			params.add(""); //blank parameter
		} else {
			params.add(xmlList3); //after Sig segment of xml (third chunk)
		}
		
		LOG.debug("RPC Params: " + params.toString());

		try {	
			rpcResponse = vistaLinkConnectionUtility.sendRequest(sendObj.getDivision(), rpcContext, rpcName, params);
		} catch (Exception e) {
			LOG.error("Error in VistaInboundRPC RPC:"+e.getMessage());
			throw new IOException(e);
		}

		String response = rpcResponse.getResults(); 
		
		
		if(StringUtils.isNotEmpty(response) && (!StringUtils.startsWith(response, "0") ) )  
		{
			searchResults.setSuccess(true);
		}
		else{
			searchResults.setVistaMessage(response.substring(response.indexOf("^")+1,response.length() ));
			searchResults.setSuccess(false);
		}
		return searchResults;


	}

}
