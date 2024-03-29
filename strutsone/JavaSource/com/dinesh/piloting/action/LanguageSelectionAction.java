package com.dinesh.piloting.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class LanguageSelectionAction extends DispatchAction {
	@Override
	protected ActionForward dispatchMethod(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response, String name)
			throws Exception {
		return super.dispatchMethod(mapping, form, request, response, name);
	}
	
	public ActionForward english(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().setAttribute(Globals.LOCALE_KEY,Locale.ENGLISH);
		return mapping.findForward("success");
	}
	public ActionForward german(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().setAttribute(Globals.LOCALE_KEY,Locale.GERMAN);
		return mapping.findForward("success");
	}
	public ActionForward spanish(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Locale spanish = new Locale("es","ES" );
		request.getSession().setAttribute(Globals.LOCALE_KEY,spanish);
		return mapping.findForward("success");
	}
	public ActionForward france(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().setAttribute(Globals.LOCALE_KEY,Locale.FRANCE);
		return mapping.findForward("success");
	}
}
