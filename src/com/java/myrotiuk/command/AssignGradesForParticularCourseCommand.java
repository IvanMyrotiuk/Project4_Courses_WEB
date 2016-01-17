package com.java.myrotiuk.command;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.java.myrotiuk.entities.dto.Register;
import com.java.myrotiuk.logic.AssignGradesForParticularCourseLogic;
import com.java.myrotiuk.resources.PathManager;

public class AssignGradesForParticularCourseCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
//		Integer number = (Integer)request.getAttribute("number");
//		System.out.println(number);
		
		Integer countRegisters = Integer.parseInt(request.getParameter("countRegisters"));
		//List<Register> registersToUpdate = new LinkedList<>();
		AssignGradesForParticularCourseLogic assignGradesForParticularCourseLogic = new AssignGradesForParticularCourseLogic();
		
		for(int i = 1; i <= countRegisters; i++){
			Integer registerId = Integer.parseInt(request.getParameter("registerId"+i));
			String testimonial = request.getParameter("testimonial"+i);
			Byte mark = null;
			try{
				mark = Byte.parseByte(request.getParameter("mark"+i));
			}catch(NumberFormatException e){
				//mark = null;
			}
			if(assignGradesForParticularCourseLogic.validateMark(mark)){
				Register register = new Register(registerId, mark, testimonial);
				assignGradesForParticularCourseLogic.assignGradesForParticularRegister(register);
			}
			//registersToUpdate.add(new Register(registerId, mark, testimonial));
		}
		
		DoAssignGradesCommand doAssignGradesCommand = new DoAssignGradesCommand();
		doAssignGradesCommand.execute(request);
		
		//if we failed to assign mark to some student
		if(assignGradesForParticularCourseLogic.getValidateMarkMessage() !=  null){
			DoAssignGradesForParticularCourseCommand doAssignGradesForParticularCourseCommand = 
					new DoAssignGradesForParticularCourseCommand();
			doAssignGradesForParticularCourseCommand.execute(request);
			request.setAttribute("assignGradesMessage", assignGradesForParticularCourseLogic.getValidateMarkMessage());
		}
		
		return PathManager.ASSIGN_GRADES;
	}

}
