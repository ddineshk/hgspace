package com.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.BookType;

public class BookTypeDAOImpl  extends HibernateDaoSupport implements BookTypeDAO{

	@Override
	public void insert(BookType bookType) {
		getHibernateTemplate().save(bookType);
		
	}

	@Override
	public List<String> findBookTypes() {
		List<String> booktypes = getHibernateTemplate().find("select bookType.bookType from BookType bookType");
		return booktypes ;
	
	}

	@Override
	public void delete(Integer bookTypeId) {
		BookType bookType = new BookType();
		bookType.setId(bookTypeId);
		getHibernateTemplate().delete(bookType);
	}

}
