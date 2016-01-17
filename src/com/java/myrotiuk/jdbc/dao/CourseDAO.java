/**
 * 
 */
package com.java.myrotiuk.jdbc.dao;

import java.util.List;

import com.java.myrotiuk.entities.dto.Course;
import com.java.myrotiuk.entities.dto.Teacher;

/**
 * interface<code> CourseDAO</code> Broaden functionality for working with table Course 
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 16-01-2016
 */
public interface CourseDAO extends BaseDAO<Course> {
	List<Course> findCoursesByTeacher(Teacher teacher);
	boolean exist(Course course);
	List<Course> getCourseToEnrolNotInclude(List<Course> registeredCourses);
}
