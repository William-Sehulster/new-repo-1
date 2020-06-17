package gov.va.med.pharmacy.persistence.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import gov.va.med.pharmacy.persistence.BaseDao;
import gov.va.med.pharmacy.persistence.dao.AppConfigurationDao;
import gov.va.med.pharmacy.persistence.model.AppConfiguration;

@Repository("appConfigurationDao")
public class AppConfigurationDaoImpl extends BaseDao<Integer, AppConfiguration> implements AppConfigurationDao {

	@Override
	public AppConfiguration findByKey(String key) {
		
		Criteria criteria = createEntityCriteria();
	      
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); // for unique results 
       
        if (key != null){
        	
    		criteria.add(Restrictions.eq("key", key));    		
        }       
            
        AppConfiguration appConfiguration =  (AppConfiguration) criteria.uniqueResult();
		
		return appConfiguration;
	}

	
	

}
