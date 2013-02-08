package com.dinesh.piloting.mybatis.model;

import java.io.Serializable;

import java.util.Date;


/**
 * The persistent class for the "orders" database table.
 * 
 */

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6434890124339341653L;

	private String billAddr1;

	private String billAddr2;

	private String billCity;

	private String billCountry;

	private String billState;

	private String billToFirstname;

	private String billToLastname;

	private String billZipcode;

	private String cardNumber;

	private String cardType;

	private String courier;

	private String expireDate;

	private String locale;

	private Date orderDate;

	private int orderId;

	private String shipAddr1;

	private String shipAddr2;

	private String shipCity;

	private String shipCountry;

	private String shipState;

	private String shipStatus;

	private String shipToFirstname;

	private String shipToLastname;

	private String shipZipcode;

	private String totalPrice;

	private String userId;

	public Order() {
	}

	public String getBillAddr1() {
		return this.billAddr1;
	}

	public void setBillAddr1(String billAddr1) {
		this.billAddr1 = billAddr1;
	}

	public String getBillAddr2() {
		return this.billAddr2;
	}

	public void setBillAddr2(String billAddr2) {
		this.billAddr2 = billAddr2;
	}

	public String getBillCity() {
		return this.billCity;
	}

	public void setBillCity(String billCity) {
		this.billCity = billCity;
	}

	public String getBillCountry() {
		return this.billCountry;
	}

	public void setBillCountry(String billCountry) {
		this.billCountry = billCountry;
	}

	public String getBillState() {
		return this.billState;
	}

	public void setBillState(String billState) {
		this.billState = billState;
	}

	public String getBillToFirstname() {
		return this.billToFirstname;
	}

	public void setBillToFirstname(String billToFirstname) {
		this.billToFirstname = billToFirstname;
	}

	public String getBillToLastname() {
		return this.billToLastname;
	}

	public void setBillToLastname(String billToLastname) {
		this.billToLastname = billToLastname;
	}

	public String getBillZipcode() {
		return this.billZipcode;
	}

	public void setBillZipcode(String billZipcode) {
		this.billZipcode = billZipcode;
	}

	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCourier() {
		return this.courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public String getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getLocale() {
		return this.locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getShipAddr1() {
		return this.shipAddr1;
	}

	public void setShipAddr1(String shipAddr1) {
		this.shipAddr1 = shipAddr1;
	}

	public String getShipAddr2() {
		return this.shipAddr2;
	}

	public void setShipAddr2(String shipAddr2) {
		this.shipAddr2 = shipAddr2;
	}

	public String getShipCity() {
		return this.shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public String getShipCountry() {
		return this.shipCountry;
	}

	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}

	public String getShipState() {
		return this.shipState;
	}

	public void setShipState(String shipState) {
		this.shipState = shipState;
	}

	public String getShipStatus() {
		return this.shipStatus;
	}

	public void setShipStatus(String shipStatus) {
		this.shipStatus = shipStatus;
	}

	public String getShipToFirstname() {
		return this.shipToFirstname;
	}

	public void setShipToFirstname(String shipToFirstname) {
		this.shipToFirstname = shipToFirstname;
	}

	public String getShipToLastname() {
		return this.shipToLastname;
	}

	public void setShipToLastname(String shipToLastname) {
		this.shipToLastname = shipToLastname;
	}

	public String getShipZipcode() {
		return this.shipZipcode;
	}

	public void setShipZipcode(String shipZipcode) {
		this.shipZipcode = shipZipcode;
	}

	public String getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}