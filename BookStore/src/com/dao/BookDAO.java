package com.dao;

import java.util.List;

import com.model.Book;

public interface BookDAO {
	
	void insert(Book book);
	
	List<Book> showAll();
	
	List<Book> queryByBookType(String bookType);
	
	List<Book> queryByBookName(String bookName);
	
	Book queryByBookId(Integer id);
	
	void deleteBook(Book book);
	
	void updateBook(Book book);

}
