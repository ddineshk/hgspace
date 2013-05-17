package com.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import org.apache.struts2.ServletActionContext;

import com.model.OrderBooks;
import com.model.Orders;
import com.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.OrderManagerService;

public class UserManagerOrderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -764272651566546918L;
	private OrderManagerService orderManagerServiceImpl;
	private Integer totalPrice;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");
		if(user==null){
			return ERROR;
		}
		Integer user_id = user.getId();
		List<Orders> orders = orderManagerServiceImpl.queryByUserId(user_id);
		session.setAttribute("orders", orders);

		return SUCCESS;
	}

	public String queryOrderBooks() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		Integer order_id = Integer.parseInt(id);
		List<OrderBooks> orderBooks = orderManagerServiceImpl
				.queryBooksByOrderId(order_id);
		Orders singleOrders = orderManagerServiceImpl.queryByOrdersId(order_id);

		totalPrice = singleOrders.getTotalPrice();

		setTotalPrice(totalPrice);
		session.setAttribute("orderBooks", orderBooks);

		return SUCCESS;
	}

	public String deleteOrders() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Integer order_id = Integer.parseInt(id);
		orderManagerServiceImpl.deleteOrders(order_id);
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");

		Integer user_id = user.getId();
		List<Orders> orders = orderManagerServiceImpl.queryByUserId(user_id);

		session.removeAttribute("orders");
		session.setAttribute("orders", orders);

		return SUCCESS;
	}

	public OrderManagerService getOrderManagerServiceImpl() {
		return orderManagerServiceImpl;
	}

	public void setOrderManagerServiceImpl(
			OrderManagerService orderManagerServiceImpl) {
		this.orderManagerServiceImpl = orderManagerServiceImpl;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

}
