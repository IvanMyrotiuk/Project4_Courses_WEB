package com.java.myrotiuk.logic;

import java.util.List;

import com.java.myrotiuk.entities.dto.Student;
import com.java.myrotiuk.jdbc.dao.DaoFactory;
import com.java.myrotiuk.jdbc.dao.RegisterDAO;
import com.java.myrotiuk.jdbc.dao.TypeDAOfactory;
import com.java.myrotiuk.jdbc.jdbc.dao.TypeDAO;

public class EnrolLogic {

	public static List<Integer> enrolToCourses(String[] coursesToEnrol, Student student){
		
		Integer[] idCourses = new Integer[coursesToEnrol.length];
		
		for(int i = 0; i < idCourses.length; i++){
			idCourses[i] = Integer.parseInt(coursesToEnrol[i]);
		}
		
		DaoFactory factory = DaoFactory.getConcreateDAOfactory(TypeDAOfactory.JDBC);
		RegisterDAO registerDAO = (RegisterDAO) factory.getConcreteDAO(TypeDAO.REGISTER);
		List<Integer> idRegisters = registerDAO.addRegisteredStudentToCourses(idCourses, student);
		return idRegisters;
	}
	
}
