package gov.va.med.pharmacy.persistence.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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

	@Override
	public InboundNcpdpMsgEntity findByMessageId(String msgId) {

		Criteria criteria = createEntityCriteria();

		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); // for unique results

		if (msgId != null) {

			criteria.add(Restrictions.eq("messageId", msgId));
		}

		InboundNcpdpMsgEntity inboundNcpdpMsg = (InboundNcpdpMsgEntity) criteria.uniqueResult();

		return inboundNcpdpMsg;
	}

}
