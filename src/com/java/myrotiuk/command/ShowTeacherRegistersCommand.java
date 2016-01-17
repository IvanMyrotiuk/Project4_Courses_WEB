package com.java.myrotiuk.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.java.myrotiuk.entities.dto.Register;
import com.java.myrotiuk.entities.dto.Teacher;
import com.java.myrotiuk.logic.ShowTeacherRegistersLogic;
import com.java.myrotiuk.resources.MessageManager;
import com.java.myrotiuk.resources.PathManager;

public class ShowTeacherRegistersCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		
		List<Register> teacherRegisters = ShowTeacherRegistersLogic.getTeacherRegisters(teacher);
		
		if(teacherRegisters.isEmpty()){
			request.setAttribute("teacherRegistersMessage", MessageManager.getProperty("message.teacher.register.empty"));
		}
		
		request.setAttribute("teacherRegisters", teacherRegisters);
		request.setAttribute("command", "teacherRegisters");
		
		return PathManager.TEACHER_REGISTERS;
	}

}
