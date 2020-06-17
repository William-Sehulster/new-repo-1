package gov.va.med.pharmacy.web.csv;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class CSVSupportBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 3002888953116688419L;
	
	public transient final static String HEADERS_ROW = "CSV_HEADERS";
	public transient final static String DATA_ROWS = "CSV_DATA";
	public transient final static String MESSAGE = "MESSAGE_DATA";

	private String[] headers = null;
	private ArrayList<Object> dataRows = null;
	private String message = null;

	public String[] getHeaderRow() {
		return this.headers;
	}
	public void setHeaderRow(String[] headers) {
		this.headers = headers;
	}
	public String[][] getDataRows() {
		String[][] data = new String[this.dataRows.size()][];
		for (int i=0; i < this.dataRows.size(); i++) {
			data[i] = (String[])dataRows.get(i);
		}
		return data;
	}
	public void setDataRows(String[][] data) {
		this.dataRows = new ArrayList<Object>();
		for (int i=0; i < data.length; i++) {
			this.addDataRow(data[i]);
		}
	}
	public void setDataRows(Object[][] data) {
		this.dataRows = new ArrayList<Object>();
		for (int i=0; i < data.length; i++) {
			this.addDataRow(data[i]);
		}
	}
	public void addDataRow(String[] dataRow) {
		this.dataRows.add(dataRow);
	}
	public void addDataRow(Object[] dataRow) {
		String[] stringDataRow = new String[dataRow.length];
		for (int i=0; i < dataRow.length; i++) {
			stringDataRow[i] = dataRow[i].toString();
		}
		this.addDataRow(stringDataRow);
	}
	public void addDataRow(List<Object> dataRow) {
		String[] stringDataRow = new String[dataRow.size()];
		for (int i=0; i < dataRow.size(); i++) {
			stringDataRow[i] = dataRow.get(i).toString();
		}
		this.addDataRow(stringDataRow);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String,Object> createModel() {
		Map<String,Object> model = new HashMap<String,Object>();
		model.put(HEADERS_ROW, headers);
		model.put(DATA_ROWS, this.getDataRows());
		model.put(MESSAGE, this.getMessage());
		return model;
	}
}
