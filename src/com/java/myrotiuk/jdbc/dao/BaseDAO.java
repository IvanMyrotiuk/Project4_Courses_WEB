package com.java.myrotiuk.jdbc.dao;

import java.util.List;

/**
 * interface<code> BaseDAO</code> has all similar methods that's shared between all DAO 
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 16-01-2016
 */
public interface BaseDAO<T> {
	
	List<T> getAll();
	
	T find(int id);
	
	int insert(T entity);
	
	void update(T entity);
	
	void delete(int id);
	
}
