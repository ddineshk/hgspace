package org.ddk.spring.store.web.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.ddk.spring.store.domain.Cart;

public class CartActionForm extends BaseActionForm {

	private static final long serialVersionUID = 2195866486741430824L;
	private Cart cart = new Cart();
	private String workingItemName;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getWorkingItemName() {
		return workingItemName;
	}

	public void setWorkingItemName(String workingItemName) {
		this.workingItemName = workingItemName;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		workingItemName = null;
	}
}
