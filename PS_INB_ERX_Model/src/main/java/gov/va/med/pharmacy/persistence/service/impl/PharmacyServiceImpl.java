package gov.va.med.pharmacy.persistence.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import gov.va.med.pharmacy.persistence.dao.PharmacyDao;
import gov.va.med.pharmacy.persistence.managepharmacy.ManagePharmacyFilter;
import gov.va.med.pharmacy.persistence.model.PharmacyEntity;
import gov.va.med.pharmacy.persistence.service.PharmacyService;

@Service("pharmacyService")
@Transactional
public class PharmacyServiceImpl implements PharmacyService {

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(PharmacyServiceImpl.class);

	@Autowired
	private PharmacyDao pharmacyDao;

	@Override
	public List<PharmacyEntity> find(ManagePharmacyFilter managePharmacyFilter) throws Exception {

		List<PharmacyEntity> pharmacies = new ArrayList<PharmacyEntity>();

		List<PharmacyEntity> filteredPharmaciesList = new ArrayList<PharmacyEntity>();

		try {

			pharmacies = pharmacyDao.find(managePharmacyFilter);
			
			for (PharmacyEntity pharmacy : pharmacies) {

				PharmacyEntity filteredPharmacyEntity = new PharmacyEntity();

				filteredPharmacyEntity = filterPharmacyEntityForXSS(filteredPharmacyEntity, pharmacy);

				filteredPharmaciesList.add(filteredPharmacyEntity);
			}
			
		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return filteredPharmaciesList;
	}

	@Override
	public PharmacyEntity findByNCPDPId(String NCPDPId) {

		PharmacyEntity pharmacyEntity = new PharmacyEntity();
		
		PharmacyEntity filteredPharmacyEntity = new PharmacyEntity();

		try {

			pharmacyEntity = pharmacyDao.findByNCPDPId(NCPDPId);
			
			filteredPharmacyEntity = filterPharmacyEntityForXSS(filteredPharmacyEntity, pharmacyEntity);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return filteredPharmacyEntity;
	}

	@Override
	public void savePharmacyInfo(PharmacyEntity pharmacy) throws HibernateException {

		try {
			pharmacyDao.save(pharmacy);

		} catch (HibernateException e) {

			throw new HibernateException(e);
		}

		LOG.info("saved pharmacy information.");
	}

	@Override
	public PharmacyEntity findById(Long pharmacyId) throws Exception {

		PharmacyEntity pharmacyEntity = new PharmacyEntity();
		
		PharmacyEntity filteredPharmacyEntity = new PharmacyEntity();

		try {
			
			pharmacyEntity = pharmacyDao.findById(pharmacyId);
 
			filteredPharmacyEntity = filterPharmacyEntityForXSS(filteredPharmacyEntity, pharmacyEntity);

		} catch (Exception e) {

			throw new Exception(e);
		}

		return filteredPharmacyEntity;

	}

	@Override
	public void updatePharmacyInfo(PharmacyEntity pharmacy) throws HibernateException {
		try {
			pharmacyDao.updatePharmacyInfo(pharmacy);

		} catch (HibernateException e) {

			throw new HibernateException(e);
		}

		LOG.info("updated pharmacy information.");
	}

	@Override
	public List<PharmacyEntity> getAllStations() {

		return pharmacyDao.getAllStations();
	}

	@Override
	public List<PharmacyEntity> queryForExport(ManagePharmacyFilter managePharmacyFilter, List<String> userStationIds) {

		return pharmacyDao.queryForExport(managePharmacyFilter, userStationIds);
	}

	@Override
	public List<PharmacyEntity> getStationIdsByVisn(String visn) {

		return pharmacyDao.getPharmacyStationIdsByVisn(visn);
	}

	@Override
	public List<PharmacyEntity> getSelectedStationIdsByVisn(String visn, List<String> userStationIds) {

		return pharmacyDao.getSelectedStationIdsByVisn(visn, userStationIds);
	}

	@Override
	public List<PharmacyEntity> findSelectedPharmacies(ManagePharmacyFilter managePharmacyFilter, List<String> userStationIds) {

		return pharmacyDao.findSelectedPharmacies(managePharmacyFilter, userStationIds);
	}
	
	/**
	 * @param filteredPharmacyEntity
	 * @param pharmacy
	 */
	private PharmacyEntity filterPharmacyEntityForXSS(PharmacyEntity filteredPharmacyEntity, PharmacyEntity pharmacy) {
		
		// To avoid NPE
		if(pharmacy.getPharmacyId()!=null){
		
			filteredPharmacyEntity.setPharmacyId(Long.valueOf(HtmlUtils.htmlEscape(pharmacy.getPharmacyId().toString())));		}
		
		
		filteredPharmacyEntity.setVaStationId(HtmlUtils.htmlEscape(pharmacy.getVaStationId()));
		filteredPharmacyEntity.setNcpdpId(HtmlUtils.htmlEscape(pharmacy.getNcpdpId()));
		filteredPharmacyEntity.setNpi(pharmacy.getNpi());
		
		filteredPharmacyEntity.setStoreName(HtmlUtils.htmlEscape(pharmacy.getStoreName()));

		if(StringUtils.isNoneEmpty(pharmacy.getPharmacistLastName())) {
		
			filteredPharmacyEntity.setPharmacistLastName(HtmlUtils.htmlEscape(pharmacy.getPharmacistLastName()));
		}
		
		if(StringUtils.isNotEmpty((pharmacy.getPharmacistFirstName()))){
			
			filteredPharmacyEntity.setPharmacistFirstName(HtmlUtils.htmlEscape(pharmacy.getPharmacistFirstName()));
		}
		
		if(StringUtils.isNotEmpty(pharmacy.getPharmacistMiddleName())){
			
			filteredPharmacyEntity.setPharmacistMiddleName(HtmlUtils.htmlEscape(pharmacy.getPharmacistMiddleName()));
		}		
		
		if(StringUtils.isNotEmpty(pharmacy.getPharmacistSuffix())){
			
			filteredPharmacyEntity.setPharmacistSuffix(HtmlUtils.htmlEscape(pharmacy.getPharmacistSuffix()));
		}
		
		if(StringUtils.isNotEmpty(pharmacy.getPharmacistPrefix())){
			
			filteredPharmacyEntity.setPharmacistPrefix(HtmlUtils.htmlEscape(pharmacy.getPharmacistPrefix()));
		}
		
		if(StringUtils.isNotEmpty(pharmacy.getPharmacyAddressLine1())){
			
			filteredPharmacyEntity.setPharmacyAddressLine1(HtmlUtils.htmlEscape(pharmacy.getPharmacyAddressLine1()));
		}
			
		
		if(StringUtils.isNotEmpty(pharmacy.getPharmacyAddressLine2())){
			
			filteredPharmacyEntity.setPharmacyAddressLine2(HtmlUtils.htmlEscape(pharmacy.getPharmacyAddressLine2()));
		}
		
		if(StringUtils.isNotEmpty(pharmacy.getPharmacyCity())){
			
			filteredPharmacyEntity.setPharmacyCity(HtmlUtils.htmlEscape(pharmacy.getPharmacyCity()));
		}

		
		
		
		if(StringUtils.isNotEmpty(pharmacy.getPharmacyState())){
			
			filteredPharmacyEntity.setPharmacyState(HtmlUtils.htmlEscape(pharmacy.getPharmacyState()));
		}

		if(StringUtils.isNotEmpty(pharmacy.getPharmacyZipcode())){
			
			filteredPharmacyEntity.setPharmacyZipcode(HtmlUtils.htmlEscape(pharmacy.getPharmacyZipcode()));
		}
		
		

		if(StringUtils.isNotEmpty(pharmacy.getCrossStreet())){
			
			filteredPharmacyEntity.setCrossStreet(HtmlUtils.htmlEscape(pharmacy.getCrossStreet()));
		}


		if(StringUtils.isNotEmpty(pharmacy.getPharmacyPhoneNumber())){
			
			filteredPharmacyEntity.setPharmacyPhoneNumber(HtmlUtils.htmlEscape(pharmacy.getPharmacyPhoneNumber()));
		}

		
		
		if(StringUtils.isNotEmpty(pharmacy.getPharmacyFaxNumber())){
			
			filteredPharmacyEntity.setPharmacyFaxNumber(HtmlUtils.htmlEscape(pharmacy.getPharmacyFaxNumber()));
		}

		
		filteredPharmacyEntity.setInboundErxEnabled(pharmacy.getInboundErxEnabled());
		filteredPharmacyEntity.setUpdatedDate(pharmacy.getUpdatedDate());
		filteredPharmacyEntity.setCreatedDate(pharmacy.getCreatedDate());
		filteredPharmacyEntity.setVisn(pharmacy.getVisn());
		filteredPharmacyEntity.setDivisionName(HtmlUtils.htmlEscape(pharmacy.getDivisionName()));
		
		
		if(StringUtils.isNotEmpty(pharmacy.getCreatedBy())){
			
			filteredPharmacyEntity.setCreatedBy(HtmlUtils.htmlEscape(pharmacy.getCreatedBy()));
		}

		
		
		if(StringUtils.isNotEmpty(pharmacy.getUpdatedBy())){
			
			filteredPharmacyEntity.setUpdatedBy(HtmlUtils.htmlEscape(pharmacy.getUpdatedBy()));
		}

		
		filteredPharmacyEntity.setEandeCheck(pharmacy.getEandeCheck());
		
		return filteredPharmacyEntity;
	}

	
}
