package com.dinesh.piloting.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import com.dinesh.piloting.servlet.CaptchaServlet;

/**
 * @author ddurairaj
 *
 */
public class RegisterForm extends ValidatorForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5378977222961335187L;
	private Integer id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private String rePass;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the rePass
	 */
	public String getRePass() {
		return rePass;
	}
	/**
	 * @param rePass the rePass to set
	 */
	public void setRePass(String rePass) {
		this.rePass = rePass;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		HttpSession session = request.getSession();
        String parm = request.getParameter("j_captcha_response");
        String c= (String)session.getAttribute(CaptchaServlet.CAPTCHA_KEY);
        if(firstName.trim().isEmpty()){
        	errors.add("register.firstName",new ActionMessage("register.firstName"));
        }
        if(lastName.trim().isEmpty()){
        	errors.add("register.lastName",new ActionMessage("register.lastName"));
        }
        if(userName.trim().isEmpty()){
        	errors.add("register.userName",new ActionMessage("register.userName"));
        }
        if(password.trim().isEmpty()){
        	errors.add("register.passwordEmpty",new ActionMessage("register.passwordEmpty"));
        }
        if(rePass.trim().isEmpty()){
        	errors.add("register.rePassEmpty",new ActionMessage("register.rePassEmpty"));
        }
        if(!password.trim().isEmpty() && !rePass.trim().isEmpty() && !password.equals(rePass)){
        	errors.add("register.password",new ActionMessage("register.password"));
        }
        if(!parm.equals(c)){
        	errors.add("register.captcha",new ActionMessage("register.captcha"));
        }
		return errors;
	}

}
