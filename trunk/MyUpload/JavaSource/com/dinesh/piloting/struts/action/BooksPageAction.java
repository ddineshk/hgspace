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
import com.dinesh.piloting.struts.tools.ForwardUtil;

public class BooksPageAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int page=1;
        int count=10;
//        int pagecount=0;
        String sqlStr="";
        String seach="";
        String bookTypeID="0";
        String seachstr="";
        if(request.getParameter("seachstr")!=null&&request.getParameter("seachstr").length()>0)
        {
            seachstr = new String(request.getParameter("seachstr"));
        }
        if(request.getParameter("page")!=null&&request.getParameter("page").length()>0)
        {
            page=Integer.parseInt(request.getParameter("page"));
        }
        if(request.getParameter("seach")!=null&&request.getParameter("seach").length()>0)
        {
            seach=request.getParameter("seach");
            if(seach.equals("1"))
            {
                sqlStr="where Books_Name like '%"+seachstr+"%'";
            }else if(seach.equals("2"))
            {
                sqlStr="where Books_Company like '%"+seachstr+"%'";
            }else if(seach.equals("3"))
            {
                sqlStr="where Books_Company like '%"+seachstr+"%' or Books_Name like '%"+seachstr+"%'";
            }
        }
        if(request.getParameter("bookTypeID")!=null&&request.getParameter("bookTypeID").length()>0)
        {
            bookTypeID=request.getParameter("bookTypeID");
        }
        if(sqlStr.equals(""))
        {
            if(!bookTypeID.equals("0"))
            sqlStr="where BookType_ID="+bookTypeID;
        }else
        {
            if(!bookTypeID.equals("0"))
             sqlStr+="and BookType_ID="+bookTypeID;
        }
        DataBean db=new DataBean();
        ArrayList<BooksBean> list=db.getBooksList(count,page,sqlStr);
        System.out.println(list.size());
        db.Close();
        request.setAttribute("list",list);
        request.setAttribute("page",page+"");
        request.setAttribute("pagecount",db.pagecount+"");
        request.setAttribute("bookTypeID",bookTypeID);
        request.setAttribute("seach",seach);
        request.setAttribute("seachstr",seachstr);
        return ForwardUtil.forward(mapping.findForward("index"),"?action=1");
       }
}
