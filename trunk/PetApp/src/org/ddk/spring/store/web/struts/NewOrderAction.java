package org.ddk.spring.store.web.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.ddk.spring.store.domain.Order;

public class NewOrderAction extends SecureBaseAction {

	protected ActionForward doExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (!isTokenValid(request, false)) {
			request.setAttribute("message", "Request Error occured!");
			request.getSession().removeAttribute("workingOrderForm");
			request.getSession().removeAttribute("cartForm");
			request.getSession().removeAttribute("orderForm");

			return mapping.findForward("failure");
		} else {
			OrderActionForm orderForm = (OrderActionForm) form;
			if (orderForm.isShippingAddressRequired() && orderForm.getStep().equals("1")) {
				return mapping.findForward("shipping");
			} else if ((orderForm.getStep().equals("1") && orderForm.isShippingAddressRequired() == false)
					|| orderForm.getStep().equals("2")) {
				return mapping.findForward("confirm");
			} else if (orderForm.getOrder() != null) {
				resetToken(request);
				Order order = orderForm.getOrder();
				getStore().insertOrder(order);
				request.getSession().removeAttribute("workingOrderForm");
				request.getSession().removeAttribute("cartForm");
				request.getSession().removeAttribute("orderForm");
				request.setAttribute("order", order);
				request.setAttribute("message","Thank you, your order has been submitted.");
				request.setAttribute("newOrder", true);
				return mapping.findForward("success");
			} else {
				request.setAttribute("message","An error occurred processing your order (order was null).");
				return mapping.findForward("failure");
			}
		}
	}
}
