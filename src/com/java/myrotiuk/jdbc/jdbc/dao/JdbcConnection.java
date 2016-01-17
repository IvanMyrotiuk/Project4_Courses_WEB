package com.java.myrotiuk.jdbc.jdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 * Class<code> JdbcConnection</code> for getting connection from poll of connections
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 16-01-2016
 */
public final class JdbcConnection {
	private static final Logger logger = Logger.getLogger(JdbcConnection.class);
	
	private static volatile DataSource ds = null;
	
	private static DataSource getDataSource(){
		
		if (ds == null) {
			synchronized (JdbcConnection.class) {
				if(ds == null){
					try {
						InitialContext initialContext = new InitialContext();
						Context context = (Context) initialContext.lookup("java:/comp/env");
						ds = (DataSource)context.lookup("jdbc/project4_courses");
					} catch (NamingException e) {
						logger.error("There is problem with JNDI and message is:"+e.getMessage(), e);
					}
					
				}
			}
		}
		return ds;
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		
		try {
			//getDataSource();
			conn = getDataSource().getConnection();//ds
		} catch (SQLException e) {
			logger.error("There is problem with Connection to MySQL BD and message is:"+e.getMessage(), e);
		}
		
		return conn; 
	}
}
