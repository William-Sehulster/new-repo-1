package gov.va.med.pharmacy.jaxrs.tovista.dao.impl;

import java.io.IOException;

import gov.va.med.pharmacy.jaxrs.tovista.dao.VistaInboundDao;
import gov.va.med.pharmacy.jaxrs.tovista.model.VistaInbound;

/**
 * This class acts as Data Access Object layer, calls RPC and does data
 * processing to build up vistaInbound object.
 *
 */

public class VistaInboundDaoImpl implements VistaInboundDao {
	private VistaInboundRpc vistaInboundRpc;
	
	public VistaInboundRpc getVistaInboundRpc() {
		return vistaInboundRpc;
	}
	public void setVistaInboundRpc(VistaInboundRpc vistaInboundRpc) {
		this.vistaInboundRpc = vistaInboundRpc;
	}
	
	@Override
	public VistaInbound sendMessage(VistaInbound vistaInboundObj) throws IOException {

			
		VistaInbound sendResults = null;
	
		try {
		
			sendResults = vistaInboundRpc.sendMessage(vistaInboundObj);

		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException(e); // let the exception go all the way up.
		}

		return sendResults;

	}

}
