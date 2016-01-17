package com.java.myrotiuk.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.java.myrotiuk.entities.dto.Course;
import com.java.myrotiuk.entities.dto.Register;
import com.java.myrotiuk.entities.dto.Student;
import com.java.myrotiuk.logic.ShowStudentCoursesLogic;
import com.java.myrotiuk.resources.MessageManager;
import com.java.myrotiuk.resources.PathManager;

public class ShowStudentCoursesCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("student");
		
		List<Register> registers = ShowStudentCoursesLogic.showStudentCourses(student);
		
		if(registers.isEmpty()){
			request.setAttribute("studentCoursesMessage", MessageManager.getProperty("message.student.empty.courses"));
		}
		
		//studentCourses
		request.setAttribute("registers", registers);
		request.setAttribute("command", "studentCourses");
		
		return PathManager.STUDENT_COURSES;
	}

}
