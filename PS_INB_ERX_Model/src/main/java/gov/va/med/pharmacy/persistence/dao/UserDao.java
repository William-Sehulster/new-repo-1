package gov.va.med.pharmacy.persistence.dao;

import java.util.List;

import gov.va.med.pharmacy.persistence.model.VaUser;

public interface UserDao {

	public VaUser findById(long id);
    
	public VaUser findByVAUserID(String networkID);
     
	public void save(VaUser user);
     
	public void deleteByVAUserID(String networkID);
     
	public List<VaUser> findAll();
	
	public void updateVaUser(VaUser user);
	
	public void deleteVaUser(VaUser user);
	
	public List<VaUser> findUsersByStationIds(String stationIds, List<String> stationIdsList);
	
}
