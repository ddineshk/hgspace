package com.dinesh.piloting.mybatis.form;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5331720564502236325L;
	String userName = null;
	String password = null;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
