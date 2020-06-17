package gov.va.med.pharmacy.wsclients.eAnde;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import gov.va.med.pharmacy.utility.StreamUtilities;

public class ClientPasswordCallback implements CallbackHandler {

	private static final String WSCLIENTS_PROPERTIES_FILE = "gov.va.med.pharmacy.inboundeRx.properties";
	private static final String E_AND_E_PASSWD = "eAnde.password";
	private static final String E_AND_E_USERNAME = "eAnde.username";

	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {

		Properties properties = new Properties();
		 
		InputStream inputStream = null;

		String username = null;
		 
		String password = null;
		 
		inputStream = this.getClass().getClassLoader().getResourceAsStream(WSCLIENTS_PROPERTIES_FILE);

		try{
			if (null != inputStream) {
				properties.load(inputStream);
			}
		}
		finally{
				StreamUtilities.safeClose(inputStream);
		}
		username = properties.getProperty(E_AND_E_USERNAME).trim();
		password = properties.getProperty(E_AND_E_PASSWD).trim();

		for (int i = 0; i < callbacks.length; i++) {
			WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];
			if (pc.getUsage() == WSPasswordCallback.USERNAME_TOKEN) {
				pc.setIdentifier(username);
				pc.setPassword(password);
			}
			
		}
	}

}