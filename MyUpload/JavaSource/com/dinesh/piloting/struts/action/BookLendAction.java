package com.dinesh.piloting.struts.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dinesh.piloting.struts.bean.BooksBean;
import com.dinesh.piloting.struts.bean.DataBean;
import com.dinesh.piloting.struts.bean.LendBean;
import com.dinesh.piloting.struts.bean.UserBean;
import com.dinesh.piloting.struts.util.MyDate;

public class BookLendAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int users_Id=((UserBean)request.getSession().getAttribute("user")).getUsers_Id();
        int books_Id=Integer.parseInt(request.getParameter("books_Id"));
        int lendDay=Integer.parseInt(request.getParameter("lendDay"));
        String laction=request.getParameter("laction");
        LendBean lb=new LendBean();
        lb.setUsers_Id(users_Id);
        lb.setBooks_Id(books_Id);
        lb.setBookLend_StarTime(MyDate.getDate());
        MyDate md=new MyDate();
        String msg="";
       lb.setBookLend_EndTime(md.addDays(lb.getBookLend_StarTime(),lendDay));
       if(laction.equals("insert"))
       {
           DataBean db = new DataBean();
            msg = db.lendBooks(lb);
           db.Close();
       }else
       {
           msg="Deleted";
       }
        @SuppressWarnings("unchecked")
		ArrayList<BooksBean> list = (ArrayList<BooksBean>) request.getSession().getAttribute("cart");
       for(int i=0;i<list.size();i++)
       {
           BooksBean bsb=(BooksBean)list.get(i);
           if(bsb.getBooks_Id()==lb.getBooks_Id())
           {
               list.remove(i);
               break;
           }
       }
       request.setAttribute("lendMsg",msg);

        return mapping.findForward("success");
	}
}
