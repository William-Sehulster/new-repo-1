package gov.va.med.pharmacy.web.search;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/vieweRx")
public class SearchController {

	
	
	@RequestMapping(value = "/main")	
	public String getMainPage(HttpServletRequest request) {
		
		// TODO View eRX logic
		return "vieweRx.homepage";
	}

	

}
