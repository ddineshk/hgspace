package org.ddk.spring.store.domain;

import java.util.HashSet;
import java.util.Set;

public class Account implements java.io.Serializable, Comparable<Object> {
	private static final long serialVersionUID = 6652230777796935035L;
	private Long id;
	private int version;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String status;
	private Address userAddr;
	private String phone;
	private String langPreference;
	private Category favCategory;
	private boolean displayMyList = false;
	private boolean displayBanner = false;

	private Set orders = new HashSet();

	public Account() {
	}

	public Long getId() {
		return id;
	}

	public int getVersion() {
		return version;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLangPreference() {
		return langPreference;
	}

	public void setLangPreference(String langPreference) {
		this.langPreference = langPreference;
	}

	public Category getFavCategory() {
		return favCategory;
	}

	public void setFavCategory(Category favCategory) {
		this.favCategory = favCategory;
	}

	public boolean isDisplayBanner() {
		return displayBanner;
	}

	public void setDisplayBanner(boolean displayBanner) {
		this.displayBanner = displayBanner;
	}

	/**
	 * @return the displayMyList
	 */
	public boolean isDisplayMyList() {
		return displayMyList;
	}
	
	public boolean getDisplayMyList(){
		return displayMyList;
	}

	/**
	 * @param displayMyList the displayMyList to set
	 */
	public void setDisplayMyList(boolean displayMyList) {
		this.displayMyList = displayMyList;
	}

	public Address getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(Address userAddr) {
		this.userAddr = userAddr;
	}

	public Set getOrders() {
		return orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

	public void addOrder(Order order) {
		if (order == null)
			throw new IllegalArgumentException("Can't add a null Order.");
		this.getOrders().add(order);
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof Account)) {
			return false;
		}

		final Account user = (Account) o;
		return getUsername().equals(user.getUsername());
	}

	public int hashCode() {
		return getUsername().hashCode();
	}

	public String toString() {
		return "User (" + getId() + "), Username: " + getUsername();
	}

	public int compareTo(Object o) {
		if (o instanceof Account) {
			return getUsername().compareTo(((Account) o).getUsername());
		}

		return 0;
	}
}
