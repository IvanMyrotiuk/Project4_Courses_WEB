package com.java.myrotiuk.logic;

import com.java.myrotiuk.entities.dto.Course;
import com.java.myrotiuk.jdbc.dao.CourseDAO;
import com.java.myrotiuk.jdbc.dao.DaoFactory;
import com.java.myrotiuk.jdbc.dao.TypeDAOfactory;
import com.java.myrotiuk.jdbc.jdbc.dao.TypeDAO;
import com.java.myrotiuk.resources.MessageManager;

public class AddCourseLogic {

	private String validationAddCoursMessage;
	
	public void addCourse(Course course){
		
		DaoFactory factory = DaoFactory.getConcreateDAOfactory(TypeDAOfactory.JDBC);
		CourseDAO courseDAO = (CourseDAO) factory.getConcreteDAO(TypeDAO.COURSE);
		courseDAO.insert(course);
	}
	
	public boolean validateCourse(Course course){
		
		if(course.getName() == null || course.getName().equals("")){
			validationAddCoursMessage = MessageManager.getProperty("message.empty.course");
			return false;
		}
		
		if(exist(course)){
			validationAddCoursMessage = MessageManager.getProperty("message.course.exist");
			return false;
		}
		
		return true;
	}
	
	public String getValidationMessage(){
		return this.validationAddCoursMessage;
	}
	
	private boolean exist(Course course){
		
		DaoFactory factory = DaoFactory.getConcreateDAOfactory(TypeDAOfactory.JDBC);
		CourseDAO courseDAO = (CourseDAO) factory.getConcreteDAO(TypeDAO.COURSE);
		return courseDAO.exist(course);
		
	}
	
}
