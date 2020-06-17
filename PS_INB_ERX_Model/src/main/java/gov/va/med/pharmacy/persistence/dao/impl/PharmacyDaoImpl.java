package gov.va.med.pharmacy.persistence.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import gov.va.med.pharmacy.persistence.BaseDao;
import gov.va.med.pharmacy.persistence.dao.PharmacyDao;
import gov.va.med.pharmacy.persistence.managepharmacy.ManagePharmacyFilter;
import gov.va.med.pharmacy.persistence.model.PharmacyEntity;



@Repository("pharmacy")
public class PharmacyDaoImpl extends BaseDao<Integer, PharmacyEntity> implements PharmacyDao{
   
	@SuppressWarnings("unchecked")
	@Override
	public List<PharmacyEntity> find(ManagePharmacyFilter pharmacyFilterModel){
		
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("divisionName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// for unique results 
        if (pharmacyFilterModel != null){
        	if (pharmacyFilterModel.getPharmacyFilterFormVisnSelect() != null && pharmacyFilterModel.getPharmacyFilterFormVisnSelect().length()>0 ){
        		if (pharmacyFilterModel.getPharmacyFilterFormVisnSelect().compareTo("All") != 0){ //check for All value
        		    criteria.add(Restrictions.eq("visn", Long.valueOf(pharmacyFilterModel.getPharmacyFilterFormVisnSelect())));
        		}
    		}
        	
        	if (pharmacyFilterModel.getPharmacyFilterFormStationIdSelect() != null && pharmacyFilterModel.getPharmacyFilterFormStationIdSelect().length()>0 ){    			
    			if (pharmacyFilterModel.getPharmacyFilterFormStationIdSelect().compareTo("All") != 0){ //check for All value
    				criteria.add(Restrictions.eq("vaStationId", pharmacyFilterModel.getPharmacyFilterFormStationIdSelect()));
    			}
    		}
        	
        	if (StringUtils.isNotBlank(pharmacyFilterModel.getNcpdpId())){    			
    			if (pharmacyFilterModel.getNcpdpId().compareTo("All") != 0){ //check for All value
    				criteria.add(Restrictions.eq("ncpdpId", pharmacyFilterModel.getNcpdpId()));
    			}
    		}
        	
        	if (pharmacyFilterModel.getPharmacyName() != null && pharmacyFilterModel.getPharmacyName().length()>0 ){    			
    			if (pharmacyFilterModel.getPharmacyName().compareTo("All") != 0){ //check for All value
    				criteria.add(Restrictions.like("storeName", pharmacyFilterModel.getPharmacyName()+"%").ignoreCase());
    			}
    		}
        }
        
        criteria.setProjection(Projections.projectionList()
        		.add(Projections.property("visn"),"visn")
        		.add(Projections.property("vaStationId"),"vaStationId")
        		.add(Projections.property("ncpdpId"),"ncpdpId")
        		.add(Projections.property("divisionName"),"divisionName")
        		.add(Projections.property("pharmacyAddressLine1"),"pharmacyAddressLine1")
        		.add(Projections.property("pharmacyAddressLine1"),"pharmacyAddressLine1")
        		.add(Projections.property("pharmacyCity"),"pharmacyCity")
        		.add(Projections.property("pharmacyState"),"pharmacyState")
        		.add(Projections.property("storeName"),"storeName")        		
        		.add(Projections.property("pharmacyPhoneNumber"),"pharmacyPhoneNumber")
        		.add(Projections.property("inboundErxEnabled"),"inboundErxEnabled")
        		);
        
        // omit pharmacy with zero id.        
        criteria.add(Restrictions.ne("pharmacyId", new Long(0)));
        
        criteria.setResultTransformer(new AliasToBeanResultTransformer(PharmacyEntity.class));
        
        List<PharmacyEntity> pharmacies =  criteria.list();
        
        return pharmacies;
		
	}

	@Override
	public PharmacyEntity findByNCPDPId(String NCPDPId) {
		
		Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); // for unique results 
       
        if (NCPDPId != null){
        	
    		criteria.add(Restrictions.eq("ncpdpId", NCPDPId));    		
        }       
        
            
        PharmacyEntity pharmacy =  (PharmacyEntity) criteria.uniqueResult();
		
		return pharmacy;
	}
	
	@Override
	public PharmacyEntity findById(Long pharmacyId) {
		
		PharmacyEntity pharmacy= getByKey(pharmacyId);
		
		return pharmacy;		
		
	}
	
	@Override
	public void save(PharmacyEntity pharmacy) {
		persist(pharmacy);	
	}
	
	@Override
	public void updatePharmacyInfo(PharmacyEntity pharmacy) {
		
		update(pharmacy);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PharmacyEntity> getAllStations() {
		
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("vaStationId"));
		
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); // for unique results
        
        criteria.setProjection(Projections.projectionList()
        		.add(Projections.property("vaStationId"),"vaStationId")   
        		.add(Projections.property("divisionName"),"divisionName")
        		);
        
        // omit pharmacy with zero id.        
        criteria.add(Restrictions.ne("pharmacyId", new Long(0)));
        
        criteria.setResultTransformer(Transformers.aliasToBean(PharmacyEntity.class)); 
   
        List<PharmacyEntity> pharmacies =  criteria.list();
        
        return pharmacies;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PharmacyEntity> queryForExport(ManagePharmacyFilter pharmacyFilterModel, List<String> userStationIds) {
		
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("divisionName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// for unique results 
        if (pharmacyFilterModel != null){
        	if (pharmacyFilterModel.getPharmacyFilterFormVisnSelect() != null && pharmacyFilterModel.getPharmacyFilterFormVisnSelect().length()>0 ){
        		if (pharmacyFilterModel.getPharmacyFilterFormVisnSelect().compareTo("All") != 0){ //check for All value
        		    criteria.add(Restrictions.eq("visn", Long.valueOf(pharmacyFilterModel.getPharmacyFilterFormVisnSelect())));
        		}
    		}
        	
        	if (pharmacyFilterModel.getPharmacyFilterFormStationIdSelect() != null && pharmacyFilterModel.getPharmacyFilterFormStationIdSelect().length()>0 ){    			
    			if (pharmacyFilterModel.getPharmacyFilterFormStationIdSelect().compareTo("All") != 0){ //check for All value
    				criteria.add(Restrictions.eq("vaStationId", pharmacyFilterModel.getPharmacyFilterFormStationIdSelect()));
    			}
    		}
        	
        	if (StringUtils.isNotBlank(pharmacyFilterModel.getNcpdpId())){    			
    			if (pharmacyFilterModel.getNcpdpId().compareTo("All") != 0){ //check for All value
    				criteria.add(Restrictions.eq("ncpdpId", pharmacyFilterModel.getNcpdpId()));
    			}
    		}
        	
        	if (pharmacyFilterModel.getPharmacyName() != null && pharmacyFilterModel.getPharmacyName().length()>0 ){    			
    			if (pharmacyFilterModel.getPharmacyName().compareTo("All") != 0){ //check for All value
    				criteria.add(Restrictions.like("storeName", pharmacyFilterModel.getPharmacyName()+"%").ignoreCase());
    			}
    		}
        }
        

        if(null!=userStationIds && !userStationIds.isEmpty()){
        	criteria.add(buildStringInCriterion("vaStationId", userStationIds));	
        }
        

        
        
        
        criteria.setProjection(Projections.projectionList()
        		.add(Projections.property("visn"),"visn")
        		.add(Projections.property("vaStationId"),"vaStationId")
        		.add(Projections.property("ncpdpId"),"ncpdpId")
        		.add(Projections.property("divisionName"),"divisionName")
        		.add(Projections.property("pharmacyAddressLine1"),"pharmacyAddressLine1")
        		.add(Projections.property("pharmacyAddressLine1"),"pharmacyAddressLine1")
        		.add(Projections.property("pharmacyCity"),"pharmacyCity")
        		.add(Projections.property("pharmacyState"),"pharmacyState")
        		.add(Projections.property("storeName"),"storeName")        		
        		.add(Projections.property("pharmacyPhoneNumber"),"pharmacyPhoneNumber")
        		.add(Projections.property("inboundErxEnabled"),"inboundErxEnabled")
        		);
        
        // omit pharmacy with zero id.        
        criteria.add(Restrictions.ne("pharmacyId", new Long(0)));
        
        criteria.setResultTransformer(new AliasToBeanResultTransformer(PharmacyEntity.class));
		
		List<PharmacyEntity> pharmacies = (List<PharmacyEntity>)criteria.list();
        
        return pharmacies;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PharmacyEntity> getPharmacyStationIdsByVisn(String visn) {
		
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("vaStationId"));
		
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// for unique results
        
        List<PharmacyEntity> stationdIds= new ArrayList<PharmacyEntity>(); 
        
    	if(!"All".equalsIgnoreCase(visn)){
    		
    		criteria.add(Restrictions.eq("visn", Long.valueOf(visn)));
    		
             try 
             {
				stationdIds = (List<PharmacyEntity>) criteria.list();
				
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
        
        return stationdIds;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<PharmacyEntity> getSelectedStationIdsByVisn(String visn, List<String> userStationIds) {
		
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("vaStationId"));
		
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// for unique results
        
        if (null!=visn && visn.length() > 0){
        	
		visn = visn.substring(0, visn.length()-1);		
	    
        } 
        
        
        List<PharmacyEntity> stationdIds= new ArrayList<PharmacyEntity>(); 
        
    	if(!"All".equalsIgnoreCase(visn)){
    		
    		  criteria.add(Restrictions.eq("visn", Long.valueOf(visn))); 
    		  
    		  criteria.add(buildStringInCriterion("vaStationId", userStationIds));
    		
             try 
             {
				stationdIds = (List<PharmacyEntity>) criteria.list();
				
			} catch (HibernateException e) {
			
				e.printStackTrace();
			}
    		
    	}
        
        return stationdIds;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PharmacyEntity> findSelectedPharmacies(ManagePharmacyFilter pharmacyFilterModel, List<String> userStationIds) {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("divisionName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// for unique results 
       
        if (pharmacyFilterModel != null){
        	if (pharmacyFilterModel.getPharmacyFilterFormVisnSelect() != null && pharmacyFilterModel.getPharmacyFilterFormVisnSelect().length()>0 ){
        		if (pharmacyFilterModel.getPharmacyFilterFormVisnSelect().compareTo("All") != 0){ //check for All value
        		    criteria.add(Restrictions.eq("visn", Long.valueOf(pharmacyFilterModel.getPharmacyFilterFormVisnSelect())));
        		}
    		}
        	
        	if (pharmacyFilterModel.getPharmacyFilterFormStationIdSelect() != null && pharmacyFilterModel.getPharmacyFilterFormStationIdSelect().length()>0 ){    			
    			if (pharmacyFilterModel.getPharmacyFilterFormStationIdSelect().compareTo("All") != 0){ //check for All value
    				criteria.add(Restrictions.eq("vaStationId", pharmacyFilterModel.getPharmacyFilterFormStationIdSelect()));
    			}
    		}
        	
        	if (StringUtils.isNotBlank(pharmacyFilterModel.getNcpdpId()) ){    			
    			if (pharmacyFilterModel.getNcpdpId().compareTo("All") != 0){ //check for All value
    				criteria.add(Restrictions.eq("ncpdpId", pharmacyFilterModel.getNcpdpId()));
    			}
    		}
        	
        	if (pharmacyFilterModel.getPharmacyName() != null && pharmacyFilterModel.getPharmacyName().length()>0 ){    			
    			if (pharmacyFilterModel.getPharmacyName().compareTo("All") != 0){ //check for All value
    				criteria.add(Restrictions.like("storeName", pharmacyFilterModel.getPharmacyName()+"%").ignoreCase());
    			}
    		}
        }
        
        criteria.add(buildStringInCriterion("vaStationId", userStationIds));
        
        criteria.setProjection(Projections.projectionList()
        		.add(Projections.property("visn"),"visn")
        		.add(Projections.property("vaStationId"),"vaStationId")
        		.add(Projections.property("ncpdpId"),"ncpdpId")
        		.add(Projections.property("divisionName"),"divisionName")
        		.add(Projections.property("pharmacyAddressLine1"),"pharmacyAddressLine1")
        		.add(Projections.property("pharmacyAddressLine1"),"pharmacyAddressLine1")
        		.add(Projections.property("pharmacyCity"),"pharmacyCity")
        		.add(Projections.property("pharmacyState"),"pharmacyState")
        		.add(Projections.property("storeName"),"storeName")        		
        		.add(Projections.property("pharmacyPhoneNumber"),"pharmacyPhoneNumber")
        		.add(Projections.property("inboundErxEnabled"),"inboundErxEnabled")
        		);
        
        // omit pharmacy with zero id.        
        criteria.add(Restrictions.ne("pharmacyId", new Long(0)));
        
        criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        
        List<PharmacyEntity> pharmacies =  criteria.list();
        
        return pharmacies;
	}

}
