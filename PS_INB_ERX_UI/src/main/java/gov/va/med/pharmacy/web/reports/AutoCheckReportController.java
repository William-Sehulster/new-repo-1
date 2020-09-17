package gov.va.med.pharmacy.web.reports;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.json.JsonSanitizer;

import gov.va.med.pharmacy.persistence.model.AutoCheckReportVw;
import gov.va.med.pharmacy.persistence.report.StationIdSelectModel;
import gov.va.med.pharmacy.persistence.report.SummaryReportFilter;
import gov.va.med.pharmacy.persistence.report.VisnSelectModel;
import gov.va.med.pharmacy.persistence.service.AutoCheckReportService;
import gov.va.med.pharmacy.persistence.service.SummaryReportService;
import gov.va.med.pharmacy.persistence.service.TrackMessageService;
import gov.va.med.pharmacy.web.csv.CSVSupportBean;
import gov.va.med.pharmacy.web.csv.CSVView;
import net.rossillo.spring.web.mvc.CacheControl;
import net.rossillo.spring.web.mvc.CachePolicy;
import org.apache.commons.text.StringEscapeUtils;

@CacheControl
@Controller
@RequestMapping(value = "/autoCheckReport")
public class AutoCheckReportController {
	
	
	private static final String[] AUTO_CHECK_REPORT_HEADER = { "VISN", "VA Station ID",	"NCPDP ID", "Pharmacy Name", "Address", "#New Rx", 
            "#Passed Autocheck", "#Failed Autocheck", "#MVI Patient Found","#MVI Patient Not Found","#E&E Enrolled/Eligible",
            "#E&E Not Enrolled/Eligible","#Patient Not Enrolled at Site","#Drug Match Found","#Drug Match Failed","#Provider Match Found",
			"#Provider Match Failed"};

	private static final String[] AUTO_CHECK_REPORT_TOTALS_HEADER = { "#New Rx", 
            "#Passed Autocheck", "#Failed Autocheck", "#MVI Patient Found","#MVI Patient Not Found","#E&E Enrolled/Eligible",
            "#E&E Not Enrolled/Eligible","#Patient Not Enrolled at Site","#Drug Match Found","#Drug Match Failed","#Provider Match Found",
			"#Provider Match Failed"};
	
	@Autowired
	private AutoCheckReportService autoCheckReportService;
	
	@Autowired
	private TrackMessageService trackMessageService;
	@Autowired
	private SummaryReportService summaryReportService;

	@RequestMapping(value = "/getReport", method = RequestMethod.GET)
	@CacheControl(policy = {CachePolicy.NO_CACHE})
	@ResponseBody
	public List<AutoCheckReportVw> getAutoCheckReport(HttpServletRequest request, @RequestParam("json") String json)
			throws JsonParseException, JsonMappingException, IOException {

		List<AutoCheckReportVw> autoCheckReportVwList = new ArrayList<AutoCheckReportVw>();

		String jsonString = JsonSanitizer.sanitize(json); // Sanitize the JSON coming from client
		
		ObjectMapper jsonMapper = new ObjectMapper();
		
		SummaryReportFilter summaryReportFilter = jsonMapper.readValue(jsonString, SummaryReportFilter.class);

		autoCheckReportVwList.addAll(autoCheckReportService.find(summaryReportFilter));
		for(AutoCheckReportVw  autoCheckReportVw: autoCheckReportVwList)
		{
			//Fortify sanitizing the PharmacyAddress, PharmacyDivisionName, getPharmacyNcpdpId and PharmacyVaStationId
			//before being used down the lines.
			autoCheckReportVw.setPharmacyAddress(StringEscapeUtils.escapeJson(autoCheckReportVw.getPharmacyAddress()));
			autoCheckReportVw.setPharmacyDivisionName(StringEscapeUtils.escapeJson(autoCheckReportVw.getPharmacyDivisionName()));
			autoCheckReportVw.setPharmacyNcpdpId(StringEscapeUtils.escapeJson(autoCheckReportVw.getPharmacyNcpdpId()));
			autoCheckReportVw.setPharmacyVaStationId(StringEscapeUtils.escapeJson(autoCheckReportVw.getPharmacyVaStationId()));
		}
		return autoCheckReportVwList;
	}

	@RequestMapping(value = "/getStationIdSelect", method = RequestMethod.GET, produces = "application/json")
	@CacheControl(policy = {CachePolicy.NO_CACHE})
	@ResponseBody
	public List<StationIdSelectModel> getStationIdSelect(HttpServletRequest request, @RequestParam("visn") String visn)
			throws JsonParseException, JsonMappingException, IOException {

		List<StationIdSelectModel> stationIdSelectModelList = new ArrayList<StationIdSelectModel>();

		if (visn.equalsIgnoreCase("/")) {
			visn = "-1";
		} else {
			visn = visn.substring(0, visn.length() - 1);
		}

		stationIdSelectModelList.addAll(summaryReportService.getStationIDs(Integer.parseInt(visn)));
		
		StationIdSelectModel stationIdSelectModel = new StationIdSelectModel();
		
		stationIdSelectModel.setId("All");
		
		stationIdSelectModel.setLabel(" All ");
		
		stationIdSelectModelList.add(stationIdSelectModel);

		for(StationIdSelectModel  stationSelectModel: stationIdSelectModelList)
		{
			//Fortify sanitizing the Id and label before being used down the lines.
			stationSelectModel.setId(StringEscapeUtils.escapeJson(stationSelectModel.getId()));
			stationSelectModel.setLabel(StringEscapeUtils.escapeJson(stationSelectModel.getLabel()));
		}
		return stationIdSelectModelList;
	}

	@RequestMapping(value = "/getReportCSV", method = {RequestMethod.GET, RequestMethod.POST})
	public void csvExport(HttpServletRequest request, @RequestParam("json") String json,HttpServletResponse response) 
			throws JsonParseException, JsonMappingException, IOException{
		
		try {
			String jsonString = JsonSanitizer.sanitize(json);
			
			String csvFileName = "AutoCheckReport.csv";
			
			String responseHeaderKey = "Content-Disposition";
			
			String responseHeaderValue = String.format("attachment; filename=\"%s\"",   csvFileName);
			
			ObjectMapper jsonMapper = new ObjectMapper();
			
			SummaryReportFilter summaryReportFilter = jsonMapper.readValue(jsonString, SummaryReportFilter.class);
			
			List<AutoCheckReportVw> autoCheckReportVwList = autoCheckReportService.queryForExport(summaryReportFilter);
			
			String[][] csvData = null;
			
			if(null!= autoCheckReportVwList && autoCheckReportVwList.size()>0){
				
				csvData = populateDataRows(autoCheckReportVwList,	AUTO_CHECK_REPORT_HEADER);		
				
				csvData = populateTotalDataRows(csvData, autoCheckReportVwList, AUTO_CHECK_REPORT_HEADER,AUTO_CHECK_REPORT_TOTALS_HEADER);
			}
			else{
				
				List<AutoCheckReportVw> autoCheckReportVwEmptyList = new ArrayList<AutoCheckReportVw>();
				
				AutoCheckReportVw  emptyBean = new AutoCheckReportVw();
				autoCheckReportVwEmptyList.add(emptyBean);				
				
				csvData = populateDataRows(autoCheckReportVwEmptyList,	AUTO_CHECK_REPORT_HEADER);
				
				csvData = populateTotalDataRows(csvData, autoCheckReportVwEmptyList, AUTO_CHECK_REPORT_HEADER,AUTO_CHECK_REPORT_TOTALS_HEADER);
				
			}
			
			
			response.setContentType("text/csv");
			
			response.setHeader(responseHeaderKey, responseHeaderValue);
			
			CSVSupportBean csvSupportBean = new CSVSupportBean();
			
			csvSupportBean.setHeaderRow(AUTO_CHECK_REPORT_HEADER);

			csvSupportBean.setDataRows(csvData);
			
			Map<String,Object> csvModel = csvSupportBean.createModel();
			
			CSVView view = new CSVView();
			
			String data = view.getStringRepresentation(csvModel);
			
			response.getOutputStream().print(data);
			
			response.getOutputStream().flush();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "/getVisnSelect", method = RequestMethod.GET, produces = "application/json")
	@CacheControl(policy = {CachePolicy.NO_CACHE})
	@ResponseBody
	public List<VisnSelectModel> getVisnSelect(HttpServletRequest request)
			throws JsonParseException, JsonMappingException, IOException {
		

		List<VisnSelectModel> visnSelectModelList = new ArrayList<VisnSelectModel>();
		
		VisnSelectModel visnSelectModel = new VisnSelectModel();
		visnSelectModel.setId("");
		visnSelectModel.setLabel("All");
		visnSelectModelList.add(visnSelectModel);

		visnSelectModelList.addAll(trackMessageService.getVisns());
		
		return visnSelectModelList;
	}
	
	
	private String[][] populateDataRows(List<AutoCheckReportVw> rows, String[] headers) {
		// + 1 for the totals as the last row
		String[][] dataRows = new String[rows.size()+1][headers.length];
		for (int i = 0; i < rows.size(); i++) {
			
			String[] row = ((AutoCheckReportVw) rows.get(i)).getStringArray();
						
			for (int j = 0; j < headers.length; j++) {
				
				dataRows[i][j] = row[j];
				
			}
		}
		
		return dataRows;
		
	}
	
	
	private String[][] populateTotalDataRows(String[][] csvData, List<AutoCheckReportVw> rows, String[] headers,String[] totalHeaders) {
			
			int totalHeader = 1;
			
			String[][] totalsArray = {{"",""}, {"Totals:",""}}; // to add space after records, first row is empty.
			
			String[][] newDataRows =  new String[csvData.length+totalsArray.length][totalHeader];
			
			System.arraycopy(csvData, 0, newDataRows, 0, csvData.length);
			
			System.arraycopy(totalsArray, 0, newDataRows, csvData.length, totalsArray.length);
			
			String[][] dataRows = new String[1][totalHeaders.length];
			
			String[][] summaryReportHeaders = { {"#New Rx", 
	            "#Passed Autocheck", "#Failed Autocheck", "#MVI Patient Found","#MVI Patient Not Found","#E&E Enrolled/Eligible",
	            "#E&E Not Enrolled/Eligible","#Patient Not Enrolled at Site","#Drug Match Found","#Drug Match Failed","#Provider Match Found",
				"#Provider Match Failed"}};
			
			int sumVal = 0;
			
			for (int i = 0; i < rows.size(); i++) {
				
				String[] row = ((AutoCheckReportVw) rows.get(i)).getStringArray();
							
				for (int j = 0; j < headers.length; j++) {
					
					if(j>4){
						
						//System.out.println("--vals1 ---:"+row[j]);
					
						if(i>=1)
						{
							sumVal =  Integer.valueOf(dataRows[0][j-5]) + Integer.valueOf(row[j]);
							dataRows[0][j-5] = String.valueOf(sumVal);
						}
						else
						{
						
							dataRows[i][j-5] = row[j];
						}
						
						
					}
					
					
					
				}
			}
			
			String[][] finalDataRows =  new String[newDataRows.length+summaryReportHeaders.length+dataRows.length][totalHeader];
			
			System.arraycopy(newDataRows, 0, finalDataRows, 0, newDataRows.length);
			
			System.arraycopy(summaryReportHeaders, 0, finalDataRows, newDataRows.length, summaryReportHeaders.length);
			
			System.arraycopy(dataRows, 0, finalDataRows, newDataRows.length+summaryReportHeaders.length+dataRows.length-1, dataRows.length);
			
			
			return finalDataRows;
			
		}
	
	
	
	
	
}
