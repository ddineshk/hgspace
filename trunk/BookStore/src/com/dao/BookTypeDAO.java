package com.dao;

import java.util.List;

import com.model.BookType;

public interface BookTypeDAO {
	
	void insert(BookType bookType);
	void delete(Integer bookTypeId);
	List  findBookTypes();
}
