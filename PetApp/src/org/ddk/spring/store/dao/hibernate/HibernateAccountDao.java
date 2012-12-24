package org.ddk.spring.store.dao.hibernate;

import java.util.List;

import org.ddk.spring.store.dao.AccountDao;
import org.ddk.spring.store.domain.Account;
import org.hibernate.LockMode;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateAccountDao extends HibernateDaoSupport implements AccountDao {
	public Account getAccount(String username) throws DataAccessException {
		Account account = null;
		List ls = getHibernateTemplate().find("select user from Account user, Banner banner "
						+ "where user.favCategory.categoryName = banner.favCategory.categoryName "
						+ "and user.username = ?", username);
		if (ls != null && ls.size() > 0) {
			account = (Account) ls.get(0);
		}
		return account;
	}

	public List getAccount(String username, String password)
			throws DataAccessException {
		String[] paramsName = { "username", "password" };
		String[] paramsVal = { username, password };

		List ls = getHibernateTemplate().findByNamedParam("select user, user.favCategory.categoryName from Account user "
								+ "where user.username = :username and user.password = :password",paramsName, paramsVal);
		return ls;
	}

	public String getBannerNameForUser(String username) throws DataAccessException {
		String bannerName = null;

		List ls = getHibernateTemplate().find("select banner.bannerName "
						+ "from Account user, Banner banner "
						+ "where user.favCategory.id = banner.favCategory.id and "
						+ "user.username = ?", username);

		if (ls != null && ls.size() > 0) {
			bannerName = (String) ls.get(0);
		}

		return bannerName;
	}

	public void insertAccount(Account account) throws DataAccessException {
		getHibernateTemplate().persist(account);
	}

	public void updateAccount(Account account) throws DataAccessException {
		if (account.getPassword() != null && account.getPassword().length() > 0) {
			getHibernateTemplate().update(account, LockMode.UPGRADE);
		}
	}

	public List getUsernameList() throws DataAccessException {
		return getHibernateTemplate().find("select user.username from Account user");
	}

}
