package com.service;

import java.util.List;

import com.dao.ConfigmanDAOImpl;
import com.model.Application;

public class ConfigmanServiceImpl implements ConfigmanService {
	
	public ConfigmanDAOImpl configmanDAOImpl;
	
	@Override
	public List<Application> getAllApps() {
		return configmanDAOImpl.getAllApps();
	}

	/**
	 * @return the configmanDAOImpl
	 */
	public ConfigmanDAOImpl getConfigmanDAOImpl() {
		return configmanDAOImpl;
	}

	/**
	 * @param configmanDAOImpl the configmanDAOImpl to set
	 */
	public void setConfigmanDAOImpl(ConfigmanDAOImpl configmanDAOImpl) {
		this.configmanDAOImpl = configmanDAOImpl;
	}

	@Override
	public List setConfigmanCertification(String userName, String password) {
		return configmanDAOImpl.setConfigmanCertification(userName, password);
	}

	
}
