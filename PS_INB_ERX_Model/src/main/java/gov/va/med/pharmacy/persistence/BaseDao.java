package gov.va.med.pharmacy.persistence;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao<PK extends Serializable, T> {

	 private final Class<T> persistentClass;
	 
	 private static int IN_CLAUSE_IN_CLAUSE_PARAMETER_LIMIT = 999; // oracle throws error for 1k values an in CLAUSE.
     
	    @SuppressWarnings("unchecked")
	    public BaseDao(){
	        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	    }
	     
	    @Autowired
	    private SessionFactory inboundErxSessionFactory;
	 
	    protected Session getSession(){
	        return inboundErxSessionFactory.getCurrentSession();
	    }
	 
	    @SuppressWarnings("unchecked")
	    public T getByKey(long id) {
	        return (T) getSession().get(persistentClass, id);
	    }
	 
	    /**
	     * Persist an entity
	     * 
	     * @param entity
	     */
	    public void persist(T entity) {
	        
	    	Session session = getSession(); 
	    	
	    	session.persist(entity);
	    	
	    	session.flush();
            session.clear();
	    	
	    	
	    	
	    }
	    
	    
	    /**
	     * Save an entity by first assigning a generated id and return that id after save.
	     * 
	     * @param entity
	     * @return generated id
	     */
	    public long saveWithId(T entity) {
	        
	    	Session session = getSession(); 
	    	
	    	long id = (Long) session.save(entity);
	    	
	    	session.flush();
            session.clear();
	    	
	    	return id;
	    	
	    }
	    
	    /**
	     * Updates an already persisted entity
	     * 
	     * @param entity
	     */
	    public void update(T entity) {
	        
	    	Session session = getSession(); 
	    	
	    	session.update(entity);
	    	
	    	session.flush();
            session.clear();
	    	
	    	
	    	
	    }
	 
	    /**
	     * Deletes an entity
	     * 
	     * @param entity
	     */
	    public void delete(T entity) {
	        getSession().delete(entity);
	    }
	     
	    /**
	     * @return Criteria
	     */
	    protected Criteria createEntityCriteria(){
	        return getSession().createCriteria(persistentClass);
	    }
	    
	    
	    /**
	     * To build criterion for IN CLAUSE query for String input.
	     * 
	     * @param propertyName
	     * @param values
	     * @return
	     */
	    public  Criterion buildStringInCriterion(String propertyName, List <String> values) {
	      
	    	Criterion criterion = null;

	        int listSize = values.size();
	        
	        for (int i = 0; i < listSize; i += IN_CLAUSE_IN_CLAUSE_PARAMETER_LIMIT) {
	        	
	            List<String> subList;
	            
	            if (listSize > i + IN_CLAUSE_IN_CLAUSE_PARAMETER_LIMIT) {
	            	
	                subList = values.subList(i, (i + IN_CLAUSE_IN_CLAUSE_PARAMETER_LIMIT));
	                
	            } else {
	            	
	                subList = values.subList(i, listSize);
	            }
	            if (criterion != null) {
	            	
	                criterion = Restrictions.or(criterion, Restrictions.in(propertyName, subList));
	                
	            } else {
	            	
	                criterion = Restrictions.in(propertyName, subList);
	            }
	        }
	        return criterion;
	    }
	   
	    
	    //TODO Update criteria to use criteria builder.
	    
	   /* protected CriteriaBuilder createEntityCriteriaBuilder(){
	        return getSession().getCriteriaBuilder();
	    }*/
}
