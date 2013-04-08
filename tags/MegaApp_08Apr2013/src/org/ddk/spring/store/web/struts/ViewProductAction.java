package org.ddk.spring.store.web.struts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.ddk.spring.store.domain.Item;
import org.ddk.spring.store.domain.Product;
import org.springframework.beans.support.PagedListHolder;

public class ViewProductAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String productNumber = request.getParameter("productNumber");
		if (productNumber != null) {
			PagedListHolder itemList = new PagedListHolder(getStore().getItemListByProduct(productNumber));
			itemList.setPageSize(4);
			List newSource = new ArrayList();
			List objSource = itemList.getSource();
			Item item = null;
			for (Iterator itr = objSource.iterator(); itr.hasNext();) {
				Object[] object = (Object[]) itr.next();
				item = new Item();
				item.setId((Long) object[0]);
				item.setVersion((Integer) object[1]);
				item.setItemName((String) object[2]);

				item.setListPrice((Double) object[4]);
				item.setAttr1((String) object[8]);
				item.setAttr2((String) object[9]);
				item.setAttr3((String) object[10]);
				item.setAttr4((String) object[11]);
				item.setAttr5((String) object[12]);

				newSource.add(item);
			}
			itemList.setSource(newSource);
			List list = getStore().getProduct(productNumber);
			Product product = null;
			String categoryName = null;
			for (Iterator it = list.iterator(); it.hasNext();) {
				Object[] pair = (Object[]) it.next();
				product = (Product) pair[0];
				categoryName = (String) pair[1];
			}

			request.getSession().setAttribute("ViewProductAction_itemList",itemList);
			request.getSession().setAttribute("ViewProductAction_product",product);
			request.setAttribute("itemList", itemList);
			request.setAttribute("product", product);
			request.setAttribute("categoryName", categoryName);

		} else {
			PagedListHolder itemList = (PagedListHolder) request.getSession().getAttribute("ViewProductAction_itemList");
			Product product = (Product) request.getSession().getAttribute("ViewProductAction_product");
			String page = request.getParameter("page");
			if ("next".equals(page)) {
				itemList.nextPage();
			} else if ("previous".equals(page)) {
				itemList.previousPage();
			}
			request.setAttribute("itemList", itemList);
			request.setAttribute("product", product);
		}
		saveToken(request);
		return mapping.findForward("success");
	}
}
