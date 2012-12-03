package com.dinesh.piloting.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		UserForm userForm = (UserForm) form;
		User user = new User();
		user.setFirstName(userForm.getFirstName());
		user.setPassword(userForm.getPassword());

		if (user.login().equals("success")) {
			return mapping.findForward("success");
		} else {
			ActionErrors errors = new ActionErrors();
			errors.add("login.error", new ActionMessage("login.error"));
			
			if(!errors.isEmpty()){
				saveErrors(request, errors);
			}
			
			return mapping.findForward("failure");
		}
	}

}
