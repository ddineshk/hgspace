package com.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AdminDAOImpl extends HibernateDaoSupport implements AdminDAO{

	@Override
	public List setAdminCertification(String name, String password) {
		return getHibernateTemplate().findByNamedParam("from Admin admin where name = :name and password = :password", new String[]{"name","password"},new String[]{name,password});
		
	}

}
