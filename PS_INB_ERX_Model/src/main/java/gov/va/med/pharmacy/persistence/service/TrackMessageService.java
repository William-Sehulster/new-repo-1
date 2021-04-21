package gov.va.med.pharmacy.persistence.service;

import java.util.List;

import gov.va.med.pharmacy.persistence.report.VisnSelectModel;
import gov.va.med.pharmacy.persistence.track.NcpdpMessageListModel;
import gov.va.med.pharmacy.persistence.track.NcpdpMessageModel;

public interface TrackMessageService {

	public NcpdpMessageModel findByMessageId(String id, String inboundOutbound, String relatedMsgSearch);

	public List<NcpdpMessageListModel> searchMessages(String messageType, String messageId, String relatesToId,
			String visn, String vaStationId, String fromDate, String toDate, String patientSsn, String patientLastName,
			String patientFirstName, String patientDob, String prescriberNpi, String prescriberLastName,
			String prescriberFirstName, String prescriberDEA, String prescribedDrug, String messageStatus,
			String inboundNcpdpMsgId, String inboundOutbound, boolean mbmAllowed, String numberOfRecords,
			String patientSSN2017071);

	public List<VisnSelectModel> getVisns();

	public List<VisnSelectModel> getSelectedVisns(List<String> userStationIdList);

	public List<NcpdpMessageListModel> searchRelatedMessages(String messageId);

}
