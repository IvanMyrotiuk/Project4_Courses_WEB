package com.java.myrotiuk.logic;

import com.java.myrotiuk.entities.dto.Student;
import com.java.myrotiuk.jdbc.dao.DaoFactory;
import com.java.myrotiuk.jdbc.dao.RegisterDAO;
import com.java.myrotiuk.jdbc.dao.TypeDAOfactory;
import com.java.myrotiuk.jdbc.jdbc.dao.TypeDAO;

public class QuitStudyingLogic {
	
	public static void quitStuding(String[] coursesToQuit, Student student){
		
		Integer[] idCoursesToQuit = new Integer[coursesToQuit.length];
		
		for(int i = 0; i < coursesToQuit.length; i++){
			idCoursesToQuit[i] = Integer.parseInt(coursesToQuit[i]);
		}
		
		DaoFactory factory = DaoFactory.getConcreateDAOfactory(TypeDAOfactory.JDBC);
		RegisterDAO registerDAO = (RegisterDAO)factory.getConcreteDAO(TypeDAO.REGISTER);
		registerDAO.quitCourses(idCoursesToQuit, student);
		
	}
	
}
