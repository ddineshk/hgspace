package com.dinesh.piloting.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.dinesh.piloting.form.RegForm;
import com.dinesh.piloting.service.SearchService;

public class RegAction extends DispatchAction {
	@Override
	protected ActionForward dispatchMethod(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response, String name)
			throws Exception {
		return super.dispatchMethod(mapping, form, request, response, name);
	}
	
	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward load(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SearchService service = new SearchService();
		RegForm regForm = (RegForm) form;
		regForm.setPersonList(service.getAllEmployees());
		return mapping.findForward("success");
	}
	
	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward sel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		RegForm regForm = (RegForm) form;
		for (int i = 0; i < regForm.getSelPerson().length; i++) {
			System.out.println(i+1+" : "+regForm.getSelPerson()[i]);
		}
		SearchService service = new SearchService();
		regForm.setPersonList(service.getAllEmployees());
		return mapping.findForward("success");
	}
}
