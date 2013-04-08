package org.ddk.spring.store.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class Order implements java.io.Serializable, Comparable<Object> {

	private static final long serialVersionUID = 3679881963983561529L;
	private Long id;
	private int version;
	private Account user;
	private Date orderDate;
	private Address shipAddr;
	private Address billAddr;
	private String courier;
	private Double totalPrice;
	private String billToFirstname;
	private String billToLastname;
	private String shipToFirstname;
	private String shipToLastname;
	private String cardNumber;
	private String expireDate;
	private String cardType;
	private ShipStatus shipStatus;
	private Locale locale;

	private List lineItems = new ArrayList();

	public Order() {
	}

	public Long getId() {
		return id;
	}

	public int getVersion() {
		return version;
	}

	public Account getUser() {
		return user;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public Address getShipAddr() {
		return shipAddr;
	}

	public void setShipAddr(Address shipAddr) {
		this.shipAddr = shipAddr;
	}

	public Address getBillAddr() {
		return billAddr;
	}

	public void setBillAddr(Address billAddr) {
		this.billAddr = billAddr;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public String getBillToFirstname() {
		return billToFirstname;
	}

	public void setBillToFirstname(String billToFirstname) {
		this.billToFirstname = billToFirstname;
	}

	public String getBillToLastname() {
		return billToLastname;
	}

	public void setBillToLastname(String billToLastname) {
		this.billToLastname = billToLastname;
	}

	public String getShipToFirstname() {
		return shipToFirstname;
	}

	public void setShipToFirstname(String shipToFirstname) {
		this.shipToFirstname = shipToFirstname;
	}

	public String getShipToLastname() {
		return shipToLastname;
	}

	public void setShipToLastname(String shipToLastname) {
		this.shipToLastname = shipToLastname;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public ShipStatus getShipStatus() {
		return shipStatus;
	}

	public void setShipStatus(ShipStatus shipStatus) {
		this.shipStatus = shipStatus;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public List getLineItems() {
		return lineItems;
	}

	public void setLineItems(List lineItems) {
		this.lineItems = lineItems;
	}

	public void addLineItem(CartItem cartItem) {
		LineItem lineItem = new LineItem(getLineItems().size() + 1, cartItem);
		addLineItem(lineItem);
	}

	public void addLineItem(LineItem lineItem) {
		if (lineItem == null) {
			throw new IllegalArgumentException("Can't add a null lineItem.");
		}

		getLineItems().add(lineItem);
	}

	public void initOrder(Account account, Cart cart) {
		user = account;
		orderDate = new Date();

		Address ua = user.getUserAddr();

		shipAddr = new Address(ua);
		billAddr = new Address(ua);

		shipToFirstname = user.getFirstname();
		shipToLastname = user.getLastname();
		billToFirstname = user.getFirstname();
		billToLastname = user.getLastname();

		totalPrice = cart.getSubTotal();

		cardNumber = "999 9999 9999 9999";
		expireDate = "12/2008";
		cardType = "Visa";
		setCourier("UPS");
		setLocale(Locale.CANADA);
		shipStatus = ShipStatus.PENDING;

		Iterator i = cart.getAllCartItems();
		while (i.hasNext()) {
			CartItem cartItem = (CartItem) i.next();
			addLineItem(cartItem);
		}
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof Order)) {
			return false;
		}

		final Order order = (Order) o;
		if (!(this.getTotalPrice().equals(order.getTotalPrice())))
			return false;
		return this.getOrderDate().getTime() == order.getOrderDate().getTime();
	}

	public int hashCode() {
		return getOrderDate().hashCode();
	}

	public String toString() {
		return "Order (" + getId().toString() + "), " + "Order Date: "
				+ getOrderDate() + " " + "Total Price: " + getTotalPrice();
	}

	public int compareTo(Object o) {
		if (o instanceof Order) {
			return Long.valueOf(this.getOrderDate().getTime()).compareTo(
					Long.valueOf(((Order) o).getOrderDate().getTime()));
		}

		return 0;
	}

}
