package com.java.myrotiuk.logic;

import java.util.List;

import com.java.myrotiuk.entities.dto.Course;
import com.java.myrotiuk.jdbc.dao.CourseDAO;
import com.java.myrotiuk.jdbc.dao.DaoFactory;
import com.java.myrotiuk.jdbc.dao.TypeDAOfactory;
import com.java.myrotiuk.jdbc.jdbc.dao.TypeDAO;

public class ShowCatalogOfCoursesLogic {
	
	public static List<Course> showCourses(){//static?
		
		DaoFactory factory = DaoFactory.getConcreateDAOfactory(TypeDAOfactory.JDBC);
		CourseDAO courseDAO = (CourseDAO) factory.getConcreteDAO(TypeDAO.COURSE);
		List<Course> courses = courseDAO.getAll();
		return courses;
		
	}
	
}
