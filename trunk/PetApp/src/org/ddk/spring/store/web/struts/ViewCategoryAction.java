package org.ddk.spring.store.web.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.ddk.spring.store.domain.Category;

import org.springframework.beans.support.PagedListHolder;

public class ViewCategoryAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String categoryName = request.getParameter("categoryName");
		if (categoryName != null) {
			Category category = getStore().getCategory(categoryName);
			PagedListHolder productList = new PagedListHolder(getStore().getProductListByCategory(categoryName));
			productList.setPageSize(4);
			request.getSession().setAttribute("ViewProductAction_category",category);
			request.getSession().setAttribute("ViewProductAction_productList",productList);
			request.setAttribute("category", category);
			request.setAttribute("productList", productList);

		} else {
			Category category = (Category) request.getSession().getAttribute("ViewProductAction_category");
			PagedListHolder productList = (PagedListHolder) request.getSession().getAttribute("ViewProductAction_productList");
			if (category == null || productList == null) {
				throw new IllegalStateException("Cannot find pre-loaded category and product List");
			}
			String page = request.getParameter("page");
			if ("next".equals(page)) {
				productList.nextPage();
			} else if ("previous".equals(page)) {
				productList.previousPage();
			}
			request.setAttribute("category", category);
			request.setAttribute("productList", productList);
		}
		return mapping.findForward("success");
	}
}
