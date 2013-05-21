package com.user.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.model.Book;
import com.model.BookType;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.BookService;

public class UserViewBooksAction extends ActionSupport implements ModelDriven {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9191189325506470541L;
	private BookService bookServiceImpl;
	private Book book = new Book();
	private List<Book> books = new ArrayList<Book>();
	private List<BookType> bookTypes = new ArrayList<BookType>();
	HttpServletRequest request = ServletActionContext.getRequest();
	String bookName = request.getParameter("bookName");
	String bookTypeId = request.getParameter("bookTypeId");

	@Override
	public String execute() throws Exception {
		books = bookServiceImpl.showAll();
		bookTypes = bookServiceImpl.showAllTypes();
		request.setAttribute("books", books);
		request.setAttribute("bookTypes", bookTypes);
		setBooks(books);
		setBookTypes(bookTypes);
		return SUCCESS;
	}

	public String queryByBookName() {

		books = bookServiceImpl.queryByBookName(bookName);
		bookTypes = bookServiceImpl.showAllTypes();
		request.setAttribute("books", books);
		request.setAttribute("bookTypes", bookTypes);
		setBooks(books);
		setBookTypes(bookTypes);
		return SUCCESS;
	}

	public String queryByBookType() {
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

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public Object getModel() {
		return book;
	}

	public List<BookType> getBookTypes() {
		return bookTypes;
	}

	public void setBookTypes(List<BookType> bookTypes) {
		this.bookTypes = bookTypes;
	}

}
