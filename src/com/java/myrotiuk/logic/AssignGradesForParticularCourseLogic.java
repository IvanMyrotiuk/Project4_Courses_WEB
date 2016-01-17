package com.java.myrotiuk.logic;

import com.java.myrotiuk.entities.dto.Register;
import com.java.myrotiuk.jdbc.dao.DaoFactory;
import com.java.myrotiuk.jdbc.dao.RegisterDAO;
import com.java.myrotiuk.jdbc.dao.TypeDAOfactory;
import com.java.myrotiuk.jdbc.jdbc.dao.TypeDAO;
import com.java.myrotiuk.resources.MessageManager;

public class AssignGradesForParticularCourseLogic {
	
	private String validateMarkMessage = null;
	
	public void assignGradesForParticularRegister(Register register){
		
		DaoFactory factory = DaoFactory.getConcreateDAOfactory(TypeDAOfactory.JDBC);
		RegisterDAO registerDAO = (RegisterDAO) factory.getConcreteDAO(TypeDAO.REGISTER);
		registerDAO.update(register);
	}
	
	public boolean validateMark(Byte mark){
		
		if(mark == null){
			this.validateMarkMessage = MessageManager.getProperty("message.assign.mark.faild");
			return false;
		}
		
		if(mark < 1 || mark > 100){
			this.validateMarkMessage = MessageManager.getProperty("message.assign.mark.faild");
			return false;
		}
		return true;
	}
	
	public String getValidateMarkMessage(){
		return this.validateMarkMessage;
	}
	
}
