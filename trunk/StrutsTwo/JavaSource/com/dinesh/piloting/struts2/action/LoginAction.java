package com.dinesh.piloting.struts2.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dinesh.piloting.struts2.CaptchaServlet;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1769677453409836371L;
	private String userName;
	private String passWord;
	
	public String execute(){
		boolean captchaFlag = false;
		HttpServletRequest request  = (HttpServletRequest)
				 ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		HttpSession session = request.getSession();
        String parm = request.getParameter("j_captcha_response");
        String c= (String)session.getAttribute(CaptchaServlet.CAPTCHA_KEY) ;
        if(!parm.equals(c)){
            addActionError("Invalid Code! Please try again!");
            return ERROR;
        }else{
        	captchaFlag = true;
        }
        
		if(this.userName.equals("admin") && this.passWord.equals("admin123") && captchaFlag){
			return SUCCESS;
		}else{
			addActionError(getText("error.login"));
			return ERROR;
		}
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the passWord
	 */
	public String getPassWord() {
		return passWord;
	}

	/**
	 * @param passWord the passWord to set
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
