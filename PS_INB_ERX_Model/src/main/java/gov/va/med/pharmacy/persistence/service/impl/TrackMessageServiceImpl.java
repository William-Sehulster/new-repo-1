package gov.va.med.pharmacy.persistence.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import gov.va.med.pharmacy.persistence.report.VisnSelectModel;
import gov.va.med.pharmacy.persistence.service.TrackMessageService;
import gov.va.med.pharmacy.persistence.track.NcpdpMessageListModel;
import gov.va.med.pharmacy.persistence.track.NcpdpMessageModel;
import gov.va.med.pharmacy.persistence.track.NcpdpMessagesDao;
import gov.va.med.pharmacy.persistence.track.VisnSelectDao;

@Service("trackMessageService")
public class TrackMessageServiceImpl implements TrackMessageService {

	private static final String FALSE_VALUE = "false";

	private static final String TRUE_VALUE = "true";

	private static final String NO_VALUE = "NO";

	private static final String YES_VALUE = "YES";

	@Autowired
	private NcpdpMessagesDao ncpdpMessagesDao;

	@Autowired
	private VisnSelectDao visnSelectDao;

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager
			.getLogger(TrackMessageServiceImpl.class);

	@Override
	public NcpdpMessageModel findByMessageId(String id, String inboundOutbound, String relatedMsgSearch) {

		LOG.info("------ getting inbound/outbound message ---- ");

		// PRR Flag fix.

		NcpdpMessageModel ncpdpModel = ncpdpMessagesDao.findById(id, inboundOutbound, relatedMsgSearch);

		if ((null != ncpdpModel && null != ncpdpModel.getMessageType())		&& (ncpdpModel.getMessageType().toUpperCase(Locale.ENGLISH).equals("RXCHANGERESPONSE"))) {
			
			String prrFlag = ncpdpMessagesDao.findPrrFlagById(ncpdpModel.getRxMessageId());

			if (StringUtils.isNotEmpty(prrFlag)) {

				if (TRUE_VALUE.equalsIgnoreCase(prrFlag)) {

					ncpdpModel.setProhibitRenewalRequest(YES_VALUE);
					
				} else if (FALSE_VALUE.equalsIgnoreCase(prrFlag)) {
					
					ncpdpModel.setProhibitRenewalRequest(NO_VALUE);
					
				} else {
					
					ncpdpModel.setProhibitRenewalRequest(prrFlag);
				}

			}
		}

		return ncpdpModel;
	}

	@Override
	public List<NcpdpMessageListModel> searchMessages(String messageType, String messageId, String relatesToId,
			String visn, String vaStationId, String fromDate, String toDate, String patientSsn, String patientLastName,
			String patientFirstName, String patientDob, String prescriberNpi, String prescriberLastName,
			String prescriberFirstName, String prescriberDEA, String prescribedDrug, String messageStatus,
			String inboundNcpdpMsgId, String inboundOutbound, boolean mbmAllowed, String numberOfRecords,
			String patientSSN2017071) {

		LOG.info("------ getting inbound/outbound message ---- ");

		return ncpdpMessagesDao.searchMessages(messageType, messageId, relatesToId, visn, vaStationId, fromDate, toDate,
				patientSsn, patientLastName, patientFirstName, patientDob, prescriberNpi, prescriberLastName,
				prescriberFirstName, prescriberDEA, prescribedDrug, messageStatus, inboundNcpdpMsgId, inboundOutbound,
				mbmAllowed, numberOfRecords, patientSSN2017071);
	}

	public List<VisnSelectModel> getVisns() {

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
	private List<VisnSelectModel> filterVisnListForXSS(List<VisnSelectModel> visns,
			List<VisnSelectModel> filteredVisnsList) {

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
