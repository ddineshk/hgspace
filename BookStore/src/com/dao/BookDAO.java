package com.dao;

import java.util.List;

import com.model.Book;
import com.model.BookType;

public interface BookDAO {
	
	void insert(Book book);
	
	List<Book> showAll();
	
	List<BookType> showAllTypes();
	
	List<Book> queryByBookType(Integer bookType);
	
	List<Book> queryByBookName(String bookName);
	
	Book queryByBookId(Integer id);
	
	void deleteBook(Book book);
	
	void updateBook(Book book);

}
