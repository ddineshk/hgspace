package com.dao;

import java.util.List;

import com.model.Application;

public interface ConfigmanDAO {
	public List<Application> getAllApps();
	
	public List setConfigmanCertification(String userName,String password);
}
