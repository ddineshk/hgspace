package org.ddk.spring.store.domain.logic;

import java.util.List;

import org.ddk.spring.store.domain.Account;
import org.ddk.spring.store.domain.Category;
import org.ddk.spring.store.domain.Item;
import org.ddk.spring.store.domain.Order;

public interface StoreFacade {

	Account getAccount(String username);

	List getAccount(String username, String password);

	String getBannerNameForUser(String username);

	void insertAccount(Account account);

	void updateAccount(Account account);

	List getUsernameList();

	List getCategoryList();

	Category getCategory(String categoryName);

	List getProductListByCategory(String categoryName);

	List searchProductList(String keywords);

	List getProduct(String productNumber);

	List getItemListByProduct(String productNumber);

	List getItem(String itemName);

	int getItemQuantity(String itemName);

	List getItem(Item item);

	boolean isItemInStock(String itemName);

	void insertOrder(Order order);

	Order getOrder(int id);

	List getOrderAndUserName(long id);

	List getOrdersByUsername(String username);
	
	List getAllItem();

}
