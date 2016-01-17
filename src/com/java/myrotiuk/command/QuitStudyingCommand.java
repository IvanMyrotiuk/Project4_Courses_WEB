package com.java.myrotiuk.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.java.myrotiuk.entities.dto.Student;
import com.java.myrotiuk.logic.QuitStudyingLogic;
import com.java.myrotiuk.resources.MessageManager;
import com.java.myrotiuk.resources.PathManager;

public class QuitStudyingCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {

		String[] coursesToQuit = request.getParameterValues("courseToQuit");

		if (coursesToQuit != null) {
			HttpSession session = request.getSession();
			Student student = (Student) session.getAttribute("student");

			QuitStudyingLogic.quitStuding(coursesToQuit, student);
		}else{
			request.setAttribute("quitStudyingMessage", MessageManager.getProperty("message.quit.choose.empty"));
		}
		
		
		DoQuitStudyingCommand doQuitStudyingCommand = new DoQuitStudyingCommand();
		doQuitStudyingCommand.execute(request);

		return PathManager.QUIT_STUDYING;
	}

}
