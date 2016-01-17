/**
 * 
 */
package com.java.myrotiuk.jdbc.dao;

import java.util.List;

import com.java.myrotiuk.entities.dto.Register;
import com.java.myrotiuk.entities.dto.Student;
import com.java.myrotiuk.entities.dto.Teacher;

/**
 * interface<code> RegisterDAO</code> Broaden functionality for working with table Register
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 16-01-2016
 */
public interface RegisterDAO extends BaseDAO<Register> {
	List<Register> findRegisteredCoursesByStudent(Student student);
	List<Integer> addRegisteredStudentToCourses(Integer[] idCourses, Student student);
	void quitCourses(Integer[] idCoursesToQuit, Student student);
	List<Register> getRegistersForParticularCourse(int idCourseToAssignGrades);
	List<Register> getAllGraduatedStudebtForParticularTeacher(Teacher teacher);
	List<Register> getGraduatedRegisters(Student student);
	boolean existRegister(Student student, int idCourse);
}
