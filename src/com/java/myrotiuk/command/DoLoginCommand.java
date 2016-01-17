package com.java.myrotiuk.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.java.myrotiuk.entities.dto.Student;
import com.java.myrotiuk.entities.dto.Teacher;
import com.java.myrotiuk.logic.LoginLogic;
import com.java.myrotiuk.resources.MessageManager;
import com.java.myrotiuk.resources.PathManager;

public class DoLoginCommand implements Command{

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		request.setAttribute("currentPage", PathManager.LOGIN_PAGE);
		return PathManager.LOGIN_PAGE;
	}
}
