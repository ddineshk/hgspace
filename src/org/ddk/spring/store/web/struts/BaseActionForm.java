package org.ddk.spring.store.web.struts;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class BaseActionForm extends ActionForm {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8570807770381606575L;

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errorMessages = null;
        
        ArrayList errorList = new ArrayList();
        doValidate(mapping, request, errorList);
        request.setAttribute("errors", errorList);
        if (!errorList.isEmpty()) {
            errorMessages = new org.apache.struts.action.ActionErrors();
            errorMessages.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("global.error"));
        }
        return errorMessages;
    }
    

    public void doValidate(ActionMapping mapping, HttpServletRequest request, List errors) {
    }
    
    protected void addErrorIfStringEmpty(List errors, String message, String value) {
        if (value == null || value.trim().length() < 1) {
            errors.add(message);
        }
    }
}
