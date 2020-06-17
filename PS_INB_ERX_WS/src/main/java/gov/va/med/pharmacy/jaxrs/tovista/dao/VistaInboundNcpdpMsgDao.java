package gov.va.med.pharmacy.jaxrs.tovista.dao;

import gov.va.med.pharmacy.jaxrs.tovista.model.VistaInboundNcpdpMsg;

public interface VistaInboundNcpdpMsgDao {

	public  VistaInboundNcpdpMsg  findById(long id);
}
