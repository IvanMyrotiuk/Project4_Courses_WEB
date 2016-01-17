package com.java.myrotiuk.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.java.myrotiuk.entities.dto.Course;
import com.java.myrotiuk.entities.dto.Teacher;
import com.java.myrotiuk.logic.ShowTeacherCoursesLogic;
import com.java.myrotiuk.resources.MessageManager;
import com.java.myrotiuk.resources.PathManager;

public class ShowTeacherCourses implements Command{

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
		
		List<Course> teacherCourses = ShowTeacherCoursesLogic.showTeacherCourses(teacher);
		
		request.setAttribute("teacherCourses", teacherCourses);
		
		if(teacherCourses.isEmpty()){
			request.setAttribute("teacherCoursesMessage", MessageManager.getProperty("message.teacher.courses"));
		}
		
		request.setAttribute("command", "teacherCourses");
		
		return PathManager.TEACHER_COURSES;
	}

}
