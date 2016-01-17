package com.java.myrotiuk.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

import sun.rmi.log.ReliableLog.LogFile;

/**
 * Servlet Filter implementation class LogFilter
 */
public class LogFilter implements Filter {

	private static final Logger logger = Logger.getLogger(LogFile.class);
    /**
     * Default constructor. 
     */
    public LogFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		String ipAddress = request.getRemoteAddr();
		String host = request.getRemoteHost();
		String userEmail = request.getParameter("userEmail");
		
		if(userEmail != null){
			logger.info("Remote address:"+ipAddress+" Remote host:"+host+" trying access to "+userEmail);
		}
		
		chain.doFilter(request, response);
		
		String messageForFilter = (String) request.getAttribute("messageForFilter");
		if(messageForFilter != null){
			logger.info("Remote address:"+ipAddress+" Remote host:"+host+" "+ messageForFilter+" " + userEmail);
		}
	}
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
