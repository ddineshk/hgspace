package com.configman.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ConfigmanServiceImpl;

public class ConfigmanLoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9066808709514507567L;

	private ConfigmanServiceImpl configmanServiceImpl = null;
	
	private String name;
	private String password;
	private HttpSession session = null;
	private HttpServletRequest request = null; 
	private List<User>users = new ArrayList<User>();

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

	/**
	 * @return the session
	 */
	public HttpSession getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @param request the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * @return the configmanServiceImpl
	 */
	public ConfigmanServiceImpl getConfigmanServiceImpl() {
		return configmanServiceImpl;
	}

	/**
	 * @param configmanServiceImpl the configmanServiceImpl to set
	 */
	public void setConfigmanServiceImpl(ConfigmanServiceImpl configmanServiceImpl) {
		this.configmanServiceImpl = configmanServiceImpl;
	}
	
	@Override
	public String execute() throws Exception {
		String userName = getName();
		String userPassword = getPassword();
		request = ServletActionContext.getRequest();
		session = request.getSession();
		users = configmanServiceImpl.setConfigmanCertification(userName, userPassword);
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
	
}
