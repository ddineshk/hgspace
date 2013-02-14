package com.dinesh.piloting.mybatis.model;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
	@Select("SELECT * FROM User WHERE userId = #{id}")
	User selectUser(int id);
	@Select("SELECT * FROM User WHERE userName = #{userName} AND password = #{password}")
	User selectUsers(@Param("userName")String userName,@Param("password")String password);
	
}