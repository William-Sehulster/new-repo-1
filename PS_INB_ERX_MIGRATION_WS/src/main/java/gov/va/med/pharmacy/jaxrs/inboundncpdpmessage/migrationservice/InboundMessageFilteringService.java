package gov.va.med.pharmacy.jaxrs.inboundncpdpmessage.migrationservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;


/**
 * This web service will be called from the change healthcare and will accept the incoming NCPDP message (eRx or others) via DAS proxy.
 * This service is used to filter Inbound NCPDP message for Pharmacies using v2.1 and version 3.0 of Inbound eRx.
  *
 */
@Consumes("application/xml")
@Produces("application/xml")
public interface InboundMessageFilteringService {

	
	/**
	 * @param message
	 * @return
	 */
	public String getInboundMessage(String incomingMessage);
}
