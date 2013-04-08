package org.ddk.spring.store.dao.hibernate;

import java.util.List;

import org.ddk.spring.store.dao.ItemDao;
import org.ddk.spring.store.domain.Inventory;
import org.ddk.spring.store.domain.Item;
import org.ddk.spring.store.domain.LineItem;
import org.ddk.spring.store.domain.Order;
import org.hibernate.LockMode;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateItemDao extends HibernateDaoSupport implements ItemDao {

	public void updateQuantity(Order order) throws DataAccessException {
		for (int i = 0; i < order.getLineItems().size(); i++) {
			LineItem lineItem = (LineItem) order.getLineItems().get(i);
			Item item = lineItem.getItem();
			Integer increment = new Integer(lineItem.getQuantity());

			List ls = getHibernateTemplate().find("from Inventory inv where inv.item.itemName = ?",item.getItemName());
			if (ls != null && ls.size() > 0) {
				Inventory inv = (Inventory) ls.get(0);
				inv.setQuantity(inv.getQuantity() - increment);
				getHibernateTemplate().saveOrUpdate(inv);
			}
		}
	}

	public boolean isItemInStock(String itemName) throws DataAccessException {
		boolean result = false;

		List ls = getHibernateTemplate().find("select inv.quantity from Inventory inv where inv.item.itemName = ?", itemName);
		if (ls != null && ls.size() > 0) {
			Integer i = (Integer) ls.get(0);
			result = (i != null && i.intValue() > 0);
		}
		return result;
	}

	public List getItemListByProduct(String productNumber)
			throws DataAccessException {
		List list = getHibernateTemplate().find("select item.id, item.version, item.itemName," +
				"item.product.id, item.listPrice, item.unitCost, item.supplier.id, item.status," +
				"item.attr1, item.attr2, item.attr3, item.attr4, item.attr5, product.productNumber from Item item, Product product "
				+ "where item.product.id = product.id " + "and product.productNumber = ?", productNumber);
		return list;
	}
	public List getItem(String itemName) throws DataAccessException {
		List ls = getHibernateTemplate().find("select item.id, item.version, item.itemName," +
				"item.product.id, item.listPrice, item.unitCost, item.supplier.id, item.status," +
				"item.attr1, item.attr2, item.attr3, item.attr4, item.attr5, product.id, product.version," +
				"product.productNumber,product.category.id, product.productName, product.productDesc from Item item, Product product "
						+ "where item.product.id = product.id and item.itemName = ?", itemName);

		return ls;
	}
	public List getItem(Item item) throws DataAccessException {
		getHibernateTemplate().lock(item, LockMode.NONE);
		List ls = getHibernateTemplate().find("select item, item.product.productName " + "from Item item "
						+ "where item.id = ?", item.getId());

		return ls;
	}
	
	public int getItemQuantity(String itemName) throws DataAccessException {
		int quantity = 0;

		List ls = getHibernateTemplate().find("select inv.quantity from Item item, Inventory inv "
						+ "where inv.item.id = item.id and item.itemName = ?",itemName);

		if (ls != null && ls.size() > 0) {
			Integer i = (Integer) ls.get(0);

			quantity = i == null ? 0 : i.intValue();
		}

		return quantity;
	}
	public List getAllItem() throws DataAccessException {
		List list = getHibernateTemplate().find("select item.id, item.version, item.itemName," +
				"item.product.id, item.listPrice, item.unitCost, item.supplier.id, item.status," +
				"item.attr1, item.attr2, item.attr3, item.attr4, item.attr5, product.id, product.version," +
				"product.productNumber,product.category.id, product.productName, product.productDesc, category.categoryName " +
				"from Item item, Product product,Category category "+ 
				"where item.product.id = product.id and product.category.id = category.id");
		return list;
	}
}
