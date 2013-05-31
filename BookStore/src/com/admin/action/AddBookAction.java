package com.admin.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.model.Book;
import com.model.BookType;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BookService;


public class AddBookAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6419485977761425332L;

	private BookService bookServiceImpl;
	Random rand = new Random();
	static int num = 100;
	int randnum = rand.nextInt(num + 1);
    /**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	private Book book;
	private File bookImageFile;
	private String bookImageContextType;
	private String bookImageName = "";
	private String savePath;
	private Integer bookNumber;
	private String isbn;
	private String bookName;
	private Integer bookTypeId;
	private String author;
	private String bookPress;
	private Date publishDate;
	private String language;
	private Integer price;
	private Integer pages;
	private String bookDiscription;
	private Integer bookAmount;
	private Integer bookSales;

	private List<BookType> bookTypes = new ArrayList<BookType>();
	HttpServletRequest request = ServletActionContext.getRequest();
	public File getBookImageFile() {
		return bookImageFile;
	}

	public void setBookImageFile(File bookImageFile) {
		this.bookImageFile = bookImageFile;
	}

	public String getBookImageContextType() {
		return bookImageContextType;
	}

	public void setBookImageContextType(String bookImageContextType) {
		this.bookImageContextType = bookImageContextType;
	}

	public String getBookImageName() {
		return bookImageName; 
	}

	public void setBookImageName(String bookImageName) {
		this.bookImageName = bookImageName;
	}

	public String getSavePath() {
		return  ServletActionContext.getServletContext().getRealPath(savePath);
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public BookService getBookServiceImpl() {
		return bookServiceImpl;
	}

	public void setBookServiceImpl(BookService bookServiceImpl) {
		this.bookServiceImpl = bookServiceImpl;
	}

	@Override
	public String execute() throws Exception {
		bookTypes = bookServiceImpl.showAllTypes();
		request.setAttribute("bookTypes", bookTypes);
		setBookTypes(bookTypes);
		String path = getSavePath();
		bookImageName= +randnum + removeSpaces(bookImageName)+".jpg";
		File file = new File(path,bookImageName);
		FileUtils.copyFile(this.bookImageFile, file);
		bookServiceImpl.insert(getBook());
		return SUCCESS;
	}
	
	public String setTypes() throws Exception{
		bookTypes = bookServiceImpl.showAllTypes();
		request.setAttribute("bookTypes", bookTypes);
		setBookTypes(bookTypes);
		return SUCCESS;
	}
	
	public Book getBook() {
		book = new Book();
		book.setBookNumber(bookNumber);
		book.setIsbn(isbn);
		book.setAuthor(author);
		book.setBookName(bookName);
		BookType bookType = new BookType();
		bookType.setId(bookTypeId);
		book.setBookType(bookType);
		book.setBookAmount(price);
		book.setBookDiscription(bookDiscription);
		book.setBookPress(bookPress);
		book.setBookSales(bookSales);
		book.setLanguage(language);
		book.setBookImage(bookImageName);
		book.setPages(pages);
		book.setPublishDate(new Date());
		book.setPrice(price);
		return book;
	}

	public String removeSpaces(String s) {
		
		String []data = s.split(" ");
		String name = "";
		for(int i = 0 ; i<data.length ; i++){
			name+=data[i];
		}	
		return name;
	}

	
	public Integer getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(Integer bookNumber) {
		this.bookNumber = bookNumber;
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

	public Integer getBookTypeId() {
		return bookTypeId;
	}

	public void setBookTypeId(Integer bookTypeId) {
		this.bookTypeId = bookTypeId;
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

	public List<BookType> getBookTypes() {
		return bookTypes;
	}

	public void setBookTypes(List<BookType> bookTypes) {
		this.bookTypes = bookTypes;
	}

}
