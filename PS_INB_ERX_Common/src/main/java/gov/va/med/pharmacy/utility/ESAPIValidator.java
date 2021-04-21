package gov.va.med.pharmacy.utility;

import static org.owasp.esapi.ESAPI.validator;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.owasp.esapi.ESAPI;


/**
 * A wrapper class around ESAPI validator. Contains methods to validate input to cover all potential error reported by fortify scan.
 *
 */
public final class ESAPIValidator {

    /**
     * Private constructor.
     */
    private ESAPIValidator() {
    }

    /**
     * Validate method.
     *
     * @param input  the input string to validate
     * @param type the type of validation to be performed
     * @return the scrubbed output string if able to validate/scrub - null if unable for Log Forging.
     *
     */
    public static String validateStringInput(String input, ESAPIValidationType type) {

        // Exit immediately if input is null
        if (input == null) {
            return null;
        }

        // Exit immediately if input is Empty
        if (input.length() < 1) {
            return "";
        }

        switch (type) {

        case ACCESS_CONTROL_DB:
            try {
                return validator().getValidInput("accessControlDb", input, "accessControlDb", Integer.MAX_VALUE, false, false);
            } catch (Exception e) {
                throw new RuntimeException("Invalid characters found in input.  Access Control: DB violation.");
            }
// commented out as not currently used and for Fortify code quality fix.
/*        case COMMAND_INJECTION:
            try {

                return validator().getValidInput("commandInjection", input, "commandInjection", Integer.MAX_VALUE, false, false);

            } catch (Exception e) {
                throw new RuntimeException("Invalid characters found in input.  Command Injection violation.");
            }

        case CROSS_SITE_SCRIPTING_PERSISTENT:
            try {
                return validator().getValidInput("crossSiteScriptingPersistent", input, "crossSiteScriptingPersistent",Integer.MAX_VALUE, false, false);
            } catch (Exception e) {
                throw new RuntimeException("Invalid characters found in input.  Cross Site Scripting: Persistent violation.");
            }

        case CROSS_SITE_SCRIPTING_REFLECTED:
            try {
               return validator().getValidInput("crossSiteScriptingReflected", input, "crossSiteScriptingReflected",Integer.MAX_VALUE, false, false);
            } catch (Exception e) {
                throw new RuntimeException("Invalid characters found in input.  Cross Site Scripting:  Reflected violation.");
            }

        case DENIAL_OF_SERVICE_REG_EXP:
            try {
                return validator().getValidInput("denialOfServiceRegExp", input, "denialOfServiceRegExp", Integer.MAX_VALUE, false, false);
            } catch (Exception e) {
                throw new RuntimeException("Invalid characters found in input.  "
                        + "Denial Of Service: Regular Expression violation.");
            }

        case JSON_INJECTION:
            try {
                return validator().getValidInput("jsonInjection", input, "jsonInjection", Integer.MAX_VALUE, false, false);
            } catch (Exception e) {
                throw new RuntimeException("Invalid characters found in input.  JSON Injection violation.");
            }

  */          
        case LOG_FORGING:
            // remove cr/lf
            input = input.replace('\n', ' ').replace('\r', ' ');
            try {
                return validator().getValidInput("logForging", input, "logForging", Integer.MAX_VALUE, false, false);
            } catch (Exception e) {
                return null;
            }
            // commented out as not currently used and for Fortify code quality fix.

        case OPEN_REDIRECT:
            try {
                return validator().getValidInput("openRedirect", input, "openRedirect", Integer.MAX_VALUE, false, false);
            } catch (Exception e) {
                throw new RuntimeException("Invalid characters found in input.  Open Redirect violation.");
            }
  /*
        case PATH_MANIPULATION:
            try {
                return validator().getValidInput("pathManipulation", input, "pathManipulation", Integer.MAX_VALUE, false, false);
            } catch (Exception e) {
                throw new RuntimeException("Invalid characters found in input. Path Manipulation violation.");
            }

        case PORTABILITY_FLAW_FILE_SEPARATOR:
            try {
                input = input.replace('\\', File.separator.toCharArray()[0]).replace('/', File.separator.toCharArray()[0]);
                return validator().getValidInput("portabilityFlawFileSeparator", input, "portabilityFlawFileSeparator", Integer.MAX_VALUE, false, false);
            } catch (Exception e) {
                throw new RuntimeException("Invalid characters found in input. Portability Flaw File Separator violation.");
            }

        case PORTABILITY_FLAW_LOCALE:
            try {
                return validator().getValidInput("portabilityFlawLocale", input, "portabilityFlawLocale", Integer.MAX_VALUE, false, false);
            } catch (Exception e) {
                throw new RuntimeException("Invalid characters found in input. Portability Flaw Locale violation.");
            }

        case PRIVACY_VIOLATION:
            // remove cr/lf
            input = input.replace('\n', ' ').replace('\r', ' ');
            try {
                return validator().getValidInput("privacyViolation", input, "privacyViolation", Integer.MAX_VALUE, false, false);
            } catch (Exception e) {
                return null;
            }

           
        case SQL_INJECTION:
            // remove cr/lf
            input = input.replace('\n', ' ').replace('\r', ' ');
            try {
                return validator().getValidInput("sqlInjection", input, "sqlInjection", Integer.MAX_VALUE, false, false);
            } catch (Exception e) {
                return null;
            }

        case SYSTEM_INFORMATION_LEAK_EXTERNAL:
            try {
                return validator().getValidInput("systemInformationLeakExternal", input, "systemInformationLeakExternal",Integer.MAX_VALUE, false, false);
            } catch (Exception e) {
                return null;
            }

        case XML_EXT_ENTITY_INJ:
            try {
                return validator().getValidInput("xmlExtEntityInj", input, "xmlExtEntityInj", Integer.MAX_VALUE, false, false);
            } catch (Exception e) {
                throw new RuntimeException("Invalid characters found in input.  Open Redirect violation.");
            }
   */          
        case IAM_LOGOUT_URL:
            try {
                return validator().getValidInput("IAMLogout", input, "IAMLogout", 300, false, false);
            } catch (Exception e) {
                throw new RuntimeException("Invalid VA URL.  Open Redirect violation.");
            }
        case ACCOUNT_NAME:
            try {
                return validator().getValidInput("AccountName", input, "AccountName", 20, false, false);
            } catch (Exception e) {
                throw new RuntimeException("Invalid Account Name.");
            }

        default:
            return null;
        }
    }

    /**
     * Validate long method.
     *
     * @param input the input string to validate
     * @return the long value if able to validate - -1 if unable.
     */
    public static long validateLongInput(String input) {
        try {
            return ESAPI.validator().getValidNumber("validateLong", input, 0, Long.MAX_VALUE, false).longValue();
        } catch (Exception e) {
            throw new RuntimeException("Invalid long value found in input.");
        }
    }

    /**
     * Validate double input method.
     *
     * @param input the input string to validate
     * @return the double value if able to validate
     */
    public static double validateDoubleInput(String input) {
        try {
            return ESAPI.validator().getValidDouble("validateDouble", input, 0, Double.MAX_VALUE, false).doubleValue();
        } catch (Exception e) {
            throw new RuntimeException("Invalid double value found in input.");
        }
    }

    /**
     * Validate file name method.
     *
     * @param input the input file name string to validate
     * @param allowedExtensions List of allowable file extensions in string format
     * @return a canonicalized and validated file name as a String.
     */
    public static String validateFileNameInput(String input, List<String> allowedExtensions) {
        try {
            return ESAPI.validator().getValidFileName("validateFileNameInput", input, allowedExtensions, false);
        } catch (Exception e) {
            throw new RuntimeException("Invalid file name value found in input.");
        }
    }



    /**
     * Validate file name method.
     *
     * @param input the input file name string to validate
     * @param allowedExtensions List of allowable file extensions in string format
     * @return a canonicalized and validated file name as a String.
     */
    public static String validateFileNameInputWithPath(String input, List<String> allowedExtensions) {
        Path path = Paths.get(validateStringInput(input, ESAPIValidationType.LOG_FORGING));
        String fileName = path.getFileName().toString();
        if (validateFileNameInput(fileName, allowedExtensions).equals(fileName)) {
            return validateStringInput(input, ESAPIValidationType.LOG_FORGING);
        } else {
            throw new RuntimeException("Invalid file name value found in input.");
        }

    }
    
    /** Returns true or false if input string is valid.
     * @param input
     * @param type
     * @return
     */
    public static boolean isValidInput(String input, ESAPIValidationType type){
    	
    	
    	try {
    		  validateStringInput(input, type);
			return true;
		} catch( Exception e ) {
			return false;
		}
    }
}
