package gov.va.med.pharmacy.persistence.dao;

import gov.va.med.pharmacy.persistence.model.OutboundNcpdpMsgEntity;

public interface OutboundNcpdpMsgDao {

	public long saveMsg(OutboundNcpdpMsgEntity outboundMsg);

	public OutboundNcpdpMsgEntity findById(long id);

}
