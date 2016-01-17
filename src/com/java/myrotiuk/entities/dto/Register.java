package com.java.myrotiuk.entities.dto;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Class<code> Register</code> for creating an instance of Register 
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 16-01-2016
 */
public class Register extends BaseDTO {

	private Student student;
	private Course course;
	private Timestamp registeredAt = new Timestamp(System.currentTimeMillis());
	private byte mark;
	private String testimonial;
	private Timestamp graduatedAt = null;
	private byte active = 1;//studying will changed to 0 when student graduatedAt
	
	
	/**
	 * Constructor for making registration by student 
	 * if he is registered than he is studying and mark '0' 
	 * as mark will be assigned by teacher after graduation   
	 * @param student
	 * @param course
	 */
	public Register(Student student, Course course) {
		super();
		this.student = student;
		this.course = course;
	}


	/**
	 * Constructor for register when student graduatedAt and he has mark assigned by teacher
	 * @param id
	 * @param student
	 * @param course
	 * @param registeredAt
	 * @param mark
	 * @param graduatedAt
	 * @param active
	 */
	public Register(int id, Student student, Course course, Timestamp registeredAt, byte mark, String testimonial, Timestamp graduatedAt,
			byte active) {
		super(id);
		this.student = student;
		this.course = course;
		this.registeredAt = registeredAt;
		this.mark = mark;
		this.testimonial = testimonial;
		this.graduatedAt = graduatedAt;
		this.active = active;
	}

	/**
	 * constructor for student that already graduated from a course
	 * @param id
	 * @param mark
	 * @param testimonial
	 * @param graduatedAt
	 * @param active
	 */
	public Register(int id, byte mark, String testimonial){
		super(id);
		this.mark = mark;
		this.testimonial = testimonial;
		this.graduatedAt = new Timestamp(System.currentTimeMillis());
		this.active = 0;
	}
	

	/**
	 * @return the graduatedAt
	 */
	public Timestamp getGraduatedAt() {
		return graduatedAt;
	}


	/**
	 * @param graduatedAt the graduatedAt to set
	 */
	public void setGraduatedAt(Timestamp graduatedAt) {
		this.graduatedAt = graduatedAt;
	}


	/**
	 * @return the testimonial
	 */
	public String getTestimonial() {
		return testimonial;
	}


	/**
	 * @param testimonial the testimonial to set
	 */
	public void setTestimonial(String testimonial) {
		this.testimonial = testimonial;
	}


	//28.12.2015 2:19:36
	public String getRegisteredAtDateTime(){
		Date registeredAtDateTime = new Date(registeredAt.getTime());
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.getDefault());
		String dateTime = df.format(registeredAtDateTime);
		return dateTime;
	}
	
	//28.12.2015
	public String getGraduatedAtDateTime() {
		if(graduatedAt != null){
			Date graduatedAtDay = new Date(graduatedAt.getTime());
			DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.getDefault());
			String day = df.format(graduatedAtDay);
			return day;
		}else{
			return null;
		}
	}
	
	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}


	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}


	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}


	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}


	/**
	 * @return the registeredAt
	 */
	public Timestamp getRegisteredAt() {
		return registeredAt;
	}


	/**
	 * @param registeredAt the registeredAt to set
	 */
	public void setRegisteredAt(Timestamp registeredAt) {
		this.registeredAt = registeredAt;
	}


	/**
	 * @return the mark
	 */
	public byte getMark() {
		return mark;
	}


	/**
	 * @param mark the mark to set
	 */
	public void setMark(byte mark) {
		this.mark = mark;
	}


	/**
	 * @param graduatedAt the graduatedAt to set
	 */
	public void setGraduated(Timestamp graduatedAt) {
		this.graduatedAt = graduatedAt;
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
