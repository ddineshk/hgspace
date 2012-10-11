package com.dinesh.piloting.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8128886101820490592L;
	private String userName;
    private String password;
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
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
        ActionErrors actionErrors = new ActionErrors();
        
        if(userName == null || userName.trim().equals("")) {
            actionErrors.add("userName", new ActionMessage("error.username"));
        }
        try {
        if(password == null || password.trim().equals("")) {
            actionErrors.add("password", new ActionMessage("error.password"));
        }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return actionErrors ;
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
	}
}
