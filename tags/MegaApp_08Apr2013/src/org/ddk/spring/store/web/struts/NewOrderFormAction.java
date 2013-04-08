package org.ddk.spring.store.web.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.ddk.spring.store.domain.Account;

public class NewOrderFormAction extends SecureBaseAction {

	protected ActionForward doExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		AccountActionForm acctForm = (AccountActionForm) request.getSession().getAttribute("accountForm");
		CartActionForm cartForm = (CartActionForm) request.getSession().getAttribute("cartForm");
		if (cartForm != null) {
			OrderActionForm orderForm = (OrderActionForm) form;
			if (request.getParameter("step") == null) {
				Account account = getStore().getAccount(acctForm.getAccount().getUsername());
				orderForm.getOrder().initOrder(account, cartForm.getCart());
			}
			saveToken(request);
			return mapping.findForward("success");
		} else {
			request.setAttribute("message","An order could not be created because a cart could not be found.");
			return mapping.findForward("failure");
		}
	}
}