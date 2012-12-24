package org.ddk.spring.store.web.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.ddk.spring.store.domain.Account;
import org.ddk.spring.store.domain.Address;

public class NewAccountFormAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		AccountActionForm workingAcctForm = new AccountActionForm();
		request.getSession().removeAttribute("workingAccountForm");
		request.getSession().setAttribute("workingAccountForm", workingAcctForm);

		if (workingAcctForm.getAccount() == null) {
			Account account = new Account();
			account.setUserAddr(new Address());
			workingAcctForm.setAccount(account);
		}

		if (workingAcctForm.getCategories() == null) {
			workingAcctForm.setCategories(getStore().getCategoryList());
		}
		return mapping.findForward("success");
	}
}
