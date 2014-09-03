package com.dinesh.piloting.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.dinesh.piloting.form.UserForm;
import com.dinesh.piloting.model.User;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(false);
		UserForm userForm = (UserForm) form;
		User user = new User();
		user.setPassword(userForm.getPassword());
		user.setUserName(userForm.getUserName());

		if (user.login().equals("success")) {
			session.setAttribute("user", user);
			return mapping.findForward("success");
		} else {
			session.setAttribute("user", null);
			ActionErrors errors = new ActionErrors();
			errors.add("login.error", new ActionMessage("login.error"));
			
			if(!errors.isEmpty()){
				saveErrors(request, errors);
			}
			
			return mapping.findForward("failure");
		}
	}

}
