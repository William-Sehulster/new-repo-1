package gov.va.med.pharmacy.jaxrs.vistaoutboundmsg.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import gov.va.med.pharmacy.jaxrs.vistaoutboundmsg.model.VistaOutboundResponse;


/**
 * This web service is to be called from vista which will send status and error messages.
 * These messages will be eventually sent to the eRx Providers.
 *
 */
@Consumes("application/x-www-form-urlencoded")
@Produces("application/xml")
public interface VistaOutboundMsg {

	
	/**
	 * @param message
	 * @return
	 */
	public VistaOutboundResponse persistMessage(String message );
}
