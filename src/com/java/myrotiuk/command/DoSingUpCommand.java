package com.java.myrotiuk.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.java.myrotiuk.resources.PathManager;

public class DoSingUpCommand implements Command{

	public String execute(HttpServletRequest request) throws ServletException, IOException{
		request.setAttribute("currentPage", PathManager.SING_UP_PAGE);
		return PathManager.SING_UP_PAGE;
	}
	
}
