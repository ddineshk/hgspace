package org.ddk.spring.store.dao.hibernate;

import java.util.List;

import org.ddk.spring.store.dao.CategoryDao;
import org.ddk.spring.store.domain.Category;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateCategoryDao extends HibernateDaoSupport implements CategoryDao {

	public List getCategoryList() throws DataAccessException {
		return getHibernateTemplate().find("from Category");
	}

	public Category getCategory(String categoryName) throws DataAccessException {
		Category category = null;
		List ls = getHibernateTemplate().find("from Category cat where cat.categoryName = ?", categoryName);

		if (ls != null && ls.size() > 0) {
			category = (Category) ls.get(0);
		}
		return category;
	}
}
