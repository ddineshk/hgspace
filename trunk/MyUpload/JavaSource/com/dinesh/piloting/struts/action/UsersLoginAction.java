package com.dinesh.piloting.struts.action;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.Action;

import com.dinesh.piloting.struts.bean.DataBean;
import com.dinesh.piloting.struts.bean.UserBean;
import com.dinesh.piloting.struts.form.UsersLoginForm;
public class UsersLoginAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        UsersLoginForm usersLoginForm = (UsersLoginForm) form;
        UserBean ub=new UserBean();
        DataBean db=new DataBean();
        ub.setUsers_Name(usersLoginForm.getUsers_Name());
        ub.setUsers_Pwd(usersLoginForm.getUsers_Pwd());
        if(db.checkUserLogin(ub))
        {
            request.getSession().setAttribute("user",db.getUserBean(ub));
            request.getSession().setAttribute("loginsuccess","true");
        }else{
        	request.getSession().setAttribute("loginsuccess","false");
        }
        db.Close();
        usersLoginForm.reset(mapping, request);
        return mapping.findForward("index");
    }
}
