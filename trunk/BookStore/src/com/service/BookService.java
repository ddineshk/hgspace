package com.service;

import java.util.List;

import com.model.Book;
import com.model.BookType;

public interface BookService {
	void insert(Book book);
	List<Book> showAll();
	List<BookType> showAllTypes();
	List<Book> queryByBookType(Integer bookType);
	List<Book> queryByBookName(String bookName);
	void deleteBook(Book book) ;
	void updateBook(Book book);
	Book queryByBookId(Integer id);

}
