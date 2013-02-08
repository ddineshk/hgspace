package com.dinesh.piloting.mybatis.model;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {
	@Select("SELECT * FROM User WHERE userId = #{id}")
	User selectUser(int id);
}