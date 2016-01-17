package com.java.myrotiuk.logic;

import java.util.LinkedList;
import java.util.List;

import com.java.myrotiuk.entities.dto.Course;
import com.java.myrotiuk.entities.dto.Register;
import com.java.myrotiuk.entities.dto.Student;
import com.java.myrotiuk.jdbc.dao.CourseDAO;
import com.java.myrotiuk.jdbc.dao.DaoFactory;
import com.java.myrotiuk.jdbc.dao.TypeDAOfactory;
import com.java.myrotiuk.jdbc.jdbc.dao.TypeDAO;

public class DoEnrolLogic {

	/**
	 * Method for getting courses to enroll for particular student if student has already
	 * enrolled to some courses they won't be display therefore student won't be able to register to that course
	 * if student hasn't registered to any of the courses to him will be displayed all available courses in another one
	 * select  
	 * @param student
	 * @return
	 */
	public List<Course> getCoursesToEnrolForParticularStudent(Student student){
		
		List<Course> registeredCourses = getRegisteredCourses(student);
		
		DaoFactory factory = DaoFactory.getConcreateDAOfactory(TypeDAOfactory.JDBC);
		CourseDAO courseDAO = (CourseDAO)factory.getConcreteDAO(TypeDAO.COURSE);
		
		List<Course> coursesToEnrol = null;
		if(!registeredCourses.isEmpty()){
			coursesToEnrol = courseDAO.getCourseToEnrolNotInclude(registeredCourses);
		}else{
			coursesToEnrol = courseDAO.getAll();
		}
		
		return coursesToEnrol;
	}
	
	
	
	public List<Course> getRegisteredCourses(Student student){
		
		List<Register> registers = ShowStudentCoursesLogic.showStudentCourses(student);
		
		List<Course> registeredCourses = new LinkedList<>();
		
		for(Register register: registers){
			registeredCourses.add(register.getCourse());
		}
		
		return registeredCourses;
	}
	
}
