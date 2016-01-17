package com.java.myrotiuk.command;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Interface<code> Command</code> that has to be implemented by all specific command 
 * for fulfilling users requests
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 16-01-2016
 */
public interface Command {
	
	String execute(HttpServletRequest request) throws ServletException, IOException;
	
}
