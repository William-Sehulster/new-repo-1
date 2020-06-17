package gov.va.med.pharmacy.persistence.dao;

import java.util.List;

import gov.va.med.pharmacy.persistence.managepharmacy.ManagePharmacyFilter;
import gov.va.med.pharmacy.persistence.model.PharmacyEntity;



public interface PharmacyDao {


	public List<PharmacyEntity> find(ManagePharmacyFilter pharmacyFilterModel);
	
	public PharmacyEntity findByNCPDPId(String NCPDPId);
	
	public PharmacyEntity findById(Long pharmacyId);
	
	public void save(PharmacyEntity pharmacy);
	
	public void updatePharmacyInfo(PharmacyEntity pharmacy);
	
	public List<PharmacyEntity> getAllStations();
	
	public List<PharmacyEntity> queryForExport(ManagePharmacyFilter pharmacyFilterModel, List<String> userStationIds);
	
	public List<PharmacyEntity> getPharmacyStationIdsByVisn(String visn);
	
	public List<PharmacyEntity> getSelectedStationIdsByVisn(String visn, List<String> userStationIds);
		
	public List<PharmacyEntity> findSelectedPharmacies(ManagePharmacyFilter pharmacyFilterModel, List<String> userStationIds);
}
