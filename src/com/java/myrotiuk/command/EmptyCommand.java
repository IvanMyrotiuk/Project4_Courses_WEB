package com.java.myrotiuk.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.java.myrotiuk.resources.MessageManager;
import com.java.myrotiuk.resources.PathManager;

public class EmptyCommand implements Command{

	private static final String MESSAGE_NULL_PAGE = "message.nullpage";
	
	public String execute(HttpServletRequest request) throws ServletException, IOException{
		request.setAttribute("nullPageMessage", MessageManager.getProperty("message.nullpage"));
		return PathManager.INDEX_PAGE;
	}
	
}
