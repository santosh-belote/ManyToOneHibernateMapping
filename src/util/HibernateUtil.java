package com.nt.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory factory = null;
	private static Session session = null;

	static {
		factory = new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
	}

	public static Session getSession() {
		session = factory.openSession();
		return session;
	}

	public static void closeSession() {
		session.close();
	}

	public static void closeSessionFactory() {
		factory.close();
	}
}
