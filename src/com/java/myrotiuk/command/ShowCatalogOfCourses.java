package com.java.myrotiuk.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.java.myrotiuk.entities.dto.Course;
import com.java.myrotiuk.logic.ShowCatalogOfCoursesLogic;
import com.java.myrotiuk.resources.MessageManager;
import com.java.myrotiuk.resources.PathManager;

public class ShowCatalogOfCourses implements Command{

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		List<Course> courses = ShowCatalogOfCoursesLogic.showCourses();
		
		request.setAttribute("courses", courses);
		if(courses == null){
			request.setAttribute("catalogCoursesMessage", MessageManager.getProperty("message.catalog.courses.empty"));
		}
		
		request.setAttribute("command", "catalogOfCourses");
		
		return PathManager.CATALOG_OG_COURSES;
	}

}
