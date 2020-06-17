package gov.va.med.pharmacy.persistence.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import gov.va.med.pharmacy.persistence.BaseDao;
import gov.va.med.pharmacy.persistence.dao.PharmacyMigrationDao;
import gov.va.med.pharmacy.persistence.model.PharmacyMigration;

@Repository("pharmacyMigrationDao")
public class PharmacyMigrationDaoImpl extends BaseDao<Integer, PharmacyMigration> implements PharmacyMigrationDao {

	@Override
	public PharmacyMigration findByNCPDPId(String NCPDPId) {
		
		Criteria criteria = createEntityCriteria();
      
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); // for unique results 
       
        if (NCPDPId != null){
        	
    		criteria.add(Restrictions.eq("pharmacyNcpdpid", NCPDPId));    		
        }       
        
            
        PharmacyMigration pharmacy =  (PharmacyMigration) criteria.uniqueResult();
		
		return pharmacy;
	}

	

}
