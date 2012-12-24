package org.ddk.spring.store.web.struts;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.ddk.spring.store.domain.Cart;
import org.ddk.spring.store.domain.Item;
import org.ddk.spring.store.domain.Product;

public class AddItemToCartAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (!isTokenValid(request, true)) {
			request.setAttribute("message", "test");
			return mapping.findForward("failure");
		} else {
			CartActionForm cartForm = (CartActionForm) form;
			Cart cart = cartForm.getCart();
			String workingItemName = cartForm.getWorkingItemName();
			if (cart.containsItemName(workingItemName)) {
				cart.incrementQuantityByItemName(workingItemName);
			} else {
				boolean isInStock = getStore().isItemInStock(workingItemName);
				List List = getStore().getItem(workingItemName);
				Item item = null;
				Product product = null;
				for (Iterator it = List.iterator(); it.hasNext();) {
					Object[] object = (Object[]) it.next();
					item = new Item();
					
					item.setId((Long)object[0]);
					item.setVersion((Integer)object[1]);
					item.setItemName((String)object[2]);
					product = new Product();
					product.setId((Long)object[3]);
					item.setListPrice(new BigDecimal((Double)object[4]));
					item.setAttr1((String)object[8]);
					item.setAttr2((String)object[9]);
					item.setAttr3((String)object[10]);
					item.setAttr4((String)object[11]);
					item.setAttr5((String)object[12]);
					product.setProductNumber((String)object[15]);
					item.setProduct(product);
				}

				cartForm.getCart().addItem(item, isInStock);
			}
			return mapping.findForward("success");
		}
	}

}
