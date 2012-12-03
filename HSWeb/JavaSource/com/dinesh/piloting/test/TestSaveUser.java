package com.dinesh.piloting.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dinesh.piloting.model.User;
import com.dinesh.piloting.util.HibernateUtil;

import junit.framework.TestCase;

public class TestSaveUser extends TestCase {

	public TestSaveUser() {
	}

	public void testSave() {
		User user = new User();
		user.setFirstName("apple");
		user.setEmail("123456");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		HibernateUtil.shutdown();
	}
}