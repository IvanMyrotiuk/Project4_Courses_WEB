package com.java.myrotiuk.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.java.myrotiuk.entities.dto.Course;
import com.java.myrotiuk.entities.dto.Teacher;
import com.java.myrotiuk.logic.ShowTeacherCoursesLogic;
import com.java.myrotiuk.resources.MessageManager;
import com.java.myrotiuk.resources.PathManager;

public class DoAssignGradesCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher)session.getAttribute("teacher"); 

		List<Course> teacherCourses = ShowTeacherCoursesLogic.showTeacherCourses(teacher);
		
		if(teacherCourses.isEmpty()){
			request.setAttribute("assignGradesMessage", MessageManager.getProperty("message.teacher.courses"));
		}
		
		request.setAttribute("teacherCourses", teacherCourses);
		request.setAttribute("command", "doAssignGrades");
		
		return PathManager.ASSIGN_GRADES;
	}

}
