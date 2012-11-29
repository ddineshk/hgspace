package com.dinesh.piloting.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class UserAction extends DispatchAction {


@Override
	protected ActionForward dispatchMethod(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response, String name)
			throws Exception {
		// TODO Auto-generated method stub
		return super.dispatchMethod(mapping, form, request, response, name);
	}

public ActionForward EditUser(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {

	return mapping.findForward("success");
}
public ActionForward DeleteUser(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {

	return mapping.findForward("success");
}
}
