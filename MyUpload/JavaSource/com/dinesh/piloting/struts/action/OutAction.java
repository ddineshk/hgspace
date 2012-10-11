package com.dinesh.piloting.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dinesh.piloting.struts.tools.ForwardUtil;

public class OutAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("loginsuccess");
		return ForwardUtil.forward(mapping.findForward("index"), "?action=3");
	}
}
