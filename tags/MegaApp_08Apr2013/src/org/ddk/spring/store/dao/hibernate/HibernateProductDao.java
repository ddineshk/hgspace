package org.ddk.spring.store.dao.hibernate;

import java.util.List;
import java.util.Scanner;

import org.ddk.spring.store.dao.ProductDao;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateProductDao extends HibernateDaoSupport implements
		ProductDao {

	public List getProductListByCategory(String categoryName)
			throws DataAccessException {
		return getHibernateTemplate().find("from Product product where product.category.categoryName = ?",
				categoryName);
	}

	public List getProduct(String productNumber) throws DataAccessException {
		return getHibernateTemplate().find("select p , c.categoryName " + "from Product p, Category c "
						+ "where c.id = p.category.id and p.productNumber = ?",productNumber);
	}

	public List searchProductList(String keywords)
			throws DataAccessException {
		StringBuilder likeString = new StringBuilder();

		Scanner s = new Scanner(keywords);
		while (s.hasNext()) {
			String keyword = s.next().toUpperCase();
			likeString.append("upper(p.productName) like '%" + keyword + "%'");
			likeString.append(" OR upper(p.productDesc) like '%" + keyword+ "%'");
			likeString.append(" OR upper(c.categoryName) like '%" + keyword+ "%'");
		}
		s.close();
		return getHibernateTemplate().find(
				"select distinct p " + "from Product p, Category c "+ "where c.id = p.category.id and ( "+ likeString.toString() + " )");
	}

}
