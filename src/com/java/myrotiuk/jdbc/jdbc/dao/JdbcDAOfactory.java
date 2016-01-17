/**
 * 
 */
package com.java.myrotiuk.jdbc.jdbc.dao;

import com.java.myrotiuk.entities.dto.BaseDTO;
import com.java.myrotiuk.jdbc.dao.BaseDAO;
import com.java.myrotiuk.jdbc.dao.DaoFactory;

/**
 * Class<code> JdbcDAOfactory</code> Concrete implementation of JDBC DAO factory that will create specific DAO that is needed for 
 * working with concrete table
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 16-01-2016
 */
public class JdbcDAOfactory extends DaoFactory {
	
	public BaseDAO<? extends BaseDTO> getConcreteDAO(TypeDAO typeDAO){
		
		switch (typeDAO) {
		
			case STUDENT: return new JdbcStudentDAO();
		
			case TEACHER: return new JdbcTeacherDAO();
			
			case COURSE: return new JdbcCourseDAO();
			
			case REGISTER: return  new JdbcRegisterDAO();
			
			default: throw new IllegalArgumentException("Inappropriate DAO");
		}
	}
	
}
