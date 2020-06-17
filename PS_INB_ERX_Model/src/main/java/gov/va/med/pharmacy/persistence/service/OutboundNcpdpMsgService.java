package gov.va.med.pharmacy.persistence.service;

import gov.va.med.pharmacy.persistence.model.OutboundNcpdpMsgEntity;

public interface OutboundNcpdpMsgService {
	
	public long saveOutboundMsg(OutboundNcpdpMsgEntity outboundMsg) throws Exception ;
	
	public OutboundNcpdpMsgEntity findById(long id);
}
