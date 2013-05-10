package com.service;

import java.util.List;

import com.model.BookType;

public interface BookTypeService {
	
	void insert(BookType bookType);
	List<String>  findBookTypes();

}
