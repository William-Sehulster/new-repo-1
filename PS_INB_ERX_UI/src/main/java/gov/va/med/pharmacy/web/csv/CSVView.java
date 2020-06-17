package gov.va.med.pharmacy.web.csv;

import java.util.Map;


/**
 * This view uses the CSVUtility class to output a CSV string.
 * For this to work most cleanly, we basically convert each object into
 * an Array of Strings that can be used by the library.
 */
public class CSVView  {

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(CSVView.class);
	
	public CSVView() {

	}

	public String getStringRepresentation(Map<String,Object> model) {
		CSVUtility utility = new CSVUtility();
		
		StringBuffer csvString = new StringBuffer();
		String[] headers = (String[])model.get(CSVSupportBean.HEADERS_ROW);
		csvString.append(utility.createCSV(headers));
		String[][] data = (String[][])model.get(CSVSupportBean.DATA_ROWS);
		csvString.append(utility.createCSV(data));
		String finalString = csvString.toString();
		LOG.debug("csvString = " + finalString);
		return finalString;
	}
	
	protected void fixFirstCSVRow(String[][] data) {
		if (data != null && data.length > 0 && data[0] != null) {
			String[] firstRow = data[0];
			for (int i=0; i < firstRow.length; i++) {
				if (firstRow[i] == null || firstRow[i].equals("")) {
					firstRow[i] = " ";
				}
			}
		}
	}
}
