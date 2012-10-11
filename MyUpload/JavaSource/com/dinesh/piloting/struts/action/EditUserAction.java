package com.dinesh.piloting.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dinesh.piloting.struts.bean.DataBean;
import com.dinesh.piloting.struts.bean.UserBean;
import com.dinesh.piloting.struts.form.EditUserForm;
import com.dinesh.piloting.struts.tools.ForwardUtil;

public class EditUserAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EditUserForm editUserForm = (EditUserForm) form;
        DataBean db = new DataBean();
        UserBean ub = new UserBean();
        ub.setUsers_Adds(editUserForm.getUsers_Adds());
        ub.setUsers_Dept(editUserForm.getUsers_Dept());
        ub.setUsers_Count(Integer.parseInt(editUserForm.getUsers_Count()));
        ub.setUsers_Name(editUserForm.getUsers_Name());
        ub.setUsers_Phone(editUserForm.getUsers_Phone());
        ub.setUsers_Gender(editUserForm.getUsers_Gender());
        ub.setUsers_Pwd(editUserForm.getUsers_OldPwd());
        ub.setUsers_Id(editUserForm.getUsers_Id());
        if (db.updateUserInfo(ub)) {
            request.setAttribute("userUpdateMsg", "ok");
            request.getSession().setAttribute("user", db.getUserBean(ub));
        } else {
            request.setAttribute("userUpdateMsg", "no");
        }
        db.Close();
        return ForwardUtil.forward(mapping.findForward("index"),"?action=4");
	}
}
