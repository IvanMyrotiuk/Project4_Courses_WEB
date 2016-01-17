package com.java.myrotiuk.logic;

import java.util.List;

import com.java.myrotiuk.entities.dto.Register;
import com.java.myrotiuk.entities.dto.Student;
import com.java.myrotiuk.jdbc.dao.DaoFactory;
import com.java.myrotiuk.jdbc.dao.RegisterDAO;
import com.java.myrotiuk.jdbc.dao.TypeDAOfactory;
import com.java.myrotiuk.jdbc.jdbc.dao.TypeDAO;

public class ShowGraduatedCoursesLogic {
	
	public static List<Register> getGraduatedCourses(Student student){
		
		DaoFactory factory = DaoFactory.getConcreateDAOfactory(TypeDAOfactory.JDBC);
		RegisterDAO registerDAO = (RegisterDAO)factory.getConcreteDAO(TypeDAO.REGISTER);
		List<Register> graduatedRegisters = registerDAO.getGraduatedRegisters(student);
		return graduatedRegisters;
	}
}
