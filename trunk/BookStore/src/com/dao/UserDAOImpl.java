package com.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO{

	@Override
	public void insert(User user) {
		getHibernateTemplate().save(user);
		
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List setUserCertification(String name, String password) {
		return getHibernateTemplate().findByNamedParam("from User user where name= :name and password = :password", new String[]{"name","password"}, new String[]{name,password});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> queryAllUser() {
		return getHibernateTemplate().find("from User user");
	}

	@Override
	public void updateUserInfo(User user) {
		getHibernateTemplate().update(user);
	}
}
