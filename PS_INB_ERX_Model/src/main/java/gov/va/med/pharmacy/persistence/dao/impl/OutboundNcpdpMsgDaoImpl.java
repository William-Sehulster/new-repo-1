package gov.va.med.pharmacy.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import gov.va.med.pharmacy.persistence.BaseDao;
import gov.va.med.pharmacy.persistence.dao.OutboundNcpdpMsgDao;
import gov.va.med.pharmacy.persistence.model.OutboundNcpdpMsgEntity;

@Repository("outboundNcpdpMsgDao")
public class OutboundNcpdpMsgDaoImpl extends BaseDao<Integer, OutboundNcpdpMsgEntity> implements OutboundNcpdpMsgDao {

	@Override
	public long saveMsg(OutboundNcpdpMsgEntity outboundMsg) {

		long outboundMsgID = saveWithId(outboundMsg);

		return outboundMsgID;

	}

	@Override
	public OutboundNcpdpMsgEntity findById(long id) {

		OutboundNcpdpMsgEntity OutboundNcpdpMsg = getByKey(id);

		return OutboundNcpdpMsg;
	}

}
