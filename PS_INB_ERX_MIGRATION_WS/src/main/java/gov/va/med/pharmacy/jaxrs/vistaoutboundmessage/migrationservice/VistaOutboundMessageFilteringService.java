package gov.va.med.pharmacy.jaxrs.vistaoutboundmessage.migrationservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import gov.va.med.pharmacy.jaxrs.vistaoutboundmessage.migrationservice.model.VistaOutboundResponse;


/**
 * This web service is to be called from vista which will send status and error messages.
 * These messages will be eventually sent to the eRx Providers.
 *
 */
@Consumes("application/x-www-form-urlencoded")
@Produces("application/xml")
public interface VistaOutboundMessageFilteringService {

	
	/**
	 * @param message
	 * @return
	 */
	public VistaOutboundResponse getOutboundMessage(String message );
}
