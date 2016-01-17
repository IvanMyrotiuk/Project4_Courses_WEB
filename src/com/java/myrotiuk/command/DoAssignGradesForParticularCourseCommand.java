package com.java.myrotiuk.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.java.myrotiuk.entities.dto.Register;
import com.java.myrotiuk.logic.DoAssignGradesForParticularCourseLogic;
import com.java.myrotiuk.resources.MessageManager;
import com.java.myrotiuk.resources.PathManager;

public class DoAssignGradesForParticularCourseCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		//again with the same id will show courses that was failed assigning grades
		int idCourseToAssignGrades = Integer.parseInt(request.getParameter("courseToAssignGrades"));
		
		List<Register> registers = DoAssignGradesForParticularCourseLogic.getStudentsFromThisCourse(idCourseToAssignGrades);
		
		
		if(registers.isEmpty()){
			request.setAttribute("assignGradesMessage", MessageManager.getProperty("message.assign.grade.no.student"));
		}
		
		String nameOfCourse = null;
		if(!registers.isEmpty()){
			nameOfCourse = registers.get(0).getCourse().getName();
		}
		
		request.setAttribute("registers", registers);
		request.setAttribute("nameOfCourse", nameOfCourse);
		//if we failed to assign mark to some student we again will have the same list of register that was failed assigning
		request.setAttribute("courseToAssignGrades", idCourseToAssignGrades);
		
		DoAssignGradesCommand doAssignGradesCommand = new DoAssignGradesCommand();
		doAssignGradesCommand.execute(request);
		//for i18n
		//request.setAttribute("command", "doAssignGradesForParticularCourse");
		
		return PathManager.ASSIGN_GRADES;
	}

}
