
package gov.va.med.pharmacy.web.filter;

import static gov.va.med.pharmacy.utility.ESAPIValidationType.LOG_FORGING;
import static gov.va.med.pharmacy.utility.ESAPIValidator.validateStringInput;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.web.util.WebUtils;


/**
 * A class containing methods to sanitize inputs to prevent XSS.
 *
 */
public class XSSRequestWrapper extends HttpServletRequestWrapper {

    private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(XSSRequestWrapper.class);

    private Map<String, String[]> sanitizedQueryString;
    
    private static Pattern[] patterns = new Pattern[] {

        // Script fragments
        Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE),

        // src='...'
        Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
    
        Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        // lonely script tags
        Pattern.compile("</script>", Pattern.CASE_INSENSITIVE),
       
        Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        // eval(...)
        Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        // expression(...)
        Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        // javascript:...
        Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE),
       
 
        Pattern.compile("\\\"*?(%22)*onmouseover=\\\"*?(.*?)\\)(%22)*\\\"*?", Pattern.CASE_INSENSITIVE),
      
        Pattern.compile("alert\\((.*?)\\)", Pattern.CASE_INSENSITIVE),
       
        // vbscript:...
        Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE),

        // onload(...)=...
        Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        // img src
        Pattern.compile("<img(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
               
        Pattern.compile("<IMG.*?>", Pattern.LITERAL | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("\">(.*?)",  Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
               
        // Mouse Events
        Pattern.compile("onclick.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("oncontextmenu.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("ondblclick.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onmousedown.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onmouseenter.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onmouseleave.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onmousemove.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onmouseover.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onmouseout.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onmouseup.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        // Keyboard Events
        Pattern.compile("onkeydown.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onkeypress.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onkeyup.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        // Frame/Object Events
        Pattern.compile("onabort.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onbeforeunload.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onerror.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onhashchange.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onload.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onpageshow(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onpagehide.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onresize.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onscroll.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onunload.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        //Form Events

        Pattern.compile("onblur.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onchange.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onfocus.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onfocusin.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onfocusout.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("oninput.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("oninvalid.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onreset.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onsearch.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onselect.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onsubmit.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        //Drag Events

        Pattern.compile("ondrag.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("ondragend.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("ondragenter.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("ondragleave.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("ondragover.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("ondragstart.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("ondrop.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        //Clipboard Events

        Pattern.compile("oncopy.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("oncut.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onpaste.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        //Print Events
        Pattern.compile("onafterprint.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onbeforeprint.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),     

        //Animation Events
        Pattern.compile("animationend.*?", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("animationiteration.*?", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("animationstart.*?", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        //Transition Events
        Pattern.compile("transitionend.*?", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("confirm\\((.*?)\\)", Pattern.CASE_INSENSITIVE),
        
        Pattern.compile("’.*?$", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),    
        
        Pattern.compile("^\".*$", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("''.*?$", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("<.*?>",  Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
         //Misc Events
        Pattern.compile("ononline.*?", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onoffline.*?", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onshow.*?", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("ontoggle.*?", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

        Pattern.compile("onwheel.*?", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile(">><.*?>",  Pattern.LITERAL | Pattern.MULTILINE | Pattern.DOTALL),
        
        // others        
        Pattern.compile("onbeforecopy.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onbeforecut.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onbeforepaste.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("oncopy.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("oncut.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("oninput.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("textInput.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("prompt\\((.*?)\\)", Pattern.CASE_INSENSITIVE),        
        
        Pattern.compile("onreadystatechange.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
       
        Pattern.compile("onstop.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
       
        Pattern.compile("onlosecapture.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
       
        Pattern.compile("onmousewheel.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
       
        Pattern.compile("onmove.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onmoveend.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onmovestart.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("ondrag.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("ondragend.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("ondragenter.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("ondragleave.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("ondragover.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("ondragstart.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("ondrop.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onresizeend.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onresizestart.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),        
        
        Pattern.compile("onactivate.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onbeforeactivate.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onbeforedeactivate.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onbeforeeditfocus.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("ondeactivate.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        
        Pattern.compile("oncontrolselect.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onselectionchange.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onselectstart.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onhelp.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onerrorupdate.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onafterupdate.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onbeforeupdate.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("oncellchange.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("ondataavailable.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("ondatasetchanged.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("ondatasetcomplete.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onrowenter.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onrowexit.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onrowsdelete.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onrowsinserted.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onbounce.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onfinish.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onstart.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onfilterchange.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onpropertychange.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
                
        Pattern.compile("onmessage.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        
        Pattern.compile("CheckboxStateChange.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("DOMActivate.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("DOMAttrModified.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("DOMCharacterDataModified.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("DOMFocusIn.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("DOMFocusOut.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("DOMMouseScroll.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("DOMNodeInserted.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("DOMNodeInsertedIntoDocument.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("DOMNodeRemoved.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("DOMNodeRemovedFromDocument.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("DOMSubtreeModified.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("dragdrop.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("dragexit.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("draggesture.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("overflow.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("overflowchanged.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("RadioStateChange.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("underflow.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),      
        
        Pattern.compile("FSCommand.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onBegin.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onEnd.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onLayoutComplete.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onLoseCapture.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onMediaComplete.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onMediaError.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onOutOfSync.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onPause.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onPopState.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onProgress.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onRedo.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onRepeat.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onResume.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onReverse.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onRowsEnter.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onRowExit.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onRowDelete.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onRowInserted.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onSeek.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onStorage.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onSyncRestored.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onTimeError.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onTrackChange.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onUndo.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("onURLFlip.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
        Pattern.compile("seekSegmentTime.*?=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        
    };

    /**
     * constructor
     *
     * @param servletRequest request
     */
    public XSSRequestWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
    }

    @Override
    public String[] getParameterValues(String name) {
        return getParameterMap().get(name);
    }
    
    @Override
    public String getServletPath() {
        return stripXSS( super.getServletPath());        
    }
    
    @Override
    public String getQueryString() {
        return stripXSS( super.getQueryString());        
    }
    
    @Override
    public String getPathInfo() {
        return stripXSS( super.getPathInfo());        
    }   

    @Override
    public String getParameter(String name) {
        String parameter = null;
     
        String[] vals = getParameterMap().get(name);
      
        if (vals != null && vals.length > 0) {
          parameter = vals[0];
        }
      
        return parameter;
    }

    @Override
    public String getRequestURI() {
       
    	return stripXSS( super.getRequestURI());
    }
    
    @Override
    public StringBuffer getRequestURL() {
    
        return new StringBuffer(stripXSS( super.getRequestURL().toString()));
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public Map<String,String[]> getParameterMap() {
    
    	if(sanitizedQueryString == null ) {
     
    		Map<String, String[]> res = new HashMap<String, String[]>();
        
    		Map<String, String[]> originalQueryString = super.getParameterMap();
        
    		if(originalQueryString!=null) {
       
    			for (String key : (Set<String>) originalQueryString.keySet()) {
           
    				String[] rawVals = originalQueryString.get(key);
           
    				String[] snzVals = new String[rawVals.length];
           
    				for (int i=0; i < rawVals.length; i++) {
            
    					snzVals[i] = stripXSS(rawVals[i]);
            }
           
    				res.put(stripXSS(key), snzVals);
          }
        }
        
    		sanitizedQueryString = res;
      }
    
    	return sanitizedQueryString;
    }
    
    
    @Override
    public Object getAttribute(String name) {
     
    	Object value = super.getAttribute(name);
      
    	if( name.equals(WebUtils.FORWARD_REQUEST_URI_ATTRIBUTE)){

          value=(value!=null)?stripXSS(value.toString()):null;
        }
       
    	return value;
    }    

    @Override
    public String getHeader(String name) {
    
    	String value = super.getHeader(name);

        return stripXSS(value);
    }

    /**
     * Since the web app is not storing or reading any cookies, the following method needs to be
     * commented out, otherwise Fortify scan fails.
     * 
     */
    
    /**
     * override the getCookies method
     * @see javax.servlet.http.HttpServletRequestWrapper#getCookies()
     * 
     * @return Cookies
     *//*
    @Override
    public Cookie[] getCookies() {
        Cookie[] cookies = super.getCookies();
    
        for (Cookie c : cookies) {
     
        	c.setValue(stripXSS(c.getValue()));
        }
        
        return cookies;
    }*/

    /**
     * stripXSS
     * @param key string key string of parameter
     * @param value string value string of parameter
     * @return string
     */
    public String stripXSS(String value)  {
       
    	String cleanValue = value;
       

        if (value != null && value.length() > 0) {

                     
            cleanValue = canonicalize(value);
         
            // Avoid null characters
            cleanValue = cleanValue.replaceAll("\0", "");

            // Remove all sections that match a pattern
            for (Pattern scriptPattern : patterns) {
              
            	if (scriptPattern.matcher(cleanValue).find()) 
                {
                    LOG.error("XSS ATTACK attempt found on a value: '" + validateStringInput(cleanValue, LOG_FORGING) + "' PATTERN: " + validateStringInput(scriptPattern.toString(), LOG_FORGING));
                 
                     cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");
                       
                     LOG.error("XSS ATTACK was remedied, old value: " + validateStringInput(value, LOG_FORGING) + 	" | New value: " + cleanValue);    
                        
                
                              
                }
            }
        }
        
       
        return cleanValue;
    }

    /**
     * canonicalize
     * Simplifies input to its simplest form to make encoding tricks more difficult
     * 
     * @param input string
     * @return string
     */
    private String canonicalize(String input) {

       
        String canonical = Normalizer.normalize(input, Normalizer.Form.NFD);       
      
        canonical = StringEscapeUtils.unescapeHtml4(canonical);       
      
        canonical = StringEscapeUtils.unescapeEcmaScript(canonical);
	   
        return canonical;
    }
}
