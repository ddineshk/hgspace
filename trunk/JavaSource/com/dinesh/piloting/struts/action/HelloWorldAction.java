/**
 * 
 */
package com.dinesh.piloting.struts.action;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dinesh.piloting.struts.form.HelloWorldForm;

/**
 * @author ddurairaj
 *
 */
public class HelloWorldAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			ServletRequest request, ServletResponse response) throws Exception {
		HelloWorldForm hwForm = (HelloWorldForm) form; 
		hwForm.setMessage("Hello World"); 

		return mapping.findForward("success"); 

	}
}
