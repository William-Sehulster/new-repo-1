package gov.va.med.pharmacy.persistence.service;

import gov.va.med.pharmacy.persistence.model.InboundNcpdpMsgEntity;

public interface InboundNcpdpMsgService {
	
	void saveInboundERx(InboundNcpdpMsgEntity inboundeRx) throws Exception ;
	
}
