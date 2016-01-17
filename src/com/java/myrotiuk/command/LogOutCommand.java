package com.java.myrotiuk.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.java.myrotiuk.resources.PathManager;

public class LogOutCommand implements Command{

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {

		request.getSession().invalidate();
		return PathManager.INDEX_PAGE;
	}

}
