package com.dinesh.piloting.mybatis.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dinesh.piloting.mybatis.model.UserMapper;

public class MyBatisUtils {

	/**
	 * 
	 * @return
	 */
	public static SqlSession getSqlSession() {
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;
		Reader reader = null;
		try {
			String resource = "com/dinesh/piloting/mybatis/resources/config.xml";
			reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);
			session = sqlSessionFactory.openSession();
			
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return session;
	}
	

}
