package com.nt.test;

import com.nt.dao.oneToManyDAO;
import com.nt.dao.oneToManyDAOFactory;
import com.nt.util.HibernateUtil;

public class oneToManyTest {
	public static void main(String[] args) {
		oneToManyDAO dao = null;
		dao = oneToManyDAOFactory.getInstance();

		dao.saveData();

		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}
}
