package com.configman.action;

import com.opensymphony.xwork2.ActionSupport;
import com.service.ConfigmanServiceImpl;

public class MainAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3285337648303175076L;
	private ConfigmanServiceImpl configmanServiceImpl;
	
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
		System.out.println(configmanServiceImpl.getAllApps().size());
		return ERROR;
	}

}
