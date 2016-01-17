package com.java.myrotiuk.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.java.myrotiuk.entities.dto.Student;
import com.java.myrotiuk.logic.SingUpLogic;
import com.java.myrotiuk.resources.MessageManager;
import com.java.myrotiuk.resources.PathManager;

public class SingUpCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {

//		String language = (String) request.getSession().getAttribute("language");
//		MessageManager.setBundle(language);
		
		String page = null;

		String userFirstName = request.getParameter("userFirstName");
		String userLastName = request.getParameter("userLastName");
		String userAddress = request.getParameter("userAddress");
		String userPhone = request.getParameter("userPhone");
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		String userCheckPassword = request.getParameter("userCheckPassword");

		request.setAttribute("userFirstName", userFirstName);
		request.setAttribute("userLastName", userLastName);
		request.setAttribute("userAddress", userAddress);
		request.setAttribute("userPhone", userPhone);
		request.setAttribute("userEmail", userEmail);

		SingUpLogic singUpLogic = new SingUpLogic();

		if (!singUpLogic.validate(userFirstName, userLastName, userAddress, userPhone,
				userEmail, userPassword, userCheckPassword)) {
			request.setAttribute("userSingUpMessage", singUpLogic.getSingUpMessage());
			request.setAttribute("currentPage", PathManager.SING_UP_PAGE);
			page = PathManager.SING_UP_PAGE;

		}else if (!singUpLogic.existUser(userEmail)) {

			HttpSession session = request.getSession();

			Student student = new Student(userFirstName, userLastName, userAddress, userPhone, userEmail, userPassword);

			singUpLogic.singUp(student);

			if (student.getId() != 0) {
				session.setAttribute("student", student);
				request.setAttribute("currentPage", PathManager.WELCOME_STUDENT_PAGE);
				page = PathManager.WELCOME_STUDENT_PAGE;
			} else {
				request.setAttribute("userSingUpMessage", MessageManager.getProperty("message.db.problem"));
				request.setAttribute("currentPage", PathManager.SING_UP_PAGE);
				page = PathManager.SING_UP_PAGE;
			}

		} else {
			request.setAttribute("userSingUpMessage", MessageManager.getProperty("message.user.exist"));
			request.setAttribute("currentPage", PathManager.SING_UP_PAGE);
			page = PathManager.SING_UP_PAGE;
		}

		return page;
	}

}
