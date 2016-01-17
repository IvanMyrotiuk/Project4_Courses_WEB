/**
 * 
 */
package com.java.myrotiuk.stub.stub.dao;

import com.java.myrotiuk.entities.dto.BaseDTO;
import com.java.myrotiuk.jdbc.dao.BaseDAO;
import com.java.myrotiuk.jdbc.dao.DaoFactory;
import com.java.myrotiuk.jdbc.jdbc.dao.TypeDAO;

/**
 * Class for creating another one concrete implementation of DAO factory
 * @author Ivan
 *
 */
public class StubDAOfactory extends DaoFactory {

	@Override
	public BaseDAO<? extends BaseDTO> getConcreteDAO(TypeDAO typeDAO){
		//This is a stub for factory that has to return specific implementation of DAO
		return null;
	}
	
}
