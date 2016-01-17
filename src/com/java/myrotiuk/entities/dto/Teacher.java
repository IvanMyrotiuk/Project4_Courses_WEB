package com.java.myrotiuk.entities.dto;

/**
 * Class<code> Teacher</code> for creating an instance of Teacher 
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 16-01-2016
 */
public class Teacher extends BaseDTO {

	private String firstName;
	private String lastName;
	private float experienceYears;
	private String email;
	private int passwordHash;
	/**
	 * Constructor with parameter for creating object teacher from form as teacher ask administrator to do sing up
	 * @param firstName
	 * @param lastName
	 * @param experienceYears
	 * @param email
	 * @param passwordHash
	 */
	public Teacher(String firstName, String lastName, float experienceYears, String email,
			int passwordHash) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.experienceYears = experienceYears;
		this.email = email;
		this.passwordHash = passwordHash;
	}
	
	/**
	 * Constructor with parameter for creating object teacher from data that was
	 * get from DB when teacher makes login
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param experienceYears
	 * @param email
	 * @param passwordHash
	 */
	public Teacher(int id, String firstName, String lastName, float experienceYears,
			String email, int passwordHash) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
		this.experienceYears = experienceYears;
		this.email = email;
		this.passwordHash = passwordHash;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the experienceYears
	 */
	public float getExperienceYears() {
		return experienceYears;
	}

	/**
	 * @param experienceYears the experienceYears to set
	 */
	public void setExperienceYears(float experienceYears) {
		this.experienceYears = experienceYears;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the passwordHash
	 */
	public int getPasswordHash() {
		return passwordHash;
	}

	/**
	 * @param passwordHash the passwordHash to set
	 */
	public void setPasswordHash(int passwordHash) {
		this.passwordHash = passwordHash;
	}
}
