package com.java.myrotiuk.jdbc.dao;

import com.java.myrotiuk.entities.dto.Student;

/**
 * interface<code> StudentDAO</code> Broaden functionality for working with table Student
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 16-01-2016
 */
public interface StudentDAO extends BaseDAO<Student> {
	Student login(String userEmail, String userPassword);
	boolean existStudent(String userEmail);
}
