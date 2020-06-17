package gov.va.med.pharmacy.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import gov.va.med.pharmacy.persistence.BaseDao;
import gov.va.med.pharmacy.persistence.dao.UserDao;
import gov.va.med.pharmacy.persistence.model.VaUser;


@Repository("userDao")
public class UserDaoImpl extends BaseDao<Integer, VaUser> implements UserDao{

	@Override
	public VaUser findById(long id) {
		VaUser user = getByKey(id);
      
		        
        return user;
	}

	@Override
	public VaUser findByVAUserID(String networkID) {
		
		Criteria crit = createEntityCriteria();
        
		crit.add(Restrictions.eq("vaUserid", networkID));
       
        VaUser users = (VaUser)crit.uniqueResult();
       
        return users;
	}

	@Override
	public void save(VaUser user) {
		 persist(user);
		
	}

	@Override
	public void deleteByVAUserID(String networkID) {
		
		Criteria crit = createEntityCriteria();
        
		crit.add(Restrictions.eq("vaUserid", networkID));
        
		VaUser user = (VaUser)crit.uniqueResult();
      
        delete(user);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VaUser> findAll() {
	
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
        
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// for unique results
        
		List<VaUser> users = (List<VaUser>) criteria.list();
        
        return users;
	}

	
	@Override
	public void updateVaUser(VaUser user) {
		
		update(user);
		
	}

	@Override
	public void deleteVaUser(VaUser user) {
		
		delete(user);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VaUser> findUsersByStationIds(String stationIds, List<String> stationIdsList) {

		Criteria criteria = createEntityCriteria();
		
		List<VaUser> users = new ArrayList<VaUser>();
		
		// if more than one station id, to avoid duplicate results.
		if(stationIdsList.size()> 1){
			
			criteria.add(buildStringInCriterion("vaStationIds", stationIdsList));
			
			users = (List<VaUser>) criteria.list();
		}
		
		
		Criteria criteriaEq = createEntityCriteria();
		
		criteriaEq.add(Restrictions.eq("vaStationIds", stationIds));
		
		List<VaUser> usersEq = (List<VaUser>) criteriaEq.list();
		
		users.addAll(usersEq);
        
        return users;
	}

}
