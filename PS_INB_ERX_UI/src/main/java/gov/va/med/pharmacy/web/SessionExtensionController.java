package gov.va.med.pharmacy.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/appManagement")
public class SessionExtensionController {

	@RequestMapping(value = "/extendSession",method = RequestMethod.GET, produces = "application/json")	
	public ModelAndView index(HttpServletRequest request) {
		
		 ModelAndView mav = new ModelAndView(new org.springframework.web.servlet.view.json.MappingJackson2JsonView());
		
		String responseMsg ="failed";
		
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			
			HttpSession session = requestAttributes.getRequest().getSession();
			
			session.setMaxInactiveInterval(1800); // Extend to 30 more minutes.
			
			responseMsg ="success";
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			responseMsg ="failed";
		}
		
		
		mav.addObject("message", responseMsg);
		
		return mav;
	}
}
