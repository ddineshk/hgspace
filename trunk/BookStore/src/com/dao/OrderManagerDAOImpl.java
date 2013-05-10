package com.dao;

import java.util.*;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.model.Orders;
import com.model.OrderBooks;

public class OrderManagerDAOImpl extends HibernateDaoSupport implements OrderManagerDAO{

	@Override
	public void insertOrder(Orders orders) {
		getHibernateTemplate().save(orders);
		
	}

	@Override
	public void insertOrderBooks(OrderBooks orderBooks) {
		getHibernateTemplate().save(orderBooks);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> queryByUserId(int user_id) {
		return getHibernateTemplate().find("from Orders orders where orders.user.id ="+user_id+" order by orderTime desc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderBooks> queryBooksByOrderId(int order_id) {
		return getHibernateTemplate().find("from OrderBooks orderbooks where orderbooks.order.id = "+order_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> queryAll() {
		return getHibernateTemplate().find("from Orders orders  order by orderTime desc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> queryAllByDeals() {
		return getHibernateTemplate().find("from Orders orders where isDealed = '1' order by orderTime desc");
	}

	@Override
	public void deleteOrders(int order_id) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().get(Orders.class, order_id));
	}

	@Override
	public void updateOrders(Orders orders) {
        getHibernateTemplate().update(orders);
	}

	@Override
	public Orders queryByOrdersId(int order_id) {
		return getHibernateTemplate().get(Orders.class, order_id);
	}
}
