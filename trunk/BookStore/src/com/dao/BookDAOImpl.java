package com.dao;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.Book;
import com.model.BookType;

public class BookDAOImpl extends HibernateDaoSupport implements BookDAO{

	@Override
	public void insert(Book book) {
		getHibernateTemplate().save(book);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Book> showAll() {
		return getHibernateTemplate().executeFind(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List<Book>books = session.createQuery("From Book book") .list();	
				
				return books;
			}
			
		});
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> queryByBookType(Integer bookType) {
	    return getHibernateTemplate().findByNamedParam("from Book book where book.bookType.id = :bookType","bookType",bookType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> queryByBookName(String bookName) {
		return getHibernateTemplate().findByNamedParam("from Book book where book.bookName like :bookName" ,"bookName", bookName+"%");
	}

	@Override
	public void deleteBook(Book book) {
		getHibernateTemplate().delete(book);
		
	}

	@Override
	public void updateBook(Book book) {
		getHibernateTemplate().update(book);
		
	}

	@Override
	public Book queryByBookId(Integer id) {
		return getHibernateTemplate().get(Book.class, id);
	}

	@Override
	public List<BookType> showAllTypes() {
		return getHibernateTemplate().executeFind(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List<BookType> bookTypes = session.createQuery("From BookType bookType").list();	
				return bookTypes;
			}
		});	
	}

}
