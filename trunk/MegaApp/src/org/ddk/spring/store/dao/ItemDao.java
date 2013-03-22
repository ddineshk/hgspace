package org.ddk.spring.store.dao;

import java.util.List;

import org.ddk.spring.store.domain.Item;
import org.ddk.spring.store.domain.Order;
import org.springframework.dao.DataAccessException;

public interface ItemDao {
  
  public void updateQuantity(Order order) throws DataAccessException;
  
  boolean isItemInStock(String itemName) throws DataAccessException;
  
  List getItemListByProduct(String productNumber) throws DataAccessException;
  
  List getItem(String itemName) throws DataAccessException;
  
  List getItem(Item item) throws DataAccessException;
  int getItemQuantity(String itemName) throws DataAccessException;
  
  List getAllItem() throws DataAccessException;
}
