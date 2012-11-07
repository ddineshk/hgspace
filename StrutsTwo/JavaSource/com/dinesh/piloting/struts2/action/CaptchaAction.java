package com.dinesh.piloting.struts2.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dinesh.piloting.struts2.CaptchaServlet;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CaptchaAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String execute() throws Exception {
		HttpServletRequest request  = (HttpServletRequest)
				 ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
//		Boolean isResponseCorrect = Boolean.FALSE;
        HttpSession session = request.getSession();
        String parm = request.getParameter("j_captcha_response");
        String c= (String)session.getAttribute(CaptchaServlet.CAPTCHA_KEY) ;
        if(!parm.equals(c) ){
            addActionError("Invalid Code! Please try again!");
            return ERROR;
          }else{
        	addActionError("Validated Succesfully");
          return SUCCESS;
          }

		
	}
}
