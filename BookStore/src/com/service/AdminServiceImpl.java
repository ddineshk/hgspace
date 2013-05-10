package com.service;

import java.util.List;

import com.dao.AdminDAOImpl;

public class AdminServiceImpl implements AdminService{
	
	private AdminDAOImpl adminDAOImpl;
	

	public AdminDAOImpl getAdminDAOImpl() {
		return adminDAOImpl;
	}


	public void setAdminDAOImpl(AdminDAOImpl adminDAOImpl) {
		this.adminDAOImpl = adminDAOImpl;
	}


	@Override
	public List setAdminCertification(String name, String password) {
		return adminDAOImpl.setAdminCertification(name, password);
	}

}
