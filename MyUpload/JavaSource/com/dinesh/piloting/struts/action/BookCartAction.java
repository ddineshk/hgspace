package com.dinesh.piloting.struts.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dinesh.piloting.struts.bean.BooksBean;
import com.dinesh.piloting.struts.bean.DataBean;

public class BookCartAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session=request.getSession();
        int books_Id=Integer.parseInt(request.getParameter("books_Id"));
        if(session.getAttribute("cart")==null)
        {
            ArrayList<BooksBean> list=new ArrayList<BooksBean>();
            session.setAttribute("cart",list);
        }
        DataBean db=new DataBean();
        @SuppressWarnings("unchecked")
		ArrayList<BooksBean> list=(ArrayList<BooksBean>)session.getAttribute("cart");
        boolean flag=true;
        for(int i=0;i<list.size();i++)
        {
            BooksBean bsb=(BooksBean)list.get(i);
            if(books_Id==bsb.getBooks_Id())
            {
                flag=false;
                break;
            }
        }
        if(flag)
        list.add(db.getBooksBean(books_Id));
        session.setAttribute("cart",list);
        db.Close();
        return mapping.findForward("success");
	}
}
