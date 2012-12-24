package org.ddk.spring.store.web.struts;

import javax.servlet.ServletContext;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionServlet;
import org.ddk.spring.store.domain.logic.StoreFacade;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public abstract class BaseAction extends Action {

	private StoreFacade store;

	public void setServlet(ActionServlet actionServlet) {
		super.setServlet(actionServlet);
		if (actionServlet != null) {

			synchronized (this) {
				ServletContext servletContext = actionServlet.getServletContext();
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
				this.store = (StoreFacade) wac.getBean("store");
			}
		}
	}

	protected StoreFacade getStore() {
		return store;
	}

}
