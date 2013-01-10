package org.ddk.spring.store.web.struts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.ddk.spring.store.domain.Category;
import org.ddk.spring.store.domain.Item;
import org.ddk.spring.store.domain.Product;

public class MyDefaultAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getParameter("invalidate") != null && request.getParameter("invalidate").toString().equals("true")) {
			request.getSession().invalidate();
		}
		List ls = getStore().getAllItem();
		List catLs = getStore().getCategoryList();
		HashMap<String,ArrayList> allList= new HashMap<String,ArrayList>();
		ArrayList tmpLs = null;
		Item item = null;
		Product product = null;
		String category = null;
		Object[] object = null;
		for (Object obj : catLs) {
			tmpLs = new ArrayList();
			category = ((Category)obj).getCategoryName();
			for (Iterator iterator = ls.iterator(); iterator.hasNext();) {
				object = (Object[]) iterator.next();
				if(((String)object[19]).equals(category)){
					item = new Item();
					item.setId((Long)object[0]);
					item.setVersion((Integer)object[1]);
					item.setItemName((String)object[2]);
					product = new Product();
					product.setId((Long)object[3]);
					item.setListPrice((Double)object[4]);
					item.setUnitCost((Double)object[5]);
					item.setStatus((String)object[7]);
					item.setAttr1((String)object[8]);
					item.setAttr2((String)object[9]);
					item.setAttr3((String)object[10]);
					item.setAttr4((String)object[11]);
					item.setAttr5((String)object[12]);
					product.setVersion((Integer)object[14]);
					product.setProductNumber((String)object[15]);
					product.setProductName((String)object[17]);
					product.setProductDesc((String)object[18]);
					item.setProduct(product);
					tmpLs.add(item);
				}
			}
			allList.put(category, tmpLs);
		}
		request.getSession().setAttribute("allList", allList);
		
		return mapping.findForward("success");
	}
}
