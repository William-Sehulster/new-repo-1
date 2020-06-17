package gov.va.med.pharmacy.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.va.med.pharmacy.persistence.dao.OutboundNcpdpMsgDao;
import gov.va.med.pharmacy.persistence.model.OutboundNcpdpMsgEntity;
import gov.va.med.pharmacy.persistence.service.OutboundNcpdpMsgService;

@Service("outboundNcpdpMsgService")
@Transactional
public class OutboundNcpdpMsgServiceImpl implements OutboundNcpdpMsgService {

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager
			.getLogger(OutboundNcpdpMsgServiceImpl.class);

	@Autowired
	private OutboundNcpdpMsgDao outboundNcpdpMsgDao;

	@Override
	public long saveOutboundMsg(OutboundNcpdpMsgEntity outboundMsg) throws Exception {
		
		long outboundMsgId = 0;
		
		try 
		{
			outboundMsgId =  outboundNcpdpMsgDao.saveMsg(outboundMsg);
			
			LOG.info("Saved Vista Outbound message.");
			
		} 
		catch (Exception e) {

			throw new Exception(e);
		}
		
		return outboundMsgId;	

	}

	@Override
	public OutboundNcpdpMsgEntity findById(long id) {

		LOG.info("Getting outbound message by id.");

		return outboundNcpdpMsgDao.findById(id);
	}

}
