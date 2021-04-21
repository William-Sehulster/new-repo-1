package gov.va.med.pharmacy.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.va.med.pharmacy.persistence.dao.InboundNcpdpMsgDao;
import gov.va.med.pharmacy.persistence.model.InboundNcpdpMsgEntity;
import gov.va.med.pharmacy.persistence.service.InboundNcpdpMsgService;

@Service("inboundNcpdpMsgService")
@Transactional
public class InboundNcpdpMsgServiceImpl implements InboundNcpdpMsgService {

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(InboundNcpdpMsgServiceImpl.class);
	
	
	@Autowired
    private InboundNcpdpMsgDao inboundNcpdpMsgDao;
	
	@Override
	public void saveInboundERx(InboundNcpdpMsgEntity inboundeRx) throws Exception {
			
		try {
			inboundNcpdpMsgDao.save(inboundeRx);
		} catch (Exception e) {			
			
			throw new Exception (e);
		}
		
		LOG.info("saved incoming WS message.");
	}

	@Override
	public InboundNcpdpMsgEntity findByMessageId(String msgId) throws Exception {

		try {

			LOG.info("returned NewRx by message id.");

			return inboundNcpdpMsgDao.findByMessageId(msgId);

		} catch (Exception e) {

			throw new Exception(e);
		}

	}
}
