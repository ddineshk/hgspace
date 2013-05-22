package com.admin.action;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.struts2.ServletActionContext;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.model.Book;
import com.model.BookType;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.BookService;

public class ViewBooksAction extends ActionSupport implements ModelDriven{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3419767851294338733L;
	private BookService bookServiceImpl;
    private Book book = new Book();
    private List<Book> books = new ArrayList<Book>();
    private List<BookType> bookTypes = new ArrayList<BookType>();
    
    HttpServletRequest request = ServletActionContext.getRequest();
    String bookName = request.getParameter("bookName");
    String bookTypeId = request.getParameter("bookTypeId");
    
	@Override
	public String execute() throws Exception {
		books  = bookServiceImpl.showAll();
		bookTypes = bookServiceImpl.showAllTypes();
		request.setAttribute("books", books);
		request.setAttribute("bookTypes", bookTypes);
		setBooks(books);
		setBookTypes(bookTypes);
		return SUCCESS;
	}
	
	public String queryByBookName(){
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			System.setProperty("http.proxyHost", "20.201.110.111");
			System.setProperty("http.proxyPort", "80");
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new URL("http://isbndb.com/api/books.xml?access_key=46BFXKJ4&index1=isbn&value1="+bookName).openStream());
			System.out.println(doc.getTextContent());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		books = bookServiceImpl.queryByBookName(bookName);
		bookTypes = bookServiceImpl.showAllTypes();
		request.setAttribute("books", books);
		request.setAttribute("bookTypes", bookTypes);
		setBooks(books);
		setBookTypes(bookTypes);
		return SUCCESS;
	}
	
	public String queryByBookType(){
		books = bookServiceImpl.queryByBookType(new Integer(bookTypeId));
		bookTypes = bookServiceImpl.showAllTypes();
		request.setAttribute("books", books);
		request.setAttribute("bookTypes", bookTypes);
		setBooks(books);
		setBookTypes(bookTypes);
		return SUCCESS;
	}
	
	
	public BookService getBookServiceImpl() {
		return bookServiceImpl;
	}

	public void setBookServiceImpl(BookService bookServiceImpl) {
		this.bookServiceImpl = bookServiceImpl;
	}

	@Override
	public Object getModel() {
		return book;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<BookType> getBookTypes() {
		return bookTypes;
	}

	public void setBookTypes(List<BookType> bookTypes) {
		this.bookTypes = bookTypes;
	}
}
