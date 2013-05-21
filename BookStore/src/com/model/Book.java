package com.model;

import java.util.Date;

public class Book {
	
	private Integer id;
	private Integer bookNumber;
	private String isbn;
	private String bookName;
	//private String bookType;
	private BookType bookType;
	private String author;
	private String bookPress;
	private Date publishDate;
	private String language;
	private Integer price;
	private Integer pages;
	private String bookDiscription;
	private String bookImage;
	private Integer bookAmount;
	private Integer bookSales;
	
	public Integer getBookAmount() {
		return bookAmount;
	}
	public void setBookAmount(Integer bookAmount) {
		this.bookAmount = bookAmount;
	}
	public Integer getBookSales() {
		return bookSales;
	}
	public void setBookSales(Integer bookSales) {
		this.bookSales = bookSales;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBookPress() {
		return bookPress;
	}
	public void setBookPress(String bookPress) {
		this.bookPress = bookPress;
	}
	
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public String getBookDiscription() {
		return bookDiscription;
	}
	public void setBookDiscription(String bookDiscription) {
		this.bookDiscription = bookDiscription;
	}
	
	public String getBookImage() {
		return bookImage;
	}
	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	public Integer getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(Integer bookNumber) {
		this.bookNumber = bookNumber;
	}
	public BookType getBookType() {
		return bookType;
	}
	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

}
