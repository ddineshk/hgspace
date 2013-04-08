package org.ddk.spring.store.dao.hibernate;

import java.util.List;

import org.ddk.spring.store.dao.OrderDao;
import org.ddk.spring.store.domain.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateOrderDao extends HibernateDaoSupport implements OrderDao {

	public List getOrdersByUsername(String username) throws DataAccessException {
		return getHibernateTemplate().find("select order from Order order, Account user where "
						+ "order.user.id = user.id and user.username = ?",username);
	}

	public List getOrderAndUserName(long id) throws DataAccessException {
		Long orderId = new Long(id);

		List list = getHibernateTemplate().find("select o, o.user.username " + "from Order o where o.id = ?", orderId);
		return list;
	}

	public Order getOrder(int id) throws DataAccessException {
		Long parameterObject = new Long(id);
		Order order = (Order) getHibernateTemplate().load(Order.class,parameterObject);

		System.out.println(">>>>>>>>>>" + order);
		return order;
	}

	public void insertOrder(Order order) throws DataAccessException {
		getHibernateTemplate().persist(order);
	}

}
