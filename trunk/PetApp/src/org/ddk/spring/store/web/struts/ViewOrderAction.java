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
import org.ddk.spring.store.domain.LineItem;
import org.ddk.spring.store.domain.Order;

public class ViewOrderAction extends SecureBaseAction {

	protected ActionForward doExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		AccountActionForm acctForm = (AccountActionForm) form;
		long id = Integer.parseInt(request.getParameter("id"));
		List list = getStore().getOrderAndUserName(id);
		Order order = null;
		String username = null;
		for (Iterator it = list.iterator(); it.hasNext();) {
			Object[] pair = (Object[]) it.next();
			order = (Order) pair[0];
			username = (String) pair[1];
		}

		List items = new ArrayList();
		List productNames = new ArrayList();

		List ls = order.getLineItems();
		for (int k = 0; k < ls.size(); k++) {
			LineItem li = (LineItem) ls.get(k);
			Item i = li.getItem();
			Object[] pair = (Object[]) getStore().getItem(i).get(0);
			Item item = (Item) pair[0];
			String pn = (String) pair[1];
			items.add(item);
			productNames.add(pn);
		}
		request.setAttribute("items", items);
		request.setAttribute("productNames", productNames);
		if (acctForm.getAccount().getUsername().equals(username)) {
			request.setAttribute("order", order);
			request.setAttribute("viewOrder", true);
			return mapping.findForward("success");
		} else {
			request.setAttribute("message","You may only view your own orders.");
			return mapping.findForward("failure");
		}
	}
}
