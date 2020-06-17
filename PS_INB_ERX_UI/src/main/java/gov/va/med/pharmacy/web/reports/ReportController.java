package gov.va.med.pharmacy.web.reports;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/reports")
public class ReportController {

	//private ObjectMapper objectMapper;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView getMainPage(HttpServletRequest request) {

		String tilesView = "reports.homepage";

		ModelAndView reportView = new ModelAndView(tilesView);

		return reportView;
	}
	
	

}
