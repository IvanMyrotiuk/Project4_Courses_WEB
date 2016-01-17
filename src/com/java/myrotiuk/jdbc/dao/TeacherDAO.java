package com.java.myrotiuk.jdbc.dao;

import com.java.myrotiuk.entities.dto.Teacher;

/**
 * interface<code> StudentDAO</code> Broaden functionality for working with table Teacher
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 16-01-2016
 */
public interface TeacherDAO extends BaseDAO<Teacher> {
	Teacher login(String userEmail, String userPassword);
	boolean existTeacher(String userEmail);
}
