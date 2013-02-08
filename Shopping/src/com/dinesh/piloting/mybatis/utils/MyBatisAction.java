package com.dinesh.piloting.mybatis.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dinesh.piloting.mybatis.model.User;
import com.dinesh.piloting.mybatis.model.UserMapper;

public class MyBatisAction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.selectUser(1);
			System.out.println(user.getFirstname());
		} finally {
			session.close();
		}
	}
	/**
	 * 
	 * @return
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		SqlSessionFactory sqlSessionFactory = null;
		try {
			String resource = "com/dinesh/piloting/mybatis/resources/config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return sqlSessionFactory;
	}
	

}
