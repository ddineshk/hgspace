/**
 * 
 */
package com.dinesh.piloting.mybatis.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dinesh.piloting.mybatis.form.LoginForm;
import com.dinesh.piloting.mybatis.model.User;
import com.dinesh.piloting.mybatis.model.UserMapper;
import com.dinesh.piloting.mybatis.utils.MyBatisUtils;

/**
 * @author ddurairaj
 *
 */
public class LoginAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		SqlSession session = MyBatisUtils.getSqlSession();
		LoginForm loginForm = (LoginForm)form;
		String result = null;
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.selectUsers(loginForm.getUserName(),loginForm.getPassword());
			if(user==null){
				result = "failure";
			}
			else{
				request.getSession().setAttribute("user", user);
				result = "success";
			}
		} finally {
			session.close();
		}
		
		return mapping.findForward(result);
	}
}
