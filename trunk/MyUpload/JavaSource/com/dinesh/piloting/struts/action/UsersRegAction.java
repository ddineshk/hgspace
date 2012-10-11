package com.dinesh.piloting.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dinesh.piloting.struts.bean.DataBean;
import com.dinesh.piloting.struts.bean.UserBean;
import com.dinesh.piloting.struts.form.UsersRegForm;

public class UsersRegAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UsersRegForm usersRegForm = (UsersRegForm) form;
        DataBean db=new DataBean();
        UserBean ub=new UserBean();
        ub.setUsers_Adds(usersRegForm.getUsers_Adds());
        ub.setUsers_Dept(usersRegForm.getUsers_Dept());
        ub.setUsers_Count(Integer.parseInt(usersRegForm.getUsers_Count()));
        ub.setUsers_Name(usersRegForm.getUsers_Name());
        ub.setUsers_Phone(usersRegForm.getUsers_Phone());
        ub.setUsers_Pwd(usersRegForm.getUsers_Pwd());
        ub.setUsers_Gender(usersRegForm.getUsers_Gender());
        if(db.regUser(ub))
        {
            request.setAttribute("regMsg","ok");
            request.getSession().setAttribute("user",db.getUserBean(ub));
            request.getSession().setAttribute("loginsuccess", "true");
        }else
        {
           request.setAttribute("regMsg","no");
        }
        db.Close();
        return mapping.findForward("regMsg");
	}
}
