package com.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class AdminLogoutAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8494459738364097228L;
	private HttpSession session;
	private HttpServletRequest request;

	@Override
	public String execute() throws Exception {
		request = ServletActionContext.getRequest();
		session = request.getSession();
	    session.removeAttribute("AdminName");
	    session.invalidate();
		return SUCCESS;
	}
}
