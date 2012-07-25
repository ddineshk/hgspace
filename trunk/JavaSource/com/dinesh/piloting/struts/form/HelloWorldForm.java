package com.dinesh.piloting.struts.form;

import org.apache.struts.action.ActionForm;

public class HelloWorldForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 507856680375220041L;
	private String message = null;
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	} 


}
