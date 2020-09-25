package gov.va.med.pharmacy.web.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gov.va.med.pharmacy.utility.ESAPIValidationType;
import gov.va.med.pharmacy.utility.ESAPIValidator;
import gov.va.med.pharmacy.web.Constants;
@Controller
public class LogoutController {

    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        
        String logoutMessage = "You have been logged out of the Inbound eRx application.";
        
        StringBuffer logoutURLBuffer=  new StringBuffer( ESAPIValidator.validateStringInput((String) session.getAttribute(Constants.SSOI_LANDING_URL), ESAPIValidationType.IAM_LOGOUT_URL));
        
        
        // check if it is valid VA url.
        String baseURL = ESAPIValidator.validateStringInput(request.getRequestURL().toString(), ESAPIValidationType.IAM_LOGOUT_URL);
        
        String appLoginURL = baseURL.substring(0,baseURL.indexOf("inb-erx/"));
        
        // To address potential fortify scan issue. 
        logoutURLBuffer.append("?appid=PREIE&target=").append(appLoginURL);
        
               
        String logoutURL = ESAPIValidator.validateStringInput(logoutURLBuffer.toString(), ESAPIValidationType.OPEN_REDIRECT);
        
        session.removeAttribute(Constants.SESSION_USER);
        
        session.invalidate(); // invalidate here after getting value from it.
        
        if(logoutURL!=null){
        	
        	return new ModelAndView("redirect:"+logoutURL);
        }
        else{
        	
        	 return new ModelAndView("logout", "logoutMessage", logoutMessage);
        }
        
       
    }
    
   
   
}
