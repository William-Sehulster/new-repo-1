package gov.va.med.pharmacy.persistence.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import gov.va.med.pharmacy.persistence.model.PharmacyEntity;
import gov.va.med.pharmacy.persistence.report.VisnSelectModel;
import gov.va.med.pharmacy.persistence.service.TrackMessageService;
import gov.va.med.pharmacy.persistence.track.NcpdpMessageListModel;
import gov.va.med.pharmacy.persistence.track.NcpdpMessageModel;
import gov.va.med.pharmacy.persistence.track.NcpdpMessagesDao;
import gov.va.med.pharmacy.persistence.track.VisnSelectDao;


@Service("trackMessageService")
public class TrackMessageServiceImpl implements TrackMessageService {

	@Autowired
	private NcpdpMessagesDao ncpdpMessagesDao;
	
	@Autowired
	private VisnSelectDao visnSelectDao;
	
	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(TrackMessageServiceImpl.class);
	
	@Override
	public NcpdpMessageModel findByMessageId(String id, String inboundOutbound, String relatedMsgSearch) {
		
			LOG.info("------ getting inbound/outbound message ---- ");

		return ncpdpMessagesDao.findById(id, inboundOutbound, relatedMsgSearch);
	}
	
	@Override
	public List<NcpdpMessageListModel> searchMessages(String messageType, String messageId, String relatesToId, String visn, String vaStationId,
			String fromDate, String toDate, String patientSsn, String patientLastName, String patientFirstName, String patientDob, String prescriberNpi,
			String prescriberLastName, String prescriberFirstName, String prescriberDEA, String prescribedDrug, String messageStatus, String inboundNcpdpMsgId, String inboundOutbound, boolean mbmAllowed) {
		
			LOG.info("------ getting inbound/outbound message ---- ");

		return ncpdpMessagesDao.searchMessages(messageType, messageId, relatesToId, visn, vaStationId, fromDate, toDate, patientSsn, patientLastName, patientFirstName, patientDob, prescriberNpi, prescriberLastName, prescriberFirstName, prescriberDEA, prescribedDrug, messageStatus, inboundNcpdpMsgId, inboundOutbound,  mbmAllowed);
	}
	
	public List<VisnSelectModel> getVisns(){
		
		List<VisnSelectModel> visns = new ArrayList<VisnSelectModel>();
		
		List<VisnSelectModel> filteredVisnsList = new ArrayList<VisnSelectModel>();
		
		visns = visnSelectDao.getVisns();
		
		filteredVisnsList = filterVisnListForXSS(visns, filteredVisnsList);
		
		return filteredVisnsList;
		
	}

	
	/**
	 * @param visns
	 * @param filteredVisnsList
	 */
	private  List<VisnSelectModel> filterVisnListForXSS(List<VisnSelectModel> visns, List<VisnSelectModel> filteredVisnsList) {
		
		for (VisnSelectModel visn : visns) {
			
			VisnSelectModel filteredVisn = new VisnSelectModel();
			
			filteredVisn.setId(HtmlUtils.htmlEscape(visn.getId()));
			
			filteredVisn.setLabel(HtmlUtils.htmlEscape(visn.getLabel()));
			
			filteredVisnsList.add(filteredVisn);
			
		}
		
		return filteredVisnsList;
	}

	@Override
	public List<VisnSelectModel> getSelectedVisns(List<String> userStationIdList) {
				
		List<VisnSelectModel> visns = new ArrayList<VisnSelectModel>();
		
		visns = visnSelectDao.getSelectedVisns(userStationIdList);
		
		List<VisnSelectModel> filteredVisnsList = new ArrayList<VisnSelectModel>();
		
		filteredVisnsList = filterVisnListForXSS(visns, filteredVisnsList);
		
		return filteredVisnsList;
	}

	@Override
	public List<NcpdpMessageListModel> searchRelatedMessages(String messageId) {
		
		return ncpdpMessagesDao.searchRelatedMessages(messageId);
	}

	
	
}
