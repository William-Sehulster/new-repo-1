package gov.va.med.pharmacy.web.csv;

/**
 * CSVUtility is a class to convert an array or multi-dimensional array of
 * Strings into a quoted CSV format.  Every field will be quoted.
 * 
*/
public class CSVUtility {
	
	private StringBuffer buffer = null;
	
	public String createCSV(String[][] fields) {
		buffer = new StringBuffer();
		if (fields == null || fields.length == 0) {
			buffer.append('\n');
		} else {
			for (int i = 0; i < fields.length; i++) {
				processStringArray(fields[i]);
			}
		}
		return buffer.toString();
	}

	public String createCSV(String[] fields) {
		buffer = new StringBuffer();
		processStringArray(fields);
		return buffer.toString();
	}

	protected void processStringArray(String[] fields) {
		if (fields == null || fields.length == 0) {
			buffer.append('\n');
			return;
		}
		writeField(fields[0]);
		for (int i = 1; i < fields.length; i++) {
			buffer.append(',');
			writeField(fields[i]);
		}
		buffer.append('\n');
	}

	/**
	 * Convert the field into a CSV-usable format.  The field should
	 * be quoted if needed.  If field is null, an empty value is returned.
	 *
	 * @param field value to be converted
	 */
	protected void writeField(String field) {
		if (field == null || field.length() == 0) return;
		addQuotedField(field);
	}

	/**
	 * Wraps the field in quotes and handles special escape characters or internal quotes
	 * 
	 * @param field to be quoted and converted
	 * @return the converted value
	 */
	protected void addQuotedField(String field){
		buffer.append('"');
		for (int i = 0; i < field.length(); i++) {
			char c = field.charAt(i);
			if (c == '"') {
				buffer.append("\"\"");
			} else {
				buffer.append(c);
			}
		}
		buffer.append('"');
	}
}
