package com.dinesh.piloting.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1769677453409836371L;
	private String userName;
	private String passWord;
	
	public String execute(){
		if(this.userName.equals("admin") && this.passWord.equals("admin123")){
			return "success";
		}else{
			addActionError(getText("error.login"));
			return "error";
		}
	}

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
	 * @return the passWord
	 */
	public String getPassWord() {
		return passWord;
	}

	/**
	 * @param passWord the passWord to set
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
