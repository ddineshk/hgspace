package com.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

public class UserInfoManagerAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2483834597718837245L;
	private UserService userServiceImpl;
	private String userRealName;
	// private String password;
	private String address;
	private String email;
	private String phone;
	private String mobilePhone;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");

		user.setUserRealName(userRealName);
		user.setEmail(email);
		user.setPhone(phone);
		user.setMobilePhone(mobilePhone);
		user.setAddress(address);

		userServiceImpl.updateUserInfo(user);
		session.removeAttribute("user");
		session.setAttribute("user", user);

		return SUCCESS;
	}

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

}
