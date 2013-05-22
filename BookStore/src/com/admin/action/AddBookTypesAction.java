package com.admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.model.BookType;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BookServiceImpl;
import com.service.BookTypeService;

public class AddBookTypesAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6847114169300996080L;
	private BookTypeService bookTypeServiceImpl;
	private BookServiceImpl bookServiceImpl;
	private BookType bookType;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	private List<BookType> bookTypes = new ArrayList<BookType>();
	
	public BookTypeService getBookTypeServiceImpl() {
		return bookTypeServiceImpl;
	}

	public void setBookTypeServiceImpl(BookTypeService bookTypeServiceImpl) {
		this.bookTypeServiceImpl = bookTypeServiceImpl;
	}

	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
	
	@Override
	public String execute() throws Exception {
		bookTypes = bookServiceImpl.showAllTypes();
		request.setAttribute("bookTypes", bookTypes);
		setBookTypes(bookTypes);
		return SUCCESS;
	}
	
	public String addBookType() throws Exception {
		BookType inbookType = new BookType();
		inbookType.setBookType(bookType.getBookType());
		bookTypeServiceImpl.insert(inbookType);
		bookTypes = bookServiceImpl.showAllTypes();
		request.setAttribute("bookTypes", bookTypes);
		setBookTypes(bookTypes);
		return SUCCESS;
	}
	
	public String deleteBookType() throws Exception{
		String bookTypeId = request.getParameter("bookTypeId");
		if(bookTypeId==null ||bookTypeId.trim()==""){
			return ERROR;
		}
		bookTypeServiceImpl.delete(new Integer(bookTypeId));
		bookTypes = bookServiceImpl.showAllTypes();
		request.setAttribute("bookTypes", bookTypes);
		setBookTypes(bookTypes);
		return SUCCESS;
	}

	/**
	 * @return the bookServiceImpl
	 */
	public BookServiceImpl getBookServiceImpl() {
		return bookServiceImpl;
	}

	/**
	 * @param bookServiceImpl the bookServiceImpl to set
	 */
	public void setBookServiceImpl(BookServiceImpl bookServiceImpl) {
		this.bookServiceImpl = bookServiceImpl;
	}

	/**
	 * @return the bookTypes
	 */
	public List<BookType> getBookTypes() {
		return bookTypes;
	}

	/**
	 * @param bookTypes the bookTypes to set
	 */
	public void setBookTypes(List<BookType> bookTypes) {
		this.bookTypes = bookTypes;
	}
}
