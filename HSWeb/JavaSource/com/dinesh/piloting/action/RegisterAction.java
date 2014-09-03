package com.dinesh.piloting.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.dinesh.piloting.form.RegisterForm;
import com.dinesh.piloting.model.User;

public class RegisterAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		RegisterForm registerForm = (RegisterForm)form;
		
		User user = new User();
		user.setFirstName(registerForm.getFirstName());
		user.setLastName(registerForm.getLastName());
		user.setEmail(registerForm.getEmail());
		user.setPassword(registerForm.getPassword());
		ActionErrors errors = new ActionErrors();
		if(!user.register().equals("success")){
			
			errors.add("register.error",new ActionMessage("register.error"));
		}else{
			errors.add("register.success",new ActionMessage("register.success"));
		}
		if(!errors.isEmpty()){
			saveMessages(request, errors);
		}
		return mapping.findForward("success");
	}
}
