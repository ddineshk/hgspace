package org.ddk.spring.store.domain.logic;

import java.util.List;

import org.ddk.spring.store.dao.AccountDao;
import org.ddk.spring.store.dao.CategoryDao;
import org.ddk.spring.store.dao.ItemDao;
import org.ddk.spring.store.dao.OrderDao;
import org.ddk.spring.store.dao.ProductDao;
import org.ddk.spring.store.domain.Account;
import org.ddk.spring.store.domain.Category;
import org.ddk.spring.store.domain.Item;
import org.ddk.spring.store.domain.Order;

public class StoreImpl implements StoreFacade, OrderService {

	private AccountDao accountDao;

	private CategoryDao categoryDao;

	private ProductDao productDao;

	private ItemDao itemDao;

	private OrderDao orderDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public Account getAccount(String username) {
		return this.accountDao.getAccount(username);
	}

	public List getAccount(String username, String password) {
		return this.accountDao.getAccount(username, password);
	}

	public String getBannerNameForUser(String username) {
		return this.accountDao.getBannerNameForUser(username);
	}

	public void insertAccount(Account account) {
		this.accountDao.insertAccount(account);
	}

	public void updateAccount(Account account) {
		this.accountDao.updateAccount(account);
	}

	public List getUsernameList() {
		return this.accountDao.getUsernameList();
	}

	public List getCategoryList() {
		return this.categoryDao.getCategoryList();
	}

	public Category getCategory(String categoryName) {
		return this.categoryDao.getCategory(categoryName);
	}

	public List getProductListByCategory(String categoryName) {
		return this.productDao.getProductListByCategory(categoryName);
	}

	public List searchProductList(String keywords) {
		return this.productDao.searchProductList(keywords);
	}

	public List getProduct(String productNumber) {
		return this.productDao.getProduct(productNumber);
	}

	public List getItemListByProduct(String productNumber) {
		return this.itemDao.getItemListByProduct(productNumber);
	}

	public List getItem(String itemName) {
		return this.itemDao.getItem(itemName);
	}

	public int getItemQuantity(String itemName) {
		return this.itemDao.getItemQuantity(itemName);
	}

	public List getItem(Item item) {
		return this.itemDao.getItem(item);
	}

	public boolean isItemInStock(String itemName) {
		return this.itemDao.isItemInStock(itemName);
	}

	public void insertOrder(Order order) {
		this.orderDao.insertOrder(order);
		this.itemDao.updateQuantity(order);
	}

	public Order getOrder(int id) {
		return this.orderDao.getOrder(id);
	}

	public List getOrderAndUserName(long id) {
		return this.orderDao.getOrderAndUserName(id);
	}

	public List getOrdersByUsername(String username) {
		return this.orderDao.getOrdersByUsername(username);
	}
	
	public List getAllItem(){
		return this.itemDao.getAllItem();
	}

}
