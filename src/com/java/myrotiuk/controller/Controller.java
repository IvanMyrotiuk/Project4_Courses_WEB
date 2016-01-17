package com.java.myrotiuk.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import com.java.myrotiuk.command.Command;
import com.java.myrotiuk.command.CommandFactory;
import com.java.myrotiuk.resources.MessageManager;
import com.java.myrotiuk.resources.PathManager;

/**
 * Class<code> Controller</code> is a controller of all application that call specific command to execute
 * for specific request and depends on result of this command dispatch result(model) of that command to concrete
 * jsp page (to the view). This class implements model view controller(MVC) architecture.
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 16-01-2016
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Controller.class);
	
	public void init() throws ServletException {
		//the easiest way to configure logger when server will run your app and find your configurations
		//you should place the log4j.properties under the WEB-INF/classes directory of your web-applications.
		//Log4j will find the properties file and initialize itself. This is easy to do and it works. 
		//or just put into  root of src 
		String log4jLocation = getInitParameter("log4j-xml-location");
		String webAppPath = this.getServletContext().getRealPath("/");
		if(log4jLocation != null){
			DOMConfigurator.configure(webAppPath+log4jLocation);
			//if you use properties file then use PropertyConfigurator
		}
	}


    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String language = (String) request.getSession().getAttribute("language");
		MessageManager.setBundle(language);
		
		CommandFactory factory = CommandFactory.getInstance();
		Command command = factory.getCommand(request);
		String page = command.execute(request);
		
		if(page != null){
			request.getRequestDispatcher(page).forward(request, response);
		}else{
			logger.error("It was wrong request therefore you will be redirected to home page from controller");
			request.setAttribute("nullPageMessage", MessageManager.getProperty("message.nullpage")+"message from controller");
			request.getRequestDispatcher(PathManager.INDEX_PAGE).forward(request, response);
		}
	}

}
