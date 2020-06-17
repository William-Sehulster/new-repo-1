package gov.va.med.pharmacy.persistence.service;

import java.util.List;

import org.hibernate.HibernateException;

import gov.va.med.pharmacy.persistence.managepharmacy.ManagePharmacyFilter;
import gov.va.med.pharmacy.persistence.model.PharmacyEntity;



public interface PharmacyService {

	public List<PharmacyEntity> find(ManagePharmacyFilter managePharmacyFilter) throws Exception;
	
	public PharmacyEntity findByNCPDPId(String NCPDPId);
	
	public PharmacyEntity findById(Long pharmacyId) throws Exception;
	
	public void updatePharmacyInfo(PharmacyEntity pharmacy) throws HibernateException;
	
	public void savePharmacyInfo(PharmacyEntity pharmacy) throws HibernateException;
	
	public List<PharmacyEntity> getAllStations();
	
	public List<PharmacyEntity> queryForExport(ManagePharmacyFilter managePharmacyFilter, List<String> userStationIds);
	
	public List<PharmacyEntity> getStationIdsByVisn(String visn);
	
	public List<PharmacyEntity> getSelectedStationIdsByVisn(String visn, List<String> userStationIds);
	
	public List<PharmacyEntity> findSelectedPharmacies(ManagePharmacyFilter managePharmacyFilter, List<String> userStationIds);
	
}
