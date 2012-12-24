package org.ddk.spring.store.dao;

import java.util.List;

import org.ddk.spring.store.domain.Category;
import org.springframework.dao.DataAccessException;

public interface CategoryDao {
  
  List getCategoryList() throws DataAccessException;
  
  Category getCategory(String categoryName) throws DataAccessException;
  
}
