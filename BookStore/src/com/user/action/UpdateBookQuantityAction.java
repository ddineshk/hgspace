package com.user.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.model.Book;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BookService;

public class UpdateBookQuantityAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5967129383215138426L;
	private BookService bookServiceImpl;
	private Book book;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String bookId = request.getParameter("Id");
		String bookAmount = request.getParameter("bookAmount");
		// int id = Integer.parseInt(bookId);

		List<Book> selectbooks = (List<Book>) session
				.getAttribute("selectbooks");
		Integer totalPrice = 0;
		totalPrice = (Integer) session.getAttribute("totalPrice");

		for (Book book : selectbooks) {

			if (bookId.equals(book.getId() + "")) {

				totalPrice += (Integer.parseInt(bookAmount) - book
						.getBookAmount()) * book.getPrice();
				book.setBookAmount(Integer.parseInt(bookAmount));

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
