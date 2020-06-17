package gov.va.med.pharmacy.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.va.med.pharmacy.persistence.dao.AppConfigurationDao;
import gov.va.med.pharmacy.persistence.dao.PharmacyMigrationDao;
import gov.va.med.pharmacy.persistence.model.AppConfiguration;
import gov.va.med.pharmacy.persistence.model.PharmacyMigration;
import gov.va.med.pharmacy.persistence.service.PharmacyMigrationService;

@Service("pharmacyMigrationService")
@Transactional
public class PharmacyMigrationServiceImpl implements PharmacyMigrationService {

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(PharmacyMigrationServiceImpl.class);
	
	
	@Autowired
    private PharmacyMigrationDao pharmacyMigrationDao;
	
	@Autowired
    private AppConfigurationDao appConfigurationDao;


	@Override
	public PharmacyMigration findByNCPDPId(String NCPDPId) {
		
		PharmacyMigration pharmacyMigration = new PharmacyMigration();

		try {

			pharmacyMigration = pharmacyMigrationDao.findByNCPDPId(NCPDPId);			

		} catch (Exception e) {
			
			
			e.printStackTrace();
		}

		LOG.info("queried pharmacy by NCPDPId for migration.");
		
		return pharmacyMigration;
	}


	@Override
	public AppConfiguration findByKey(String key) {
		
		AppConfiguration appConfiguration = new AppConfiguration();

		try {

			appConfiguration = appConfigurationDao.findByKey(key);

		} catch (Exception e) {
			
			
			e.printStackTrace();
		}

		LOG.info("queried app config by key for migration ws url.");
		
		return appConfiguration;
	}
	
	

}
