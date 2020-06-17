package gov.va.med.pharmacy.jaxrs.outboundncpdpmessage.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import gov.va.med.pharmacy.jaxrs.outboundncpdpmessage.model.OutboundNCPDPMessageRequest;
import gov.va.med.pharmacy.jaxrs.outboundncpdpmessage.model.OutboundNCPDPMessageResponse;


/**
 * This web service will be called from the pentaho job and will send the  outbound messages(NCPDP compliant) to the VLER DAS.
  *
 */
@Consumes("application/json")
@Produces("application/json")
public interface OutboundNCPDPMessageService {

	
	/**
	 * @param message
	 * @return
	 */
	public OutboundNCPDPMessageResponse sendOutboundMessage(OutboundNCPDPMessageRequest outboundRequest);
}
