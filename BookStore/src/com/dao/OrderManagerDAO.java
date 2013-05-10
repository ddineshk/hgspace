package com.dao;

import com.model.Orders;
import com.model.OrderBooks;
import java.util.*;

public interface OrderManagerDAO {
	
	void insertOrder(Orders orders);
	void insertOrderBooks(OrderBooks orderBooks);
	List<Orders> queryByUserId(int user_id);
	List<OrderBooks> queryBooksByOrderId(int order_id);
	List<Orders> queryAll();
	List<Orders> queryAllByDeals();
	void deleteOrders(int order_id);
	void updateOrders(Orders orders);
	Orders queryByOrdersId(int order_id);
	
	

}
