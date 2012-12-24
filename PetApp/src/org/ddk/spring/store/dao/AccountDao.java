package org.ddk.spring.store.dao;

import java.util.List;

import org.ddk.spring.store.domain.Account;
import org.springframework.dao.DataAccessException;

public interface AccountDao {

	Account getAccount(String username) throws DataAccessException;

	List getAccount(String username, String password)throws DataAccessException;

	String getBannerNameForUser(String username);

	void insertAccount(Account account) throws DataAccessException;

	void updateAccount(Account account) throws DataAccessException;

	List getUsernameList() throws DataAccessException;

}
