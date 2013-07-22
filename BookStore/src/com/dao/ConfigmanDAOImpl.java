package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.Application;

public class ConfigmanDAOImpl extends HibernateDaoSupport implements ConfigmanDAO {

	@Override
	public List<Application> getAllApps() {
		return getHibernateTemplate().executeFind(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List<Application> applications = session.createQuery("From Application application").list();	
				return applications;
			}
		});	
	}

}
