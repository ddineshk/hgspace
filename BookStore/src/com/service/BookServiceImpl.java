package com.service;

import java.util.List;

import com.dao.BookDAOImpl;
import com.model.Book;

public class BookServiceImpl implements BookService{
	
	private BookDAOImpl bookDAOImpl;

	public BookDAOImpl getBookDAOImpl() {
		return bookDAOImpl;
	}

	public void setBookDAOImpl(BookDAOImpl bookDAOImpl) {
		this.bookDAOImpl = bookDAOImpl;
	}

	@Override
	public void insert(Book book) {
		bookDAOImpl.insert(book);
	}

	@Override
	public List<Book> showAll() {
		return bookDAOImpl.showAll();
	}

	@Override
	public List<Book> queryByBookType(String bookType) {
		return bookDAOImpl.queryByBookType(bookType);
	}

	@Override
	public List<Book> queryByBookName(String bookName) {
		return bookDAOImpl.queryByBookName(bookName);
	}

	@Override
	public void deleteBook(Book book) {
		bookDAOImpl.deleteBook(book);
	}

	@Override
	public void updateBook(Book book) {
		bookDAOImpl.updateBook(book);
	}

	@Override
	public Book queryByBookId(Integer id) {
		return bookDAOImpl.queryByBookId(id);
	}

}
