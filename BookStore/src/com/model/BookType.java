package com.model;

import java.io.Serializable;

public class BookType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2307391593287853880L;
	private Integer id;
	private String bookType;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	
}
