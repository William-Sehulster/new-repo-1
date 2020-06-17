package gov.va.med.pharmacy.persistence.service;

import java.util.List;

import gov.va.med.pharmacy.persistence.model.VaUser;

public interface UserService {

	public VaUser findById(long id);
	
	public VaUser findByVAUserID(String networkID);
	
	public void addNewVAUser(VaUser user) throws Exception;
	
	public void updateVAUser(VaUser user) throws Exception;
	
	public List<VaUser> findAllUsers();
	
	public void updateUserInfo(VaUser user) throws Exception;
	
	public void updateUsers(List<VaUser> users) throws Exception;
	
	public void enableDisableteUsers(List<VaUser> users) throws Exception;
	
	public List<VaUser> getUsersByStationIds(String stationIds, List<String> stationIdsList);
}
