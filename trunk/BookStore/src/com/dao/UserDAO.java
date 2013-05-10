package com.dao;

import java.util.List;

import com.model.User;

public interface UserDAO {
	
	
	void insert(User user);
	List setUserCertification(String name,String password);
	List<User> queryAllUser();
	void updateUserInfo(User user);
	

}
