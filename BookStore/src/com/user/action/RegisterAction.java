package com.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

public class RegisterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3166908923719708312L;

	private UserService userServiceImpl;

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User inuser = new User();
		inuser.setName(user.getName());
		inuser.setUserRealName(user.getUserRealName());
		inuser.setPassword(user.getPassword());
		inuser.setAddress(user.getAddress());
		inuser.setPhone(user.getPhone());
		inuser.setMobilePhone(user.getMobilePhone());
		inuser.setEmail(user.getEmail());

		userServiceImpl.insert(inuser);
		
		session.setAttribute("user", inuser);

		return SUCCESS;

	}

}
