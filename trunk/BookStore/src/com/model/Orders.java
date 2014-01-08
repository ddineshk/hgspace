package com.model;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9162296195715379475L;
	private Integer id;
	private  String orderNumber;
	private User user;
	private Integer totalPrice;
	private Date  orderTime;
	private String isDealed;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getIsDealed() {
		return isDealed;
	}
	public void setIsDealed(String isDealed) {
		this.isDealed = isDealed;
	}
}
