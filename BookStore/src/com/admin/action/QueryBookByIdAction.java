package com.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.model.Book;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BookService;

public class QueryBookByIdAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3421651793196684560L;
	private BookService bookServiceImpl;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session  = request.getSession();
		String id = request.getParameter("id");
		Integer bookId = Integer.parseInt(id);
		Book book = bookServiceImpl.queryByBookId(bookId);
		session.removeAttribute("book");
		session.setAttribute("book", book);
		return SUCCESS;
	}

	public BookService getBookServiceImpl() {
		return bookServiceImpl;
	}

	public void setBookServiceImpl(BookService bookServiceImpl) {
		this.bookServiceImpl = bookServiceImpl;
	}
}
