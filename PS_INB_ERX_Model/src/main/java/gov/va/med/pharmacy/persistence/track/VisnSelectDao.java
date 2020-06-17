package gov.va.med.pharmacy.persistence.track;

import java.util.List;

import gov.va.med.pharmacy.persistence.report.VisnSelectModel;

public interface VisnSelectDao {

	public List<VisnSelectModel> getVisns();

	public List<VisnSelectModel> getSelectedVisns(List<String> userStationIdList);
}
