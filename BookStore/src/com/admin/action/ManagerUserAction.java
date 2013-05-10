package com.admin.action;

import com.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class ManagerUserAction  extends ActionSupport{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 3962243008992994600L;
	private UserService userServiceImpl;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		List<User>users = userServiceImpl.queryAllUser();
		session.setAttribute("users", users);
		return SUCCESS;
	}
	
	public String deleteUser(){
		return SUCCESS;
	}

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
}
