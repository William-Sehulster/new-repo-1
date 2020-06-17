package gov.va.med.pharmacy.web.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gov.va.med.pharmacy.web.Constants;

@Controller
@RequestMapping(value = "/")
public final class AccessController {

   
    public AccessController() {
        // TODO Auto-generated constructor stub
    }

   
    @RequestMapping(value = "/landing")
    public ModelAndView gotoWelcome(HttpServletRequest request) {
    	
    	 HttpSession session = request.getSession();
    	 
    	if (session.getAttribute(Constants.SESSION_USER) == null) {
    		
    		return new ModelAndView("landing");
    	}
    	else
    	{
    		 return new ModelAndView("inberx.homepage");
    	}
    	
       
    }
    
    @RequestMapping(value = "/AccessDenied")
    public ModelAndView accessDenied(HttpServletRequest request) {
    	
    	return new ModelAndView("accessDenied.page");
    	
       
    }

   
}
