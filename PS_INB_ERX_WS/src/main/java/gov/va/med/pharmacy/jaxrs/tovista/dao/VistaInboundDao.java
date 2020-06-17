package gov.va.med.pharmacy.jaxrs.tovista.dao;

import java.io.IOException;

import gov.va.med.pharmacy.jaxrs.tovista.model.VistaInbound;

public interface VistaInboundDao {

	
	/**
	 * @param vistaInboundObj
	 * @return
	 * @throws IOException
	 */
	public VistaInbound sendMessage(VistaInbound vistaInboundObj) throws IOException;
}
