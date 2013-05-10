package com.service;

import java.util.List;

import com.dao.OrderManagerDAOImpl;
import com.model.Orders;
import com.model.OrderBooks;

public class OrderManagerServiceImpl implements OrderManagerService{
	
	private OrderManagerDAOImpl orderManagerDAOImpl;
	
	public OrderManagerDAOImpl getOrderManagerDAOImpl() {
		return orderManagerDAOImpl;
	}

	public void setOrderManagerDAOImpl(OrderManagerDAOImpl orderManagerDAOImpl) {
		this.orderManagerDAOImpl = orderManagerDAOImpl;
	}

	@Override
	public void insertOrder(Orders orders) {
		orderManagerDAOImpl.insertOrder(orders);
	}

	@Override
	public void insertOrderBooks(OrderBooks orderBooks) {
		orderManagerDAOImpl.insertOrderBooks(orderBooks);
	}

	@Override
	public List<Orders> queryByUserId(int user_id) {
		return orderManagerDAOImpl.queryByUserId(user_id);
	}

	@Override
	public List<OrderBooks> queryBooksByOrderId(int order_id) {
		return orderManagerDAOImpl.queryBooksByOrderId(order_id);
	}

	@Override
	public List<Orders> queryAll() {
		return orderManagerDAOImpl.queryAll();
	}

	@Override
	public List<Orders> queryAllByDeals() {
		return orderManagerDAOImpl.queryAllByDeals();
	}

	@Override
	public void deleteOrders(int order_id) {
		orderManagerDAOImpl.deleteOrders(order_id);
	}

	@Override
	public void updateOrders(Orders orders) {
		orderManagerDAOImpl.updateOrders(orders);
	}

	@Override
	public Orders queryByOrdersId(int order_id) {
		return orderManagerDAOImpl.queryByOrdersId(order_id);
	}
	
}
