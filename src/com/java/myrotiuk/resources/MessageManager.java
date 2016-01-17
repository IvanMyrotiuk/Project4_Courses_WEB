package com.java.myrotiuk.resources;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageManager {
	
	private static ResourceBundle resourceBundle =
			ResourceBundle.getBundle("com.java.myrotiuk.properties.message");
	
	private MessageManager(){}
	
	public static void setBundle(String language){
		Locale locale = new Locale(language);
		resourceBundle = ResourceBundle.getBundle("com.java.myrotiuk.properties.message",locale);
	}
	
	public static String getProperty(String key){
		return resourceBundle.getString(key);
	}
	
}
