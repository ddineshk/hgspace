package org.ddk.spring.store.dao;

import java.util.List;

import org.ddk.spring.store.domain.Order;
import org.springframework.dao.DataAccessException;

public interface OrderDao {

  List getOrdersByUsername(String username) throws DataAccessException;

  List getOrderAndUserName(long id) throws DataAccessException;
  Order getOrder(int id) throws DataAccessException;
  void insertOrder(Order order) throws DataAccessException;

}
