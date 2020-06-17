package gov.va.med.pharmacy.web.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.owasp.esapi.errors.IntrusionException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import gov.va.med.pharmacy.utility.ESAPIValidationType;
import gov.va.med.pharmacy.utility.ESAPIValidator;
import gov.va.med.pharmacy.web.Constants;
import gov.va.med.pharmacy.web.service.InboundUserDetailsService;

@Controller
@PropertySource("classpath:BuildVersion.properties")
public class LoginController implements InitializingBean  {

	
	@Autowired
	private InboundUserDetailsService inboundUserDetailsService;
	
	@Autowired
	private Environment environment;
	
	@RequestMapping(value = "/homepage")
	public String getHomePage(HttpServletRequest request) {
		
		String tilesView ="inberx.homepage";
				
		return tilesView;
	}
	
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request) {
		
		String tilesView ="inberx.homepage";
		
		boolean isValid = authenticateUser(request);
		
		if(isValid == true){
			tilesView = "inberx.homepage";
		}
		else{
			tilesView = "inberx.landingPageWithErrors";	
		}
		
		return tilesView;
	}

	private boolean authenticateUser(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		String buildInfo = null;
		String buildInfoFromSession = null;
		
		buildInfoFromSession=  ESAPIValidator.validateStringInput((String) session.getAttribute(Constants.BUILI_NFO), ESAPIValidationType.ACCESS_CONTROL_DB);
		
		if(StringUtils.isEmpty(buildInfoFromSession)){
			
			if(environment!=null){
				
				 buildInfo = environment.getProperty("buildinformation");
				
				 session.removeAttribute(Constants.BUILI_NFO);
				 
				 session.setAttribute(Constants.BUILI_NFO, buildInfo);
			}
		}
		
		

		 boolean isValid = false;   
		 
		 // get network login name.
		 if(request.getHeader("ADSAMACCOUNTNAME")!=null) 
		 {
			 
			 String  userId = request.getHeader("ADSAMACCOUNTNAME");
			 
			 
			 if(StringUtils.isNotBlank(userId)){
				 
			
			 // logout should take to the IAM Landing.
			 if(request.getHeader(Constants.SSOI_LANDING_URL)!=null)
			 {
				 String logoutURL = request.getHeader(Constants.SSOI_LANDING_URL);
				 
				 if(ESAPIValidator.isValidInput(logoutURL,ESAPIValidationType.IAM_LOGOUT_URL) )
				 {
					 session.removeAttribute(Constants.SSOI_LANDING_URL);
					 
					 session.setAttribute(Constants.SSOI_LANDING_URL, logoutURL);
				  }			 
				 
			 }
			 
			 
			    if(ESAPIValidator.isValidInput(userId,ESAPIValidationType.ACCOUNT_NAME))
			    {
			    	userId = userId.toUpperCase();
			     }
			     else
			     {
			    	 		    	 
			    	 session.removeAttribute("loginErrorMessage");
					 
					 session.setAttribute("loginErrorMessage", "Unable to login. Invalid Credentials. Please contact production support.");
					 
					 return isValid;

			     }
			 
			 
			  UserDetails user = inboundUserDetailsService.loadUserByUsername(userId);
				
				 if(user != null){
					
					 if(user.isEnabled() == true){
						 
						 session.removeAttribute(Constants.SESSION_USER);
					     try {
							session.setAttribute(Constants.SESSION_USER, user);
						} catch (IntrusionException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					     session.removeAttribute("loginErrorMessage");
					     
					     isValid = true;
					     
					     // We need to set the security context of authenticated users, otherwise spring security thinks user is not authenticated and redirects to login page.
					     
					     UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
					     
					     SecurityContextHolder.getContext().setAuthentication(authRequest);
						 
					 }
					 
					 else{
						 
						 session.removeAttribute(Constants.SESSION_USER);
						 
						 session.removeAttribute("loginErrorMessage");
						 
						 session.setAttribute("loginErrorMessage", "Your access has been disabled, Please contact your Pharmacy Manager or Administrator.");

					     isValid = false;
						 
					 }
					
					 
				 }
				 
				 else{
					 
					 session.removeAttribute(Constants.SESSION_USER);
					 
					 session.removeAttribute("loginErrorMessage");
					 
					 session.setAttribute("loginErrorMessage", "Unable to login. Invalid Credentials. Please contact production support.");

				     isValid = false;
					 
				 }
				 
			 }
			 
			 else{
				 
				 session.removeAttribute(Constants.SESSION_USER);
				 
				 session.removeAttribute("loginErrorMessage");
				 
				 session.setAttribute("loginErrorMessage", "Unable to login. Invalid Credentials. Please contact production support.");

			     isValid = false;
				 
			 }
		 }
		 else{
			 session.setAttribute("loginErrorMessage", "Unable to login. Invalid Credentials. Please contact production support.");

		     isValid = false;
			 
		 }
	     
				 
           return isValid;			  
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	

}
