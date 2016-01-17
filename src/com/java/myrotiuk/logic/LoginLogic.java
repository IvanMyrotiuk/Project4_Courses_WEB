package com.java.myrotiuk.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.java.myrotiuk.entities.dto.Student;
import com.java.myrotiuk.entities.dto.Teacher;
import com.java.myrotiuk.jdbc.dao.DaoFactory;
import com.java.myrotiuk.jdbc.dao.StudentDAO;
import com.java.myrotiuk.jdbc.dao.TeacherDAO;
import com.java.myrotiuk.jdbc.dao.TypeDAOfactory;
import com.java.myrotiuk.jdbc.jdbc.dao.TypeDAO;
import com.java.myrotiuk.resources.MessageManager;

public class LoginLogic {

	private String loginMessage;
	private static final Pattern EMAIL_VALIDATION_INPUT = Pattern.compile("\\w+(\\.\\w+)*@\\w+(\\.\\w+)+");
	private static final Pattern PASSWORD_VALIDATION_INPUT = Pattern.compile("(\\w+\\s+\\w+)||(\\s+\\w+\\s+\\w+\\s+)");
	public boolean validate(String userEmail, String userPassword){
		
		if(userEmail == null || userEmail.equals("")){
			loginMessage = MessageManager.getProperty("message.empty.email");
			return false;
		}
		
		if(userPassword == null || userPassword.equals("")){
			loginMessage = MessageManager.getProperty("message.empty.password");
			return false;
		}
		
		if(!validateEmailInput(userEmail)){
			loginMessage = MessageManager.getProperty("message.wrong.email");
			return false;
			//return true;
		}
		
		if(userPassword.length() < 8){
			loginMessage = MessageManager.getProperty("message.password.length");
			return false;
			//return true;
		}
		
		if(validatePasswordInput(userPassword)){
			loginMessage = MessageManager.getProperty("message.password.space");
			return false;
		}
		
		return true;
	}
	
	private boolean validateEmailInput(String userEmail){
		Matcher matcherLogin = EMAIL_VALIDATION_INPUT.matcher(userEmail);
		return matcherLogin.matches();
	}
	
	private boolean validatePasswordInput(String userPassword){
		Matcher matcherPassword = PASSWORD_VALIDATION_INPUT.matcher(userPassword);
		return matcherPassword.matches();
	}
	
	public String getLoginMessage(){
		return this.loginMessage;
	}
	
	public Student loginStudent(String userEmail, String userPassword){
		//can we carry out factory?
		DaoFactory factory = DaoFactory.getConcreateDAOfactory(TypeDAOfactory.JDBC);
		StudentDAO studentDAO = (StudentDAO) factory.getConcreteDAO(TypeDAO.STUDENT);
		Student student = studentDAO.login(userEmail, userPassword);
		return student;
	}
	
	public Teacher loginTeacher(String userEmail, String userPassword){
		DaoFactory factory = DaoFactory.getConcreateDAOfactory(TypeDAOfactory.JDBC);
		TeacherDAO teacherDAO = (TeacherDAO) factory.getConcreteDAO(TypeDAO.TEACHER);
		Teacher teacher = teacherDAO.login(userEmail, userPassword);
		return teacher;
	}
}
