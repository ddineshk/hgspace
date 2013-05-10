package com.admin.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.service.AdminService;

public class AdminLoginAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 85743648863498931L;

	private AdminService adminServiceImpl;
	private String name;
	private String password;
	private HttpSession session = null;
	private HttpServletRequest request = null;

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

	public AdminService getAdminServiceImpl() {
		return adminServiceImpl;
	}

	public void setAdminServiceImpl(AdminService adminServiceImpl) {
		this.adminServiceImpl = adminServiceImpl;
	}

	@Override
	public String execute() throws Exception {
		String inname = getName();
		String inpassword = getPassword();
		request = ServletActionContext.getRequest();
		session = request.getSession();
		List admins = adminServiceImpl.setAdminCertification(inname, inpassword);
		if(admins.isEmpty()){
			return ERROR;
		}else{
			session.setAttribute("AdminName", inname);
			
			return SUCCESS;
		}
	}
}
