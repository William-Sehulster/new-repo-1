package gov.va.med.pharmacy.persistence.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.va.med.pharmacy.persistence.dao.UserDao;
import gov.va.med.pharmacy.persistence.model.VaUser;
import gov.va.med.pharmacy.persistence.service.UserService;

@Service("userService")
@Transactional
public  class UserServiceImpl implements UserService{

	
	@Autowired
    private UserDao userDao;
	
	@Override
	public VaUser findById(long id) {
		
		return userDao.findById(id);
	}

	@Override
	public VaUser findByVAUserID(String networkID) {
		
		return userDao.findByVAUserID(networkID);
	}

	@Override
	public void addNewVAUser(VaUser user) throws Exception {
		
		try 
		{
			userDao.save(user);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new Exception(e);
		}
	}

	@Override
	public void updateVAUser(VaUser user) throws Exception {
		
		try 
		{
			userDao.save(user);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new Exception(e);
		}
	}

	@Override
	public List<VaUser> findAllUsers() {
		
		return userDao.findAll();
	}

	@Override
	public void updateUserInfo(VaUser user) throws Exception {
		
		try
		{
			userDao.updateVaUser(user);
			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new Exception(e);
		}
	}

	@Override
	public void updateUsers(List<VaUser> users) throws Exception {
		
		
		VaUser userFromDB = null;
		
		for(VaUser user: users){
			
			try 
			{
				
				userFromDB = userDao.findById(user.getUsersId());
				
				if(null!=userFromDB){
					
					
					if(null!=user.getIsPharmMgr()){
						
						userFromDB.setIsPharmMgr(user.getIsPharmMgr());
					}
					
					
					if(null!=user.getIsPbmAdmn()){
						
						userFromDB.setIsPbmAdmn(user.getIsPbmAdmn());
					}
					
					
					if(null!=user.getIsPharmUser()){
						
						userFromDB.setIsPharmUser(user.getIsPharmUser());
					}
					
					
					
					if(null!=user.getIsSystemAdmn()){
						
						userFromDB.setIsSystemAdmn(user.getIsSystemAdmn());
					}
					
					// names
				
					if(null!=user.getFirstName()){
						
						userFromDB.setFirstName(user.getFirstName());
					}
					
					if(null!=user.getLastName()){
						
						userFromDB.setLastName(user.getLastName());
					}
					
					// userID
					if(null!=user.getVaUserid()){
						
						userFromDB.setVaUserid(user.getVaUserid());
					}
					
					
					// userID
					if(null!=user.getVaStationIds()){
						
						userFromDB.setVaStationIds(user.getVaStationIds());
					}
					
					
					userFromDB .setUpdatedDate(user.getUpdatedDate());
					
					userFromDB .setUpdatedBy(user.getUpdatedBy());
					
					userDao.updateVaUser(userFromDB);
					
				}
				
				
			
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				throw new Exception(e);
			}
		}

		
	}

	@Override
	public void enableDisableteUsers(List<VaUser> users) throws Exception {
		
      VaUser userFromDB = null;
		
		for(VaUser user: users){
			
			try 
			{
				
				userFromDB = userDao.findById(user.getUsersId());
				
				if(null!=userFromDB){
					
					// Toggle the value.
					
					if(userFromDB.getIsEnabled() == false){
						
						userFromDB.setIsEnabled(Boolean.valueOf(true));
					}
					else
					{
						userFromDB.setIsEnabled(Boolean.valueOf(false));
					}
					userDao.updateVaUser(userFromDB);
					
				}
				
				
			
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				throw new Exception(e);
			}
		}
	}

	@Override
	public List<VaUser> getUsersByStationIds(String stationIds, List<String> stationIdsList) {
		
		List<VaUser> users = userDao.findUsersByStationIds(stationIds, stationIdsList); 
		
		sortUserListByFirstName(users);
		
		
		
		return users;
	}
	
	
	private void sortUserListByFirstName(List<VaUser> users) {
        Collections.sort(users, new Comparator<VaUser>() {
            @Override
            public int compare(VaUser o1, VaUser o2) {
                
            	// null safe
            	return ObjectUtils.compare(o1.getFirstName(), o2.getFirstName());
            	
            }
        });
    }

}
