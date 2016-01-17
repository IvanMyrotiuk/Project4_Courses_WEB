package com.java.myrotiuk.logic;

import java.util.List;

import com.java.myrotiuk.entities.dto.Course;
import com.java.myrotiuk.entities.dto.Teacher;
import com.java.myrotiuk.jdbc.dao.CourseDAO;
import com.java.myrotiuk.jdbc.dao.DaoFactory;
import com.java.myrotiuk.jdbc.dao.TypeDAOfactory;
import com.java.myrotiuk.jdbc.jdbc.dao.TypeDAO;

public class ShowTeacherCoursesLogic {

	public static List<Course> showTeacherCourses(Teacher teacher){
		
		DaoFactory factory = DaoFactory.getConcreateDAOfactory(TypeDAOfactory.JDBC);
		CourseDAO courseDAO = (CourseDAO) factory.getConcreteDAO(TypeDAO.COURSE);
		List<Course> teacherCourses = courseDAO.findCoursesByTeacher(teacher);
		
		return teacherCourses;
	}
	
}
