package gov.va.med.pharmacy.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import gov.va.med.pharmacy.persistence.BaseDao;
import gov.va.med.pharmacy.persistence.dao.InboundNcpdpMsgDao;
import gov.va.med.pharmacy.persistence.model.InboundNcpdpMsgEntity;

@Repository("inboundNcpdpMsgDao")
public class InboundNcpdpMsgDaoImpl extends BaseDao<Integer, InboundNcpdpMsgEntity> implements InboundNcpdpMsgDao {

	@Override
	public void save(InboundNcpdpMsgEntity inboundeRx) {
		 persist(inboundeRx);
		
	}

}
