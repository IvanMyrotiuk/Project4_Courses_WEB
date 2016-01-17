package com.java.myrotiuk.jdbc.dao;

import com.java.myrotiuk.entities.dto.BaseDTO;
import com.java.myrotiuk.jdbc.jdbc.dao.JdbcDAOfactory;
import com.java.myrotiuk.jdbc.jdbc.dao.TypeDAO;
import com.java.myrotiuk.stub.stub.dao.StubDAOfactory;

/**
 * abstract Class<code> DaoFactory</code> For creating concrete DAO factory
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 16-01-2016
 */
public abstract class DaoFactory {

	private static volatile DaoFactory instance = null;
	
	public abstract BaseDAO<? extends BaseDTO> getConcreteDAO(TypeDAO typeDAO);
	
	private static DaoFactory getDaoFactory(TypeDAOfactory typeDAOfactory){
		
		switch (typeDAOfactory) {
			case JDBC: return new JdbcDAOfactory();
			
			case STUB: return new StubDAOfactory();
			
			default: throw new IllegalArgumentException("inappropriate DAO factory");
		}
		
	}
	
	
	public static DaoFactory getConcreateDAOfactory(TypeDAOfactory typeDAOfactory){
		
		if(instance == null){
			
			synchronized (DaoFactory.class) {
				if(instance == null)
					instance =  getDaoFactory(typeDAOfactory);
			}
			
		}
		return instance;
	}
	
}
