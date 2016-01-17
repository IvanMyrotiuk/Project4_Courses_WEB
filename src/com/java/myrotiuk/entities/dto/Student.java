package com.java.myrotiuk.entities.dto;

/**
 * Class<code> Student</code> for creating an instance of Student 
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 16-01-2016
 */
public class Student extends BaseDTO {

	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String email;
	private int passwordHash;
	
	/**
	 * Constructor with parameter for creating object student from form as student sing up
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param phoneNumber
	 * @param email
	 * @param passwordHash
	 */
	public Student(String firstName, String lastName, String address, String phoneNumber,
			String email, String passwordHash) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.passwordHash = passwordHash.hashCode();
	}

	/**
	 * Constructor with parameter for creating object student from data that was
	 * get from DB when student makes login
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param phoneNumber
	 * @param email
	 * @param passwordHash
	 */
	public Student(int id, String firstName, String lastName, String address,
			String phoneNumber, String email, int passwordHash) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
