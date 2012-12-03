package com.dinesh.piloting.model;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dinesh.piloting.util.HibernateUtil;

public class User {
	
	Logger log = Logger.getLogger(User.class);
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String login() {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery((new StringBuilder(
				"from User u where u.firstName = '")).append(firstName)
				.append("' and u.password = '"+password+"'").toString());
		@SuppressWarnings("rawtypes")
		List users = query.list();
		User user = null;
		if (users != null && users.size() > 0)
			user = (User) users.get(0);
		tx.commit();
		session.flush();
		session.close();
		HibernateUtil.shutdown();
		if (user != null && user.getFirstName().equals(firstName)
				&& user.getPassword().equals(password)) {
			 log.info((new StringBuilder("someone successfully use username ")).append(firstName).append(" to log in.").toString());
			return "success";
		} else {
		    log.info((new StringBuilder("someone failed to use username ")).append(firstName).append(" to log in.").toString());
			return "failure";
		}
	}

	public String register() {
		User user = new User();
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		
		user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		@SuppressWarnings("rawtypes")
		List list;
		Query query = session.createQuery("select max(u.id) from User u");
		list = query.list();
		int id = (Integer) list.get(0);
		user.setId(new Integer(id+1));
		 try
		 {
			 session.save(user);
			 tx.commit();
			 HibernateUtil.shutdown();
			 session.flush();
			 session.close();
		 }
		 catch(HibernateException e)
		 {
			 return "failure";
		 }
		 return "success";
	}

}
