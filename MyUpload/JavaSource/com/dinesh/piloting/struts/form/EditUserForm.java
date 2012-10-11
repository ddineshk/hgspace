package com.dinesh.piloting.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.dinesh.piloting.struts.bean.DataBean;
import com.dinesh.piloting.struts.bean.UserBean;

public class EditUserForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4653460025987980037L;
	private int users_Id;
    private String users_Name;
    private String users_OldPwd;
    private String users_Phone;
    private String users_Pwd;
    private String users_Pwd1;
    private String users_Gender;
    private String users_Dept;
    private String users_Count;
    private String users_Adds;
	/**
	 * @return the users_Id
	 */
	public int getUsers_Id() {
		return users_Id;
	}
	/**
	 * @param users_Id the users_Id to set
	 */
	public void setUsers_Id(int users_Id) {
		this.users_Id = users_Id;
	}
	/**
	 * @return the users_Name
	 */
	public String getUsers_Name() {
		return users_Name;
	}
	/**
	 * @param users_Name the users_Name to set
	 */
	public void setUsers_Name(String users_Name) {
		this.users_Name = users_Name;
	}
	/**
	 * @return the users_OldPwd
	 */
	public String getUsers_OldPwd() {
		return users_OldPwd;
	}
	/**
	 * @param users_OldPwd the users_OldPwd to set
	 */
	public void setUsers_OldPwd(String users_OldPwd) {
		this.users_OldPwd = users_OldPwd;
	}
	/**
	 * @return the users_Phone
	 */
	public String getUsers_Phone() {
		return users_Phone;
	}
	/**
	 * @param users_Phone the users_Phone to set
	 */
	public void setUsers_Phone(String users_Phone) {
		this.users_Phone = users_Phone;
	}
	/**
	 * @return the users_Pwd
	 */
	public String getUsers_Pwd() {
		return users_Pwd;
	}
	/**
	 * @param users_Pwd the users_Pwd to set
	 */
	public void setUsers_Pwd(String users_Pwd) {
		this.users_Pwd = users_Pwd;
	}
	/**
	 * @return the users_Pwd1
	 */
	public String getUsers_Pwd1() {
		return users_Pwd1;
	}
	/**
	 * @param users_Pwd1 the users_Pwd1 to set
	 */
	public void setUsers_Pwd1(String users_Pwd1) {
		this.users_Pwd1 = users_Pwd1;
	}
	/**
	 * @return the users_Gender
	 */
	public String getUsers_Gender() {
		return users_Gender;
	}
	/**
	 * @param users_Gender the users_Gender to set
	 */
	public void setUsers_Gender(String users_Gender) {
		this.users_Gender = users_Gender;
	}
	
	/**
	 * @return the users_Dept
	 */
	public String getUsers_Dept() {
		return users_Dept;
	}
	/**
	 * @param users_Dept the users_Dept to set
	 */
	public void setUsers_Dept(String users_Dept) {
		this.users_Dept = users_Dept;
	}
	/**
	 * @return the users_Count
	 */
	public String getUsers_Count() {
		return users_Count;
	}
	/**
	 * @param users_Count the users_Count to set
	 */
	public void setUsers_Count(String users_Count) {
		this.users_Count = users_Count;
	}
	/**
	 * @return the users_Adds
	 */
	public String getUsers_Adds() {
		return users_Adds;
	}
	/**
	 * @param users_Adds the users_Adds to set
	 */
	public void setUsers_Adds(String users_Adds) {
		this.users_Adds = users_Adds;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors err = new ActionErrors();
		UserBean ub = (UserBean) request.getSession().getAttribute("user");
		if(this.getUsers_Name() == null || this.getUsers_Name().length() < 1) {
			err.add("nameerr", new ActionMessage("jsp.user.reg.nameerr"));
		}else if (!this.getUsers_Name().equals(ub.getUsers_Name())) {
			if (!DataBean.HasName(this.getUsers_Name()))
				err.add("nameerr", new ActionMessage("jsp.user.reg.nameerr1"));
		}else if (!this.getUsers_OldPwd().equals(ub.getUsers_Pwd())) {
			err.add("oldpwderr", new ActionMessage("jsp.user.reg.oldpwderr"));
		}else if (this.getUsers_Pwd().length() > 1) {
			if (this.getUsers_Pwd() == null || this.getUsers_Pwd().length() < 1) {
				err.add("pwderr", new ActionMessage("jsp.user.reg.pwderr"));
			} else if (this.getUsers_Pwd1() == null || this.getUsers_Pwd1().length() < 1) {
				err.add("pwd1err", new ActionMessage("jsp.user.reg.pwd1err"));
			} else if (!this.getUsers_Pwd1().equals(this.getUsers_Pwd())) {
				err.add("pwd2err", new ActionMessage("jsp.user.reg.pwd2err"));
			} else {
				this.setUsers_OldPwd(this.getUsers_Pwd());
			}
		} else if (this.getUsers_Gender() == null || this.getUsers_Gender().length() < 1) {
			err.add("gendererr", new ActionMessage("jsp.user.reg.gendererr"));
		} else if (this.getUsers_Phone() == null || this.getUsers_Phone().length() < 1) {
			err.add("phoneerr", new ActionMessage("jsp.user.reg.phoneerr"));
		} else if (this.getUsers_Dept() == null || this.getUsers_Dept().length() < 1) {
			err.add("depterr", new ActionMessage("jsp.user.reg.dept.err"));
		} else if (this.getUsers_Count() == null || this.getUsers_Count().length() < 1) {
			err.add("counterr", new ActionMessage("jsp.user.reg.count.err"));
		} else if (this.getUsers_Adds() == null || this.getUsers_Adds().length() < 1) {
			err.add("addserr", new ActionMessage("jsp.user.reg.addserr"));
		}
		return err;
	}
}
