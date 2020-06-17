package gov.va.med.pharmacy.jaxrs.inboundncpdpmessage.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;


/**
 * This web service will be called from the change healthcare and will accept the incoming NCPDP message (eRx or others) via DAS proxy.
  *
 */
@Consumes("application/xml")
@Produces("application/xml")
public interface InboundNCPDPMessageService {

	
	/**
	 * @param message
	 * @return
	 */
	public String getInboundMessage(String incomingMessage);
}
