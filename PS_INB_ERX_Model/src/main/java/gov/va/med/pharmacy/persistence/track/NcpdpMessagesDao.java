package gov.va.med.pharmacy.persistence.track;

import java.util.List;


public interface NcpdpMessagesDao {

	public  NcpdpMessageModel  findById(String id, String inboundOutbound, String relatedMsgSearch);

	public  List<NcpdpMessageListModel> searchMessages(String messageType, String messageId, String relatesToId, String visn,
			String vaStationId, String fromDate, String toDate, String patientSsn, String patientLastName,
			String patientFirstName, String patientDob, String prescriberNpi, String prescriberLastName, String prescriberFirstName, String prescriberDEA, String prescribedDrug,
			String messageStatus, String inboundNcpdpMsgId, String inboundOutbound, boolean mbmAllowed, String numberOfRecords, String patientSSN2017071);
	
	public  List<NcpdpMessageListModel> searchRelatedMessages(String messageId);
	
	public String findPrrFlagById(String messageID);
}
