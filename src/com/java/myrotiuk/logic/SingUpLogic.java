package com.java.myrotiuk.logic;

import com.java.myrotiuk.entities.dto.Student;
import com.java.myrotiuk.jdbc.dao.DaoFactory;
import com.java.myrotiuk.jdbc.dao.StudentDAO;
import com.java.myrotiuk.jdbc.dao.TeacherDAO;
import com.java.myrotiuk.jdbc.dao.TypeDAOfactory;
import com.java.myrotiuk.jdbc.jdbc.dao.TypeDAO;
import com.java.myrotiuk.resources.MessageManager;

public class SingUpLogic {

	private String singUpMessage;
	
	public boolean validate(String userFirstName, String userLastName, String userAddress, String userPhone,
			String userEmail, String userPassword, String userCheckPassword){
		
		if(userFirstName == null || userFirstName.equals("")){
			singUpMessage = MessageManager.getProperty("message.empty.fname");
			return false;
		}
		if(userLastName == null || userLastName.equals("")){
			singUpMessage = MessageManager.getProperty("message.empty.lname");
			return false;
		}
		if(userAddress == null || userAddress.equals("")){
			singUpMessage = MessageManager.getProperty("message.empty.address");
			return false;
		}
		if(userPhone == null || userPhone.equals("")){
			singUpMessage = MessageManager.getProperty("message.empty.phonenumber");
			return false;
		}
		
		LoginLogic loginLogic = new LoginLogic();
		if(!loginLogic.validate(userEmail, userPassword)){
			singUpMessage = loginLogic.getLoginMessage();
			return false;
		}
		
		if(!userPassword.equals(userCheckPassword)){
			singUpMessage = MessageManager.getProperty("message.different.passwords");
			return false;
		}
		
		return true;
	}
	
	public boolean existUser(String userEmail){
		
		DaoFactory factory = DaoFactory.getConcreateDAOfactory(TypeDAOfactory.JDBC);
		StudentDAO studentDAO = (StudentDAO) factory.getConcreteDAO(TypeDAO.STUDENT);
		TeacherDAO teacherDAO = (TeacherDAO) factory.getConcreteDAO(TypeDAO.TEACHER);
		
		if(studentDAO.existStudent(userEmail) || teacherDAO.existTeacher(userEmail)){
			return true;
		}
		return false;
	}

	public String getSingUpMessage(){
		return this.singUpMessage;
	}
	
	public void singUp(Student student){
		
		DaoFactory factory = DaoFactory.getConcreateDAOfactory(TypeDAOfactory.JDBC);
		StudentDAO studentDAO = (StudentDAO) factory.getConcreteDAO(TypeDAO.STUDENT);
		int generatedId = studentDAO.insert(student);
		student.setId(generatedId);
		//return student;
	}
	
}
