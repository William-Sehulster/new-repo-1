package gov.va.med.pharmacy.jaxrs.tovista.service.impl;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import gov.va.med.pharmacy.jaxrs.tovista.dao.impl.VistaInboundDaoImpl;
import gov.va.med.pharmacy.jaxrs.tovista.model.VistaInbound;
import gov.va.med.pharmacy.jaxrs.tovista.model.VistaInboundResponse;
import gov.va.med.pharmacy.jaxrs.tovista.service.VistaInboundSend;

/**
 * A class that implements vista message delivery by taking different call parameters
 * and calls Vista RPC for delivery of inbound message and sends response back in JSON.
 *
 */

@Consumes("application/json")
@Produces("application/json")
public class VistaInboundSendImpl implements VistaInboundSend {

	private VistaInboundDaoImpl vistaInboundDao;
	
	public VistaInboundDaoImpl getVistaInboundDao() {
		return vistaInboundDao;
	}
	public void setVistaInboundDao(VistaInboundDaoImpl vistaInboundDao) {
		this.vistaInboundDao = vistaInboundDao;
	}
	
	@POST
	@Path("/toVista/")
	public VistaInboundResponse send(VistaInbound messageObj) {

		VistaInboundResponse sendResponse = new VistaInboundResponse();

		try {

			VistaInbound sendResults = vistaInboundDao.sendMessage(messageObj);

			sendResponse.setVistaMessage(sendResults.getVistaMessage());
			
			sendResponse.setSuccess(sendResults.getSuccess());


		} catch (IOException e) {
			sendResponse.setSuccess(false);

			sendResponse.setErrorMessage("Error while sending vista inbound message: " + e.getMessage());
		}

		return sendResponse;
	}


}
