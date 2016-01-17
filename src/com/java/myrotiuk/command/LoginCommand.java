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

public class LoginCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
//		String language = (String) request.getSession().getAttribute("language");
//		MessageManager.setBundle(language);
		
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		
		LoginLogic loginLogic = new LoginLogic();
		
		request.setAttribute("userEmail", userEmail);
		
		String page = null;
		
		if(loginLogic.validate(userEmail, userPassword)){
			
			Student student = loginLogic.loginStudent(userEmail, userPassword);
			Teacher teacher = loginLogic.loginTeacher(userEmail, userPassword);;
			HttpSession session = request.getSession();
			if(student != null){
				session.setAttribute("student", student);
				request.setAttribute("currentPage", PathManager.WELCOME_STUDENT_PAGE);
				request.setAttribute("messageForFilter", "Login SUCCESSFUL for student with email:");
				page = PathManager.WELCOME_STUDENT_PAGE;
			}else if(teacher != null){
				session.setAttribute("teacher", teacher);
				request.setAttribute("currentPage", PathManager.WELCOME_TEACHER_PAGE);
				request.setAttribute("messageForFilter", "Login SUCCESSFUL for teacher with email:");
				page = PathManager.WELCOME_TEACHER_PAGE;
			}else{
				request.setAttribute("loginMessage",  MessageManager.getProperty("message.fail.login"));
				request.setAttribute("currentPage", PathManager.LOGIN_PAGE);
				request.setAttribute("messageForFilter", "Login was FAILD to email:");
				page =  PathManager.LOGIN_PAGE;
			}
			
		}else{
			request.setAttribute("loginMessage", loginLogic.getLoginMessage());
			request.setAttribute("currentPage", PathManager.LOGIN_PAGE);
			request.setAttribute("messageForFilter", "Login was FAILD to email:");
			page =  PathManager.LOGIN_PAGE;
		}
		
		return page;//welcome page to student or teacher
	}

}
