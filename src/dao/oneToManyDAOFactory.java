package com.nt.dao;

public class oneToManyDAOFactory {

	public static oneToManyDAO getInstance() {
		return new oneToManyDAOImpl();
	}
}
