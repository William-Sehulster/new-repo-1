

package gov.va.med.pharmacy.web.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


/**
 *  A filter class to prevent XSS attack. 
 */
public class XSSFilter implements Filter {

    /**
     * Empty destroy method
     * 
     */
    @Override
    public void destroy() {
    }

 
    /**
     * Filter method
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,ServletException {
        chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request), response);
    }

    /**
     * empty init method
     * 
     * @param config param
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     * @throws ServletException exception
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

}
