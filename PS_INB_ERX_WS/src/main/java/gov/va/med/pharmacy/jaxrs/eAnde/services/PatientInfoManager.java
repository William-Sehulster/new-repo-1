package gov.va.med.pharmacy.jaxrs.eAnde.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import gov.va.med.pharmacy.jaxrs.eAnde.model.PatientInfoRequest;
import gov.va.med.pharmacy.jaxrs.eAnde.model.PatientInfoResponse;

@Consumes("application/json")
@Produces("application/json")
public interface PatientInfoManager {

	@POST
	@Path("/fetchEligibilityStatusByKey/")
	public PatientInfoResponse fetchEligibilityStatusByKey(PatientInfoRequest request);
}
