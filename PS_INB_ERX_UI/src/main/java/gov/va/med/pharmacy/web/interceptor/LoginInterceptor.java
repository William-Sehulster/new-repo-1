
package gov.va.med.pharmacy.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import gov.va.med.pharmacy.web.Constants;


public class LoginInterceptor extends HandlerInterceptorAdapter {

    
    //private static Log logger = LogFactory.getLog(LoginInterceptor.class);

    /**
     * Instantiates a new login interceptor.
     */
    public LoginInterceptor() {
        super();
        //logger.debug("in Login Interceptor class");
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

        HttpSession session = request.getSession();
        //logger.debug(request.getRequestURL());
        // need to add the user to the session.
        if (request.getRequestURL().toString().endsWith("/inb-erx/index")) {
            return true;
        }
        if (session.getAttribute(Constants.SESSION_USER) == null) {
         
        	
            response.sendRedirect("/inbound/public/landing");
            return false;
        }

        return true;
    }

}
