package com.java.myrotiuk.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.java.myrotiuk.entities.dto.Course;
import com.java.myrotiuk.entities.dto.Teacher;
import com.java.myrotiuk.logic.AddCourseLogic;
import com.java.myrotiuk.logic.ShowTeacherCoursesLogic;
import com.java.myrotiuk.resources.MessageManager;
import com.java.myrotiuk.resources.PathManager;

public class AddCourseCommnad implements Command{

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		String courseName = request.getParameter("courseName"); 
		
		String coursePlaces = request.getParameter("coursePlaces");
		
		ShowTeacherCourses showTeacherCourses = new ShowTeacherCourses();
		
		int places = 0;
		
		try{
			places = Integer.parseInt(coursePlaces);
		}catch(NumberFormatException e){
			request.setAttribute("courseName", courseName);
			showTeacherCourses.execute(request);//as i want to show message if there is no courses and also want to put into request list of teachers courses
			request.setAttribute("addCourseMessage", MessageManager.getProperty("message.add.course.faild.places"));
			return PathManager.TEACHER_COURSES;
		}
		
		AddCourseLogic addCourseLogic = new AddCourseLogic();
		
		HttpSession session = request.getSession();
		Teacher teacher  = (Teacher) session.getAttribute("teacher");
		
		Course course = new Course(teacher, courseName, places);
		
		if(!addCourseLogic.validateCourse(course)){
			request.setAttribute("courseName", courseName);
			showTeacherCourses.execute(request);
			request.setAttribute("addCourseMessage", addCourseLogic.getValidationMessage());
			return PathManager.TEACHER_COURSES;	
		}
		
		addCourseLogic.addCourse(course);
		
		showTeacherCourses.execute(request);
		
		return PathManager.TEACHER_COURSES;
	}

}
