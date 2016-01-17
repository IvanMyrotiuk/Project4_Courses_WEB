package com.java.myrotiuk.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.java.myrotiuk.entities.dto.Course;
import com.java.myrotiuk.entities.dto.Student;
import com.java.myrotiuk.logic.DoEnrolLogic;
import com.java.myrotiuk.logic.EnrolLogic;
import com.java.myrotiuk.resources.MessageManager;
import com.java.myrotiuk.resources.PathManager;

public class DoEnrolCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		DoEnrolLogic doEnrolLogic = new DoEnrolLogic();
		
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("student");
		
		
		List<Course> coursesToEnrol = doEnrolLogic.getCoursesToEnrolForParticularStudent(student);
		
		if(coursesToEnrol.isEmpty()){
			request.setAttribute("enrolMessage", MessageManager.getProperty("message.enrol"));
		}
		
		request.setAttribute("coursesToEnrol", coursesToEnrol);
		request.setAttribute("command", "doenrol");
		
		return PathManager.ENROL_PAGE;
	}

}
