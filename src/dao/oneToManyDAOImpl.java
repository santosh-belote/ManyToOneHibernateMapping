package com.nt.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.PhoneNumber;
import com.nt.domain.User;
import com.nt.util.HibernateUtil;

public class oneToManyDAOImpl implements oneToManyDAO {

	@Override
	public void saveData() {
		// getSession

		Session session = null;
		Transaction tx = null;
		Set<PhoneNumber> pset = null;
		Set<User> uset = null;
		session = HibernateUtil.getSession(); // open session

		// Create parent object
		User user1 = new User();
		user1.setUserId(1001);
		user1.setFirstName("Santosh");
		user1.setLastName("Belote");
		user1.setAddress("Devi Bhoyare");
		
		User user2 = new User();
		user2.setUserId(1002);
		user2.setFirstName("Sunita");
		user2.setLastName("Gangurde");
		user2.setAddress("Pimple Gurav");

		// Create child object
		PhoneNumber ph1 = new PhoneNumber();
		PhoneNumber ph2 = new PhoneNumber();

		ph1.setPhone(999999999);
		ph1.setNumberType("Home");
		ph1.setProvider("Airtel");

		ph2.setPhone(888888888);
		ph2.setNumberType("Office");
		ph2.setProvider("VodaPhone");
		
		// Map multiple child objects to parent using mapping
		pset = new HashSet<PhoneNumber>();
		pset.add(ph1);
		pset.add(ph2);
		
		uset = new HashSet<User>();
		uset.add(user1);
		uset.add(user2);

		user1.setPhones(pset);
		ph1.setUsers(uset);
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(user1);
			session.saveOrUpdate(user2);
			tx.commit();
			System.out.println("Object Saved Successfully.");
		} catch (Exception ex) {
			tx.rollback();
			System.out.println("Oops...Object is not saved.");
		}
		

	}

}
