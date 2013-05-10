package com.service;

import java.util.List;

import com.dao.UserDAOImpl;
import com.model.User;

public class UserServiceImpl implements UserService {

	private UserDAOImpl userDAOImpl;

	public UserDAOImpl getUserDAOImpl() {
		return userDAOImpl;
	}

	public void setUserDAOImpl(UserDAOImpl userDAOImpl) {
		this.userDAOImpl = userDAOImpl;
	}

	@Override
	public void insert(User user) {
		userDAOImpl.insert(user);
	}

	@Override
	public List setUserCertification(String name, String password) {
		return userDAOImpl.setUserCertification(name, password);
	}

	@Override
	public List<User> queryAllUser() {
		return userDAOImpl.queryAllUser();
	}

	@Override
	public void updateUserInfo(User user) {
		userDAOImpl.updateUserInfo(user);
	}

}
