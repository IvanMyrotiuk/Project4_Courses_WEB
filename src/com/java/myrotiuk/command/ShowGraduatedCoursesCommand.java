package com.java.myrotiuk.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.java.myrotiuk.entities.dto.Register;
import com.java.myrotiuk.entities.dto.Student;
import com.java.myrotiuk.logic.ShowGraduatedCoursesLogic;
import com.java.myrotiuk.resources.MessageManager;
import com.java.myrotiuk.resources.PathManager;

public class ShowGraduatedCoursesCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Student student  = (Student) session.getAttribute("student");
		
		List<Register> graduatedCourses = ShowGraduatedCoursesLogic.getGraduatedCourses(student);
		
		if(graduatedCourses.isEmpty()){
			request.setAttribute("graduatedCoursesMessage", MessageManager.getProperty("message.graduated.courses.empty"));
		}
		
		request.setAttribute("graduatedCourses", graduatedCourses);
		request.setAttribute("command", "graduatedCourses");
		
		return PathManager.GRADUATED_COURSES;
	}

}
