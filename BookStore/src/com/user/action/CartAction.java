package com.user.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.model.Book;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BookService;

public class CartAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7412433643669124095L;
	private BookService bookServiceImpl;
	private Book book;
	private Integer selectid;
	private Integer quantity;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String bookId = request.getParameter("bookId");
		selectid = Integer.parseInt(bookId);
		setSelectid(selectid);

		List<Book> selectbooks = new ArrayList<Book>();

		if (session.getAttribute("selectbooks") == null) {
			session.setAttribute("selectbooks", selectbooks);
		} else {
			selectbooks = (List<Book>) session.getAttribute("selectbooks");
		}

		int quantity = 0;

		for (Book book : selectbooks) {

			if (bookId.equals(book.getId() + "")) {

				quantity++;
				book.setBookAmount(1);
				// setQuantity(1);
			}

		}

		if (quantity == 0) {

			book = bookServiceImpl.queryByBookId(selectid);
			selectbooks.add(book);
			book.setBookAmount(1);
			int totalPrice = 0;
			if (session.getAttribute("totalPrice") == null) {
				session.setAttribute("totalPrice", book.getPrice());
			} else {

				totalPrice = (Integer) session.getAttribute("totalPrice");
				totalPrice += book.getPrice();
				session.removeAttribute("totalPrice");
				session.setAttribute("totalPrice", totalPrice);
			}

			session.removeAttribute("selectbooks");
			session.setAttribute("selectbooks", selectbooks);
		}

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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getSelectid() {
		return selectid;
	}

	public void setSelectid(Integer selectid) {
		this.selectid = selectid;
	}

}
