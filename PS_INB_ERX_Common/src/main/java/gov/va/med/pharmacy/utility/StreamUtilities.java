package gov.va.med.pharmacy.utility;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtilities {

	public static void safeClose(FileInputStream fileInputStream) {
		  if (fileInputStream != null) {
		    try {
		    	fileInputStream.close();
		    } catch (IOException e) {
		      System.out.print("StreamUtilities: Unable to close fileInputStream");
		    }
		  }
		}
	
	public static void safeClose(InputStream inputStream) {
		  if (inputStream != null) {
		    try {
		      inputStream.close();
		    } catch (IOException e) {
			  System.out.print("StreamUtilities: Unable to close inputStream");
		    }
		  }
		}
	
	public static void safeClose(BufferedReader bufferedReader) {
		  if (bufferedReader != null) {
		    try {
		    	bufferedReader.close();
		    } catch (IOException e) {
		      System.out.print("StreamUtilities: Unable to close bufferedReader");
		    }
		  }
		}
	
}
