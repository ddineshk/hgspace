package com.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.struts2.ServletActionContext;
import com.model.Book;
import com.model.Orders;
import com.model.OrderBooks;
import com.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.OrderManagerService;

public class AddOrderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8663311194527664578L;
	private OrderManagerService orderManagerServiceImpl;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		List<Book> selectbooks = new ArrayList<Book>();

		Orders orders = new Orders();

		String ordersNumber = "ISOD";
		DateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		String formatDate = format.format(new Date());
		int random = new Random().nextInt(100000);
		ordersNumber += formatDate + random;

		int totalPrice = (Integer) session.getAttribute("totalPrice");
		User user = (User) session.getAttribute("user");
		Date date = new Date();

		orders.setOrderNumber(ordersNumber);
		orders.setUser(user);
		orders.setTotalPrice(totalPrice);
		orders.setOrderTime(date);
		orders.setIsDealed("0");
		orderManagerServiceImpl.insertOrder(orders);

		selectbooks = (List<Book>) session.getAttribute("selectbooks");
		for (Book book : selectbooks) {

			OrderBooks orderBooks = new OrderBooks();

			orderBooks.setBook(book);
			orderBooks.setOrder(orders);
			orderBooks.setBookSales(book.getBookAmount());
			orderManagerServiceImpl.insertOrderBooks(orderBooks);

		}

		session.removeAttribute("selectbooks");
		session.removeAttribute("totalPrice");

		return SUCCESS;
	}

	public OrderManagerService getOrderManagerServiceImpl() {
		return orderManagerServiceImpl;
	}

	public void setOrderManagerServiceImpl(
			OrderManagerService orderManagerServiceImpl) {
		this.orderManagerServiceImpl = orderManagerServiceImpl;
	}

}
