package com.dinesh.piloting.exp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

public class MyExceptionHandler extends ExceptionHandler {
	private static final Logger logger = Logger.getLogger(MyExceptionHandler.class);
	@Override
	public ActionForward execute(Exception ex, ExceptionConfig ec,
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		logger.error(ex);
		
		return super.execute(ex, ec, mapping,form,request,response);
				
	}

}
