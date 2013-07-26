package com.service;

import java.util.List;

import com.model.Application;

public interface ConfigmanService {
	List<Application> getAllApps();
	
	List setConfigmanCertification(String userName,String password);
}
