package gov.va.med.pharmacy.jaxrs.tovista.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import gov.va.med.pharmacy.jaxrs.tovista.model.VistaInbound;
import gov.va.med.pharmacy.jaxrs.tovista.model.VistaInboundResponse;

/**
 * Drug search interface.
 *
 */
@Consumes("application/json")
@Produces("application/json")
public interface VistaInboundSend {

	/**
	 * @param request
	 * @return VistaInboundResponse
	 */
	
	public VistaInboundResponse send(VistaInbound messageSendObj );
}
