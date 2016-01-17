package com.java.myrotiuk.entities.dto;

/**
 * Class<code> Course</code> for creating an instance of Course 
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 16-01-2016
 */
public class Course extends BaseDTO {

	private Teacher teacher;
	private String name;
	private int places;
	private byte active;

	/**
	 * Constructor for creating object course with data that input teacher from form
	 * @param teacher
	 * @param name
	 * @param places
	 * @param active
	 */
	public Course(Teacher teacher, String name, int places) {
		super();
		this.teacher = teacher;
		this.name = name;
		this.places = places;
		//this.active = active;
	}
	
	/**
	 * Constructor for creating object course with data that that was retrieved by teacher from DB
	 * @param id
	 * @param teacher
	 * @param name
	 * @param places
	 * @param active
	 */
	public Course(int id, Teacher teacher, String name, int places, byte active) {
		super(id);
		this.teacher = teacher;
		this.name = name;
		this.places = places;
		this.active = active;
	}

	/**
	 * @return the teacher
	 */
	public Teacher getTeacher() {
		return teacher;
	}

	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the places
	 */
	public int getPlaces() {
		return places;
	}

	/**
	 * @param places the places to set
	 */
	public void setPlaces(int places) {
		this.places = places;
	}

	/**
	 * @return the active
	 */
	public byte getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(byte active) {
		this.active = active;
	}

}
