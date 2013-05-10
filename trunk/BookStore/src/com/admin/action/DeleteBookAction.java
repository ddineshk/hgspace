package com.admin.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.model.Book;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BookService;

public class DeleteBookAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5099740112730639125L;
	private BookService bookServiceImpl;
	private HttpServletRequest request = ServletActionContext.getRequest();
	String id = request.getParameter("id");

	@Override
	public String execute() throws Exception {
		Integer bookId = Integer.parseInt(id);
		Book book = bookServiceImpl.queryByBookId(bookId);
		bookServiceImpl.deleteBook(book);
		return SUCCESS;
	}

	public BookService getBookServiceImpl() {
		return bookServiceImpl;
	}

	public void setBookServiceImpl(BookService bookServiceImpl) {
		this.bookServiceImpl = bookServiceImpl;
	}
}
