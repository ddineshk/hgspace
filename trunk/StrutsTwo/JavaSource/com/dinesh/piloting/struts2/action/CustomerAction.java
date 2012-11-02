package com.dinesh.piloting.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -580473268178728462L;
	private String name;
    private Integer age;
    private String email;
    private String telephone;
    
    /**
     * @return SUCCESS
     */
    public String addCustomer(){
    	return SUCCESS;
    }
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
