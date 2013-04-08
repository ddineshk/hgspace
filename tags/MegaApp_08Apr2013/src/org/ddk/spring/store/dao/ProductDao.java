package org.ddk.spring.store.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;


public interface ProductDao {
  
  List getProductListByCategory(String categoryName) throws DataAccessException;
  
  List searchProductList(String keywords) throws DataAccessException;
  
  List getProduct(String productNumber) throws DataAccessException;
  
}
