package org.ddk.spring.store.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.support.PagedListHolder;

public class Cart implements Serializable {
	private static final long serialVersionUID = -4007908519271229769L;
	private final Map itemMap = Collections.synchronizedMap(new HashMap());
	private final PagedListHolder itemList = new PagedListHolder();
	public HashMap<String, List> allItems = new HashMap<String, List>();

	/**
	 * @return the allItems
	 */
	public HashMap<String, List> getAllItems() {
		return allItems;
	}

	/**
	 * @param allItems the allItems to set
	 */
	public void setAllItems(HashMap<String, List> allItems) {
		this.allItems = allItems;
	}

	public Cart() {
		this.itemList.setPageSize(4);
	}

	public Iterator getAllCartItems() {
		return itemList.getSource().iterator();
	}

	public PagedListHolder getCartItemList() {
		return itemList;
	}

	public int getNumberOfItems() {
		return itemList.getSource().size();
	}

	public boolean containsItemName(String itemName) {
		return itemMap.containsKey(itemName);
	}

	public void addItem(Item item, boolean isInStock) {
		CartItem cartItem = (CartItem) itemMap.get(item.getItemName());
		if (cartItem == null) {
			cartItem = new CartItem();
			cartItem.setItem(item);
			cartItem.setQuantity(0);
			cartItem.setInStock(isInStock);
			itemMap.put(item.getItemName(), cartItem);
			itemList.getSource().add(cartItem);
		}
		cartItem.incrementQuantity();
	}

	public Item removeItemByName(String itemName) {
		CartItem cartItem = (CartItem) itemMap.remove(itemName);
		if (cartItem == null) {
			return null;
		} else {
			itemList.getSource().remove(cartItem);
			return cartItem.getItem();
		}
	}

	public void incrementQuantityByItemName(String itemName) {
		CartItem cartItem = (CartItem) itemMap.get(itemName);
		cartItem.incrementQuantity();
	}

	public void setQuantityByItemName(String itemName, int quantity) {
		CartItem cartItem = (CartItem) itemMap.get(itemName);
		cartItem.setQuantity(quantity);
	}

	public Double getSubTotal() {
		Double subTotal = new Double(0.0);
		Iterator items = getAllCartItems();
		while (items.hasNext()) {
			CartItem cartItem = (CartItem) items.next();
			Item item = cartItem.getItem();
			Double listPrice = item.getListPrice();
			int quantity = cartItem.getQuantity();
			subTotal = subTotal+(listPrice*quantity);
		}
		return subTotal;
	}

}
