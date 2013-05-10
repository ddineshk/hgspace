package com.service;

import java.util.List;

import com.model.User;

public interface UserService {
	void insert(User user);
	List setUserCertification(String name,String password);
	List<User> queryAllUser();
	void updateUserInfo(User user);

}
