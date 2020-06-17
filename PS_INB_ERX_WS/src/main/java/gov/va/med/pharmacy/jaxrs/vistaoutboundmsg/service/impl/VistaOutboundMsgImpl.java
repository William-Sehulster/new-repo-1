package gov.va.med.pharmacy.jaxrs.vistaoutboundmsg.service.impl;

import java.io.StringReader;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.JAXB;

import org.springframework.beans.factory.annotation.Autowired;

import gov.va.med.pharmacy.jaxrs.vistaoutboundmsg.model.VistaOutboundResponse;
import gov.va.med.pharmacy.jaxrs.vistaoutboundmsg.service.VistaOutboundMsg;
import gov.va.med.pharmacy.ncpdpmsgs.MessageType;
import gov.va.med.pharmacy.persistence.model.OutboundNcpdpMsgEntity;
import gov.va.med.pharmacy.persistence.service.OutboundNcpdpMsgService;

/**
 * A class that implement saves vista outbound message which are coming from vista and sends response back in JSON.
 *
 */

@Consumes({"application/x-www-form-urlencoded", "application/xml", "text/xml"})
@Produces("application/xml")
public class VistaOutboundMsgImpl implements VistaOutboundMsg {

	
	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(VistaOutboundMsgImpl.class);
	
	@Autowired
	private OutboundNcpdpMsgService outboundNcpdpMsgService;
	
	@POST
	@Path("/processMessage/")
	public VistaOutboundResponse persistMessage(@FormParam("xmlRequest") String messageStr) {

		VistaOutboundResponse wsResponse = new VistaOutboundResponse();
		try {
			

			OutboundNcpdpMsgEntity  outboundMsg = new OutboundNcpdpMsgEntity();
			
			StringReader reader = new StringReader(messageStr);
		      
			outboundMsg.setMessage(JAXB.unmarshal(reader, MessageType.class));
			
			outboundMsg.setErxStatus("0000");
			
			outboundMsg.setPharmacyId(0);
			
			Date date = new Date();
			
			outboundMsg.setCreatedDate(date);

			outboundMsg.setUpdatedDate(date);

			outboundMsg.setReceivedDate(date);
			
			long outboundMsgId = outboundNcpdpMsgService.saveOutboundMsg(outboundMsg);
			
			System.out.println("------------------- Return id:"+outboundMsgId);
			
			wsResponse.setErrorMessage(null);
			
			wsResponse.setSuccess(true);		
			
			wsResponse.setOutboundMsgId(outboundMsgId);
					

		} catch (Exception e) {

			LOG.error("Error in VistaOutboundMsgImpl:"+e.getMessage());
			
			wsResponse.setSuccess(false);

			wsResponse.setErrorMessage("Error while saving vista outbound message: " + e.getMessage());
			
			wsResponse.setOutboundMsgId(0);
		}

		return wsResponse;
	}
	
	@POST
	@Path("/processXMLMessage/")
	public VistaOutboundResponse persistXMLMessage(MessageType message) {

		VistaOutboundResponse wsResponse = new VistaOutboundResponse();
		try {
			
			OutboundNcpdpMsgEntity  outboundMsg = new OutboundNcpdpMsgEntity();
		      
			outboundMsg.setMessage(message);
			
			outboundMsg.setErxStatus("0000");
			
			outboundMsg.setPharmacyId(0);
			
			Date date = new Date();
			
			outboundMsg.setCreatedDate(date);

			outboundMsg.setUpdatedDate(date);

			outboundMsg.setReceivedDate(date);
						
			long outboundMsgId = outboundNcpdpMsgService.saveOutboundMsg(outboundMsg);
			
			wsResponse.setErrorMessage(null);
			
			wsResponse.setSuccess(true);		
			
			wsResponse.setOutboundMsgId(outboundMsgId);
					

		} catch (Exception e) {

			LOG.error("Error in VistaOutboundMsgImpl:"+e.getMessage());
			
			wsResponse.setSuccess(false);

			wsResponse.setErrorMessage("Error while saving vista outbound message: " + e.getMessage());
			
			wsResponse.setOutboundMsgId(0);
		}

		return wsResponse;
	}


}
