package com.java.myrotiuk.resources;

import java.util.ResourceBundle;

public final class SQLManager {

	private static final ResourceBundle studentBundle = ResourceBundle.getBundle("com.java.myrotiuk.sql.sqlForStudent");
	private static final ResourceBundle teacherBundle = ResourceBundle.getBundle("com.java.myrotiuk.sql.sqlForTeacher");
	private static final ResourceBundle courseBundle = ResourceBundle.getBundle("com.java.myrotiuk.sql.sqlForCourse");
	private static final ResourceBundle registerBundle = ResourceBundle.getBundle("com.java.myrotiuk.sql.sqlForRegister");

	private SQLManager() {
	}

	public static String getPropertyForStudent(String key){
		return studentBundle.getString(key);
	}

	public static String getPropertyForTeacher(String key){
		return teacherBundle.getString(key);
	}
	
	public static String getPropertyForCourse(String key){
		return courseBundle.getString(key);
	}

	public static String getPropertyForRegister(String key){
		return registerBundle.getString(key);
	}

}
