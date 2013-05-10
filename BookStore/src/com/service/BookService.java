package com.service;

import java.util.List;

import com.model.Book;

public interface BookService {
	void insert(Book book);
	List<Book> showAll();
	List<Book> queryByBookType(String bookType);
	List<Book> queryByBookName(String bookName);
	void deleteBook(Book book) ;
	void updateBook(Book book);
	Book queryByBookId(Integer id);

}
