package com.java.myrotiuk.jdbc.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.java.myrotiuk.entities.dto.Course;
import com.java.myrotiuk.entities.dto.Teacher;
import com.java.myrotiuk.jdbc.dao.CourseDAO;
import com.java.myrotiuk.resources.SQLManager;

/**
 * Class<code> JdbcCourseDAO</code> Concrete implementation methods for working with table Course that is in BD 
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 16-01-2016
 */
public class JdbcCourseDAO implements CourseDAO {
	private static final Logger logger = Logger.getLogger(JdbcCourseDAO.class);
	@Override
	public List<Course> getAll() {
		
		List<Course> courses = new LinkedList<>();
		
		String sql = SQLManager.getPropertyForCourse("GET_ALL");

		try(Connection conn = JdbcConnection.getConnection();
				Statement stmt = conn.createStatement();){
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Teacher teacher = new Teacher(rs.getInt("teacher.id"), rs.getString("first_name"), rs.getString("last_name"), 
						rs.getFloat("experience_years"), rs.getString("email"), rs.getInt("password_hash"));
				courses.add(new Course(rs.getInt("course.id"), teacher, rs.getString("name_course"), rs.getInt("places"), rs.getByte("active")));
			}
			
		} catch (SQLException e) {
			logger.error("There is problem with sql When we try to get all courses "+ e.getMessage(),e);
		}
		
		if(courses.isEmpty()){
			return null;
		}
		return courses;
	}

	@Override
	public Course find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Course course) {
		
		String sql = SQLManager.getPropertyForCourse("INSERT");
		
		int generatedId = 0;
		
		try(Connection conn = JdbcConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			
			stmt.setInt(1, course.getTeacher().getId());
			stmt.setString(2, course.getName());
			stmt.setInt(3, course.getPlaces());
			
			stmt.executeUpdate();
			
			ResultSet rs =  stmt.getGeneratedKeys();
			
			if(rs.next()){
				generatedId = rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			logger.error("There is problem with sql when we try to add course "+e.getMessage(), e);
		}
		
		return generatedId;
	}

	@Override
	public void update(Course entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Course> findCoursesByTeacher(Teacher teacher) {
		
		String sql = SQLManager.getPropertyForCourse("FIND_COURSES_BY_TEACHER");
		
		List<Course> teacherCourses = new LinkedList<>();
		
		try(Connection conn = JdbcConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);){
			
			stmt.setInt(1, teacher.getId());
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				teacherCourses.add(new Course(rs.getInt("id"), teacher, rs.getString("name_course"), rs.getInt("places"), rs.getByte("active")));
			}
			
		} catch (SQLException e) {
			logger.error("There is problem with sql when we take courses that teacher is teaching "+ e.getMessage(), e);
		}
		
		return teacherCourses;
	}

	@Override
	public boolean exist(Course course) {
		
		String sql = SQLManager.getPropertyForCourse("EXIST");
		
		try(Connection conn = JdbcConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql); ){
			
			stmt.setString(1, course.getName());
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				return true;
			}
			
		} catch (SQLException e) {
			logger.error("There is problem with sql when we try to check existing course "+ e.getMessage(), e);
		}
		
		return false;
	}

	@Override
	public List<Course> getCourseToEnrolNotInclude(List<Course> registeredCourses) {
		
		String sql = SQLManager.getPropertyForCourse("GET_COURSE_TO_ENROL_NOT_INCLUDE");
		StringBuilder buildSQL = new StringBuilder(sql);
		if(registeredCourses.size() > 1){
			for(int i = 1; i < registeredCourses.size(); i++ ){
				buildSQL.append(",?");
			}
		}
		buildSQL.append(")");
		
		sql = buildSQL.toString();
		//System.out.println(sql);
		List<Course> coursesForEnrolling = new LinkedList<>();
		
		try(Connection conn = JdbcConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);){
			
			for(int i = 0; i < registeredCourses.size(); i++ ){
				stmt.setInt(i+1, registeredCourses.get(i).getId());
			}
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Teacher teacher = new Teacher(rs.getInt("teacher.id"), rs.getString("first_name"), rs.getString("last_name"), 
						rs.getFloat("experience_years"), rs.getString("email"), rs.getInt("password_hash"));
				coursesForEnrolling.add(new Course(rs.getInt("course.id"), teacher, rs.getString("name_course"), rs.getInt("places"), rs.getByte("active")));
			}
			
		} catch (SQLException e) {
			logger.error("There is problem with sql when we try to get courses for enrolling " + e.getMessage(), e);
		}

		return coursesForEnrolling;
	}

}
