package com.java.myrotiuk.entities.dto;

/**
 * abstract Class<code> BaseDTO</code> that is extended by all concrete model  
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 16-01-2016
 */
public abstract class BaseDTO {
	
	private int id;
	
	public BaseDTO(){}
	
	public BaseDTO(int id){
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
}
