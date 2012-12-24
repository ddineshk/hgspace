package org.ddk.spring.store.web.struts;

import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.ddk.spring.store.domain.Account;

import org.springframework.beans.support.PagedListHolder;

public class SignonAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.getSession().removeAttribute("workingAccountForm");
		request.getSession().removeAttribute("accountForm");
		if (request.getParameter("signoff") != null) {
			request.getSession().invalidate();
			return mapping.findForward("success");
		} else {
			AccountActionForm acctForm = (AccountActionForm) form;
			String username = acctForm.getUsername();
			String password = acctForm.getPassword();
			List list = getStore().getAccount(username, password);
			Account account = null;
			String categoryName = null;
			for (Iterator it = list.iterator(); it.hasNext();) {
				Object[] pair = (Object[]) it.next();
				account = (Account) pair[0];
				categoryName = (String) pair[1];
			}
			String bannerName = getStore().getBannerNameForUser(username);
			if (account == null) {
				request.setAttribute("message","Invalid username or password.  Signon failed.");
				// return mapping.findForward("failure");
			} else {
				String forwardAction = acctForm.getForwardAction();
				acctForm = new AccountActionForm();
				acctForm.setForwardAction(forwardAction);
				acctForm.setAccount(account);
				acctForm.getAccount().setPassword(null);
				if (bannerName != null) {
					acctForm.setBannerName(bannerName);
				}
				if (categoryName != null) {
					acctForm.setFavCategoryName(categoryName);
				}
				PagedListHolder myList = new PagedListHolder(getStore().getProductListByCategory(categoryName));
				myList.setPageSize(4);
				acctForm.setMyList(myList);
				request.getSession().setAttribute("accountForm", acctForm);
				if (acctForm.getForwardAction() == null || acctForm.getForwardAction().length() < 1) {
					return mapping.findForward("success");
				} else {
					response.sendRedirect(acctForm.getForwardAction());
					return null;
				}
			}
			return mapping.findForward("success");
		}
	}
}
