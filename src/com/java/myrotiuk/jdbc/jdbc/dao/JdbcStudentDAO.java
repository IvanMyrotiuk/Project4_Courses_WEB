/**
 * 
 */
package com.java.myrotiuk.jdbc.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.java.myrotiuk.entities.dto.Student;
import com.java.myrotiuk.jdbc.dao.StudentDAO;
import com.java.myrotiuk.resources.SQLManager;
import com.mysql.jdbc.Statement;

/**
 * Class<code> JdbcStudentDAO</code> Concrete implementation methods for working with table Student that is in BD 
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 16-01-2016
 */
public class JdbcStudentDAO implements StudentDAO {

	private static final Logger logger = Logger.getLogger(JdbcStudentDAO.class);
	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Student student) {
		
		String sql = SQLManager.getPropertyForStudent("INSERT");
		
		int generatedId = 0;
		
		try(Connection conn = JdbcConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);){
			
			stmt.setString(1, student.getFirstName());
			stmt.setString(2, student.getLastName());
			stmt.setString(3, student.getAddress());
			stmt.setString(4, student.getPhoneNumber());
			stmt.setString(5, student.getEmail());
			stmt.setInt(6, student.getPasswordHash());
			
			stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()){
				generatedId = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			logger.error("There is problem with sql"+e.getMessage(), e);
		}
		
		return generatedId;
	}

	@Override
	public void update(Student entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Student login(String userEmail, String userPassword) {
		
		String sql = SQLManager.getPropertyForStudent("LOGIN");
		
		try(Connection conn = JdbcConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			
			stmt.setString(1, userEmail);
			stmt.setInt(2, userPassword.hashCode());
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				Student student = new Student(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("address"), rs.getString("phone_number"),rs.getString("email"), rs.getInt("password_hash"));
				return student;
			}
			
		} catch (SQLException e) {
			logger.error("There is problem with SQL when student try to login"+e.getMessage(), e);
		}
		
		return null;
	}

	@Override
	public boolean existStudent(String userEmail) {
		
//		String sql = "select email from student where email = ?"
//				+ " union select email from teacher where email = ?";
		
		String sql = SQLManager.getPropertyForStudent("EXIST_STUDENT");
				
		try(Connection conn = JdbcConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);){
			
			stmt.setString(1, userEmail);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				return true;
			}
			
		} catch (SQLException e) {
			logger.error("There is problem with SQL when we check existing user"+e.getMessage(), e);
		}
		
		return false;
	}

}
