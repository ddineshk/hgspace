package com.dinesh.piloting.mybatis.model;

import java.io.Serializable;


/**
 * The persistent class for the "user" database table.
 * 
 */

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1945664037798968202L;

	private String addr1;

	private String addr2;

	private String city;

	private String country;

	private boolean displayBanner;

	private boolean displayMylist;

	private String email;

	private int favCategoryId;

	private String firstname;

	private String langPreference;

	private String lastname;

	private String password;

	private String phone;

	private String state;

	private String status;

	private int userId;

	private String username;

	private String zipcode;

	public User() {
	}

	public String getAddr1() {
		return this.addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return this.addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public boolean getDisplayBanner() {
		return this.displayBanner;
	}

	public void setDisplayBanner(boolean displayBanner) {
		this.displayBanner = displayBanner;
	}

	public boolean getDisplayMylist() {
		return this.displayMylist;
	}

	public void setDisplayMylist(boolean displayMylist) {
		this.displayMylist = displayMylist;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getFavCategoryId() {
		return this.favCategoryId;
	}

	public void setFavCategoryId(int favCategoryId) {
		this.favCategoryId = favCategoryId;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLangPreference() {
		return this.langPreference;
	}

	public void setLangPreference(String langPreference) {
		this.langPreference = langPreference;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}