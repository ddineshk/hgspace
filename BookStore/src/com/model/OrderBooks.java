package com.model;

import java.io.Serializable;

public class OrderBooks implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1010433034375654814L;
	private Integer id;
	private Book book;
	private Orders order;
	private Integer bookSales;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Integer getBookSales() {
		return bookSales;
	}
	public void setBookSales(Integer bookSales) {
		this.bookSales = bookSales;
	}
	
}
