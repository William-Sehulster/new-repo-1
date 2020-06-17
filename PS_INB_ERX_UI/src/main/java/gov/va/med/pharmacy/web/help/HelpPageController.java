package gov.va.med.pharmacy.web.help;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/help")
public class HelpPageController {

	@RequestMapping(value = "/main")	
	public ModelAndView getMainPage(HttpServletRequest request) {
		
		// TODO Help pages logic
		
		return new ModelAndView ("help");
	}

	

}
