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
import com.java.myrotiuk.entities.dto.Register;
import com.java.myrotiuk.entities.dto.Student;
import com.java.myrotiuk.entities.dto.Teacher;
import com.java.myrotiuk.jdbc.dao.RegisterDAO;
import com.java.myrotiuk.resources.SQLManager;

/**
 * Class<code> JdbcRegisterDAO</code> Concrete implementation methods for working with table Register that is in BD 
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 16-01-2016
 */
public class JdbcRegisterDAO implements RegisterDAO {

	private static final Logger logger = Logger.getLogger(JdbcRegisterDAO.class);
	
	@Override
	public List<Register> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Register find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Register entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Register register) {
		
		String sql = SQLManager.getPropertyForRegister("UPDATE");

		try(Connection conn = JdbcConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);){
			
			stmt.setInt(1, register.getMark());
			stmt.setString(2, register.getTestimonial());
			stmt.setTimestamp(3, register.getGraduatedAt());
			stmt.setByte(4, register.getActive());
			stmt.setInt(5, register.getId());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			logger.error("There is problem with sql when we try to update register and assign the mark" + e.getMessage(), e);
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Register> findRegisteredCoursesByStudent(Student student) {

		String sql = SQLManager.getPropertyForRegister("FIND_REGISTERED_COURSES_BY_STUDENT");
		List<Register> studentRegisters = new LinkedList<>();

		try (Connection conn = JdbcConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setInt(1, student.getId());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Teacher teacher = new Teacher(rs.getInt("teacher.id"), rs.getString("teacher.first_name"),
						rs.getString("teacher.last_name"), rs.getFloat("teacher.experience_years"), rs.getString("teacher.email"),
						rs.getInt("teacher.password_hash"));
				Course course = new Course(rs.getInt("course.id"), teacher, rs.getString("course.name_course"),
						rs.getInt("course.places"), rs.getByte("course.active"));
				studentRegisters.add(new Register(rs.getInt("register.id"), student, course,
						rs.getTimestamp("register.registered"), rs.getByte("register.mark"), rs.getString("register.testimonial"),
						rs.getTimestamp("register.graduated"), rs.getByte("register.active")));
			}

		} catch (SQLException e) {
			logger.error("There is problem with sql when we try to find student's courses " + e.getMessage(), e);
		}

		return studentRegisters;
	}

	@Override
	public List<Integer> addRegisteredStudentToCourses(Integer[] idCourses, Student student) {

		String sql = SQLManager.getPropertyForRegister("ADD_REGISTERED_STUDENT_TO_COURSES");
		
		if(existRegister(student, idCourses[0])){//if we make the same request by refresh page we do not want send to enroll to the same course again
			return null;
		}
		
		if (idCourses.length > 1) {
			StringBuilder buildSQL = new StringBuilder(sql);
			
			for(int i = 1; i < idCourses.length; i++){
				buildSQL.append(", (?,?)");
			}

			sql = buildSQL.toString();
		}
		//System.out.println(sql);

		List<Integer> idRegisters = new LinkedList<>();

		try (Connection conn = JdbcConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			for (int i = 0, j = 1; i < idCourses.length; i++, j += 2) {
				stmt.setInt(j, student.getId());
				stmt.setInt(j + 1, idCourses[i]);
			}

			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			while (rs.next()) {
				idRegisters.add(rs.getInt(1));
			}

		} catch (SQLException e) {
			logger.error("There is problem with sql when we try to add register " + e.getMessage(), e);
		}

		return idRegisters;
	}

	@Override
	public void quitCourses(Integer[] idCoursesToQuit, Student student) {
		
		String sql = SQLManager.getPropertyForRegister("QUIT_COURSES");
		
		StringBuilder builSQL = new StringBuilder(sql);
		if(idCoursesToQuit.length > 1){
			for(int i = 1; i < idCoursesToQuit.length; i++){
				builSQL.append(",?");
			}
		}
		builSQL.append(")");
		sql = builSQL.toString();
		
		try(Connection conn = JdbcConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);){
			
			stmt.setInt(1, student.getId());
			
			for(int i = 0, j = 2; i < idCoursesToQuit.length ; i++, j++ ){
				stmt.setInt(j, idCoursesToQuit[i]);
			}
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			logger.error("There is problem with sql when we try to quit from a courses "+ e.getMessage(), e);
		}
		
	}

	@Override
	public List<Register> getRegistersForParticularCourse(int idCourseToAssignGrades) {
		
		List<Register> registers = new LinkedList<>();
		
		String sql = SQLManager.getPropertyForRegister("GET_REGISTERS_FOR_PARTICULAR_COURSE");
		
		try(Connection conn = JdbcConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);){
			
			stmt.setInt(1, idCourseToAssignGrades);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Teacher teacher = new Teacher(rs.getInt("teacher.id"), rs.getString("teacher.first_name"),
						rs.getString("teacher.last_name"), rs.getFloat("teacher.experience_years"), rs.getString("teacher.email"),
						rs.getInt("teacher.password_hash"));
				Student student = new Student(rs.getInt("student.id"), rs.getString("student.first_name"),
						rs.getString("student.last_name"), rs.getString("student.address"), rs.getString("student.phone_number"), rs.getString("student.email"),
						rs.getInt("student.password_hash"));
				Course course = new Course(rs.getInt("course.id"), teacher, rs.getString("course.name_course"),
						rs.getInt("course.places"), rs.getByte("course.active"));
				registers.add(new Register(rs.getInt("register.id"), student, course,
						rs.getTimestamp("register.registered"), rs.getByte("register.mark"), rs.getString("register.testimonial"),
						rs.getTimestamp("register.graduated"), rs.getByte("register.active")));
				
			}
			
		} catch (SQLException e) {
			logger.error("There is problem with sql when we try to get all students for particular Course "+ e.getMessage(), e);
		}
		
		return registers;
	}

	@Override
	public List<Register> getAllGraduatedStudebtForParticularTeacher(Teacher teacher) {
		
		String sql = SQLManager.getPropertyForRegister("GET_ALL_GRADUATED_STUDENT_FOR_PARTICULAR_TEACHER");
		
		List<Register> teacherRegisters = new LinkedList<>();
		
		try(Connection conn = JdbcConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);){
			
			stmt.setInt(1, teacher.getId());
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Student student = new Student(rs.getInt("student.id"), rs.getString("student.first_name"),
						rs.getString("student.last_name"), rs.getString("student.address"), rs.getString("student.phone_number"), rs.getString("student.email"),
						rs.getInt("student.password_hash"));
				Course course = new Course(rs.getInt("course.id"), teacher, rs.getString("course.name_course"),
						rs.getInt("course.places"), rs.getByte("course.active"));
				teacherRegisters.add(new Register(rs.getInt("register.id"), student, course,
						rs.getTimestamp("register.registered"), rs.getByte("register.mark"), rs.getString("register.testimonial"),
						rs.getTimestamp("register.graduated"), rs.getByte("register.active")));
			}
			
		} catch (SQLException e) {
			logger.error("There is problem with sql when we try to get all students that graduated "+ e.getMessage(), e);
		}
		
		return teacherRegisters;
	}

	@Override
	public List<Register> getGraduatedRegisters(Student student) {
		
		String sql = SQLManager.getPropertyForRegister("GET_GRADUATED_REGISTERS");
		
		List<Register> graduatedCourses = new LinkedList<>();
		
		try(Connection conn = JdbcConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);){
			
			stmt.setInt(1, student.getId());
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Teacher teacher = new Teacher(rs.getInt("teacher.id"), rs.getString("teacher.first_name"),
						rs.getString("teacher.last_name"), rs.getFloat("teacher.experience_years"), rs.getString("teacher.email"),
						rs.getInt("teacher.password_hash"));
				Course course = new Course(rs.getInt("course.id"), teacher, rs.getString("course.name_course"),
						rs.getInt("course.places"), rs.getByte("course.active"));
				graduatedCourses.add(new Register(rs.getInt("register.id"), student, course,
						rs.getTimestamp("register.registered"), rs.getByte("register.mark"), rs.getString("register.testimonial"),
						rs.getTimestamp("register.graduated"), rs.getByte("register.active")));
			}
			
		} catch (SQLException e) {
			logger.error("There is problem with sql when we try to get all students that graduated for student"+ e.getMessage(), e);
		}
		
		return graduatedCourses;
	}

	@Override
	public boolean existRegister(Student student, int idCourse) {
		
		String sql = SQLManager.getPropertyForRegister("EXIST_REGISTER");
		
		try(Connection conn = JdbcConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);){
			
			stmt.setInt(1, student.getId());
			stmt.setInt(2, idCourse);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				return true;
			}
			
		} catch (SQLException e) {
			logger.error("There is problem with sql when we try to check if there is exist the same register" + e.getMessage(), e);
		}
		
		return false;
	}

}
