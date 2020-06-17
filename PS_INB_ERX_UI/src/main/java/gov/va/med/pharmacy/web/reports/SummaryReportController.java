package gov.va.med.pharmacy.web.reports;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

import gov.va.med.pharmacy.persistence.model.SummaryReportVw;
import gov.va.med.pharmacy.persistence.report.StationIdSelectModel;
import gov.va.med.pharmacy.persistence.report.SummaryReportFilter;
import gov.va.med.pharmacy.persistence.report.VisnSelectModel;
import gov.va.med.pharmacy.persistence.service.SummaryReportService;
import gov.va.med.pharmacy.persistence.service.TrackMessageService;
import gov.va.med.pharmacy.web.csv.CSVSupportBean;
import gov.va.med.pharmacy.web.csv.CSVView;
import net.rossillo.spring.web.mvc.CacheControl;
import net.rossillo.spring.web.mvc.CachePolicy;

@CacheControl
@Controller
@RequestMapping(value = "/summaryReport")
public class SummaryReportController {
	
	
	private static final String[] SUMMARY_REPORT_HEADER = { "VISN", "VA Station ID",	"NCPDP ID", "Pharmacy Name", "Address", "#New Rx", 
			                                               "#Pharmacy Disabled", "#Rejected at Hub", "#Passed Autocheck","#Failed Autocheck","#Rejected by Pharmacy",
			                                               "#Rx Filled","#Accepted by Pharmacy"};
	
	private static final String[] SUMMARY_REPORT_TOTALS_HEADER = { "#New Rx", "#Pharmacy Disabled",	"#Rejected at Hub", "#Passed Autocheck", "#Failed Autocheck", "#Rejected by Pharmacy", 
            "#Rx Filled", "#Accepted by Pharmacy"};
	

	@Autowired
	private SummaryReportService summaryReportService;
	
	@Autowired
	private TrackMessageService trackMessageService;

	@RequestMapping(value = "/getSummary", method = RequestMethod.GET)
	@CacheControl(policy = {CachePolicy.NO_CACHE})
	@ResponseBody
	public List<SummaryReportVw> getSummaryReport(HttpServletRequest request, @RequestParam("json") String json)
			throws JsonParseException, JsonMappingException, IOException {

		List<SummaryReportVw> summaryReportVwList = new ArrayList<SummaryReportVw>();

		String jsonString = JsonSanitizer.sanitize(json); // Sanitize the JSON coming from client
		
		
		ObjectMapper jsonMapper = new ObjectMapper();
		
		SummaryReportFilter summaryReportFilter = jsonMapper.readValue(jsonString, SummaryReportFilter.class);

		summaryReportVwList.addAll(summaryReportService.find(summaryReportFilter));
		return summaryReportVwList;
	}

	@RequestMapping(value = "/getStationIdSelect", method = RequestMethod.GET, produces = "application/json")
	@CacheControl(policy = {CachePolicy.NO_CACHE})
	@ResponseBody
	public List<StationIdSelectModel> getStationIdSelect(HttpServletRequest request, @RequestParam("visn") String visn)
			throws JsonParseException, JsonMappingException, IOException {

		List<StationIdSelectModel> stationIdSelectModelList = new ArrayList<StationIdSelectModel>();

		List<SummaryReportVw> summaryReportVwList = new ArrayList<SummaryReportVw>();
	
		if (visn.equalsIgnoreCase("/")) {
			visn = "";
		}

		summaryReportVwList.addAll(summaryReportService.find(visn));

		int i = 0;
		while (i < summaryReportVwList.size()) {
			StationIdSelectModel stationIdSelectModel = new StationIdSelectModel();
			
			
			stationIdSelectModel.setId(summaryReportVwList.get(i).getPharmacyVaStationId());
			stationIdSelectModel.setLabel(summaryReportVwList.get(i).getPharmacyVaStationId());
			stationIdSelectModelList.add(i, stationIdSelectModel);
			i++;
		}
		
		StationIdSelectModel stationIdSelectModel = new StationIdSelectModel();
		stationIdSelectModel.setId("All");
		stationIdSelectModel.setLabel(" All ");
		stationIdSelectModelList.add(i, stationIdSelectModel);

		return stationIdSelectModelList;
	}

	@RequestMapping(value = "/getSummaryReportCSV", method = {RequestMethod.GET, RequestMethod.POST})
	public void csvExport(HttpServletRequest request, @RequestParam("json") String json,HttpServletResponse response) 
			throws JsonParseException, JsonMappingException, IOException{
		
		try {
			String jsonString = JsonSanitizer.sanitize(json);
			
			String csvFileName = "SummaryReport.csv";
			
			String responseHeaderKey = "Content-Disposition";
			
			String responseHeaderValue = String.format("attachment; filename=\"%s\"",   csvFileName);
			
			ObjectMapper jsonMapper = new ObjectMapper();
			
			SummaryReportFilter summaryReportFilter = jsonMapper.readValue(jsonString, SummaryReportFilter.class);
			
			List<SummaryReportVw> summaryReportVwList = summaryReportService.queryForExport(summaryReportFilter);
			
			String[][] csvData = null;
			
			if(null!= summaryReportVwList && summaryReportVwList.size()>0){
				
				csvData = populateDataRows(summaryReportVwList,	SUMMARY_REPORT_HEADER);		
				
				csvData = populateTotalDataRows(csvData, summaryReportVwList, SUMMARY_REPORT_HEADER,SUMMARY_REPORT_TOTALS_HEADER);
				
				
			}
			else{
				
				List<SummaryReportVw> summaryReportVwEmptyList = new ArrayList<SummaryReportVw>();
				
				SummaryReportVw  emptyBean = new SummaryReportVw();
				summaryReportVwEmptyList.add(emptyBean);				
				
				csvData = populateDataRows(summaryReportVwEmptyList,	SUMMARY_REPORT_HEADER);
				
				csvData = populateTotalDataRows(csvData, summaryReportVwEmptyList, SUMMARY_REPORT_HEADER,SUMMARY_REPORT_TOTALS_HEADER);
				
			}
			
			
			
			
			
			response.setContentType("text/csv");
			
			response.setHeader(responseHeaderKey, responseHeaderValue);
			
			CSVSupportBean csvSupportBean = new CSVSupportBean();
			
			csvSupportBean.setHeaderRow(SUMMARY_REPORT_HEADER);

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
	
	
	private String[][] populateDataRows(List<SummaryReportVw> rows, String[] headers) {
		// + 1 for the totals as the last row
		String[][] dataRows = new String[rows.size()+1][headers.length];
		for (int i = 0; i < rows.size(); i++) {
			
			String[] row = ((SummaryReportVw) rows.get(i)).getStringArray();
						
			for (int j = 0; j < headers.length; j++) {
				
				dataRows[i][j] = row[j];
				
			}
		}
		
		return dataRows;
		
	}
	
	
	private String[][] populateTotalDataRows(String[][] csvData, List<SummaryReportVw> rows, String[] headers,String[] totalHeaders) {
		
		int totalHeader = 1;
		
		String[][] totalsArray = {{"",""}, {"Totals:",""}}; // to add space after records, first row is empty.
		
		String[][] newDataRows =  new String[csvData.length+totalsArray.length][totalHeader];
		
		System.arraycopy(csvData, 0, newDataRows, 0, csvData.length);
		
		System.arraycopy(totalsArray, 0, newDataRows, csvData.length, totalsArray.length);
		
		String[][] dataRows = new String[1][totalHeaders.length];
		
		String[][] summaryReportHeaders = { {"#New Rx", "#Pharmacy Disabled",	"#Rejected at Hub", "#Passed Autocheck", "#Failed Autocheck", "#Rejected by Pharmacy", 
				"#Rx Filled", "#Accepted by Pharmacy"}};
		
		int sumVal = 0;
		
		for (int i = 0; i < rows.size(); i++) {
			
			String[] row = ((SummaryReportVw) rows.get(i)).getStringArray();
						
			for (int j = 0; j < headers.length; j++) {
				
				if(j>4){
					
				
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
