package com.service;

import java.util.List;

import com.dao.BookTypeDAOImpl;
import com.model.BookType;

public class BookTypeServiceImpl implements BookTypeService{
	
	private BookTypeDAOImpl bookTypeDAOImpl;
	
	public BookTypeDAOImpl getBookTypeDAOImpl() {
		return bookTypeDAOImpl;
	}

	public void setBookTypeDAOImpl(BookTypeDAOImpl bookTypeDAOImpl) {
		this.bookTypeDAOImpl = bookTypeDAOImpl;
	}

	@Override
	public void insert(BookType bookType) {
		bookTypeDAOImpl.insert(bookType);
		
	}

	@Override
	public List<String> findBookTypes() {
		return bookTypeDAOImpl.findBookTypes();
	}

	@Override
	public void delete(Integer bookTypeId) {
		bookTypeDAOImpl.delete(bookTypeId);
	}
	
}
