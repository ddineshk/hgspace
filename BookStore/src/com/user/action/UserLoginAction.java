package com.user.action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

public class UserLoginAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5284222344299192877L;
	private UserService userServiceImpl;
	private String name;
	private String password;
	private HttpSession session = null;
	private HttpServletRequest request = null; 
	private List<User>users = new ArrayList<User>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	@Override
	public String execute() throws Exception {
		String userName = getName();
		String userPassword = getPassword();
		request = ServletActionContext.getRequest();
		session = request.getSession();
		
		users = userServiceImpl.setUserCertification(userName, userPassword);
		if(users.isEmpty()){
			return ERROR;
		}else{
			for(User user:users){
				session.setAttribute("user", user);
			}
			
			session.setAttribute("userName", userName);
			return SUCCESS;
		}
		
	}

	public List getUsers() {
		return users;
	}

	public void setUsers(List users) {
		this.users = users;
	}
}
