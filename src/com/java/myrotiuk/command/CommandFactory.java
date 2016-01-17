package com.java.myrotiuk.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * Class<code> CommandFactory</code> gives specific commands to handle requests from users
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 16-01-2016
 */
public class CommandFactory {

	private Map<String, Command> commands = new HashMap<>();
	private static final Logger logger = Logger.getLogger(CommandFactory.class);
	
	private static final CommandFactory commandFactory = new CommandFactory(); 
	
	private CommandFactory(){
		
		commands.put("empty", new EmptyCommand());
		commands.put("login", new LoginCommand());
		commands.put("singup", new SingUpCommand());
		commands.put("dologin", new DoLoginCommand());
		commands.put("dosingup", new DoSingUpCommand());
		commands.put("logout", new LogOutCommand());
		
		commands.put("catalogOfCourses", new ShowCatalogOfCourses());
		commands.put("teacherCourses", new ShowTeacherCourses());
		commands.put("addCourse", new AddCourseCommnad());
		commands.put("studentCourses", new ShowStudentCoursesCommand());
		commands.put("doenrol", new DoEnrolCommand());
		commands.put("enrol", new EnrolCommand());
		commands.put("doQuitStudying", new DoQuitStudyingCommand());
		commands.put("quitStudying", new QuitStudyingCommand());
		commands.put("doAssignGrades", new DoAssignGradesCommand());
		commands.put("doAssignGradesForParticularCourse", new DoAssignGradesForParticularCourseCommand());
		commands.put("assignGradesForParticularCourse", new AssignGradesForParticularCourseCommand());
		commands.put("teacherRegisters", new ShowTeacherRegistersCommand());
		commands.put("graduatedCourses", new ShowGraduatedCoursesCommand());
	}
	
	public static CommandFactory getInstance(){
		return commandFactory;
	}
	
	public Command getCommand(HttpServletRequest request){
		
		String action = request.getParameter("action");
		
		Command command = commands.get(action);
		
		if(command == null){
			command = commands.get("empty");
			logger.warn("Empty command has been created, because there are no such command for this request");
		}
		
		return command;
	}
	
}
