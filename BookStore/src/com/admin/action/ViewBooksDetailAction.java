package com.admin.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.model.Book;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BookService;

public class ViewBooksDetailAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1929904944253868815L;
	private BookService bookServiceImpl;
	private Book book;
	HttpServletRequest request = ServletActionContext.getRequest();
	String id = (String)request.getParameter("id");
	private String imgPath;

	@Override
	public String execute() throws Exception {
		Integer bookId = Integer.parseInt(id);
		book = bookServiceImpl.queryByBookId(bookId);
		imgPath ="../images/"+book.getBookImage();
		setImgPath(imgPath);
		
		return SUCCESS;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public BookService getBookServiceImpl() {
		return bookServiceImpl;
	}

	public void setBookServiceImpl(BookService bookServiceImpl) {
		this.bookServiceImpl = bookServiceImpl;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
}
