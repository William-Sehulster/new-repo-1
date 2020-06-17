package gov.va.med.pharmacy.persistence.service;

import gov.va.med.pharmacy.persistence.model.AppConfiguration;
import gov.va.med.pharmacy.persistence.model.PharmacyMigration;

public interface PharmacyMigrationService {
	
	public PharmacyMigration findByNCPDPId(String NCPDPId);
	
	public AppConfiguration findByKey(String key);
	
}
