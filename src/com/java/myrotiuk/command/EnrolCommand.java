package com.java.myrotiuk.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.java.myrotiuk.entities.dto.Student;
import com.java.myrotiuk.logic.EnrolLogic;
import com.java.myrotiuk.resources.MessageManager;
import com.java.myrotiuk.resources.PathManager;

public class EnrolCommand implements Command{

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		String [] coursesToEnrol = request.getParameterValues("courseToEnrol");
		if(coursesToEnrol != null){
			HttpSession session = request.getSession();
			Student student = (Student) session.getAttribute("student");
			
			List<Integer> idRegisters = EnrolLogic.enrolToCourses(coursesToEnrol, student);
			//System.out.println(idRegisters);
		}else{
			request.setAttribute("enrolMessage", MessageManager.getProperty("message.enrol.choose.empty"));
		}
		
		DoEnrolCommand doEnrolCommand = new DoEnrolCommand();
		doEnrolCommand.execute(request);
		
		return PathManager.ENROL_PAGE;
	}

}
