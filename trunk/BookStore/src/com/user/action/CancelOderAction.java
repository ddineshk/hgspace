package com.user.action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.model.Book;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BookService;

public class CancelOderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4368943594770797369L;
	private BookService bookServiceImpl;
	private Book book;

	@Override
	public String execute() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String bookId = request.getParameter("Id");
		List<Book> selectbooks = (List<Book>) session
				.getAttribute("selectbooks");
		Integer totalPrice = 0;
		totalPrice = (Integer) session.getAttribute("totalPrice");
		Iterator iterator = selectbooks.iterator();

		while (iterator.hasNext()) {

			Book book = (Book) iterator.next();
			if (book.getId().equals(Integer.parseInt(bookId))) {

				totalPrice -= (book.getBookAmount()) * (book.getPrice());
				iterator.remove();
			}

		}

		session.removeAttribute("selectbooks");
		session.setAttribute("selectbooks", selectbooks);
		session.removeAttribute("totalPrice");
		session.setAttribute("totalPrice", totalPrice);

		return SUCCESS;
	}

	public BookService getBookServiceImpl() {
		return bookServiceImpl;
	}

	public void setBookServiceImpl(BookService bookServiceImpl) {
		this.bookServiceImpl = bookServiceImpl;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
