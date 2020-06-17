package gov.va.med.pharmacy.persistence.dao;

import gov.va.med.pharmacy.persistence.model.PharmacyMigration;

public interface PharmacyMigrationDao {
	
	public PharmacyMigration findByNCPDPId(String NCPDPId);

}
