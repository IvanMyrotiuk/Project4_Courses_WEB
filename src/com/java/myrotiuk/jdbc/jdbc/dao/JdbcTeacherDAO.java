package com.java.myrotiuk.jdbc.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.java.myrotiuk.entities.dto.Teacher;
import com.java.myrotiuk.jdbc.dao.TeacherDAO;
import com.java.myrotiuk.resources.SQLManager;

/**
 * Class<code> JdbcTeacherDAO</code> Concrete implementation methods for working with table Teacher that is in BD 
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 16-01-2016
 */
public class JdbcTeacherDAO implements TeacherDAO {

	private static final Logger logger = Logger.getLogger(JdbcTeacherDAO.class);
	@Override
	public List<Teacher> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Teacher find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Teacher entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Teacher entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Teacher login(String userEmail, String userPassword) {
		
		String sql = SQLManager.getPropertyForTeacher("LOGIN");
		
		try(Connection conn = JdbcConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			
			stmt.setString(1, userEmail);
			stmt.setInt(2, userPassword.hashCode());
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				Teacher teacher = new Teacher(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getFloat("experience_years"), rs.getString("email"), rs.getInt("password_hash"));
				return teacher;
			}
			
		} catch (SQLException e) {
			logger.error("There is problem with SQL when teacher try to login "+e.getMessage(), e);
		}
		
		return null;
	}

	@Override
	public boolean existTeacher(String userEmail) {
		
		String sql = SQLManager.getPropertyForTeacher("EXIST_TEACHER");
		
		try(Connection conn = JdbcConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);){
			
			stmt.setString(1, userEmail);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				return true;
			}
			
		} catch (SQLException e) {
			logger.error("There is problem with SQL when we check existing teacher"+e.getMessage(), e);
		}
		
		return false;
	}

}
