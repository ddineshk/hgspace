

package com.dinesh.piloting.struts.tags;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.*;

import com.dinesh.piloting.struts.bean.BooksTypeBean;
import com.dinesh.piloting.struts.bean.DataBean;
import java.util.*;

public class BookTypeTag extends BodyTagSupport {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8038036367171713666L;
	JspWriter out = null;
    public int doAfterBody() {
        BodyContent body = getBodyContent();
        String content = body.getString();
        out = body.getEnclosingWriter();
        DataBean db = new DataBean();
        ArrayList<BooksTypeBean> list = db.getBooksType();
        db.Close();
        try {
            if (content.equals("tr")) {
                out.println(
                        "<th><a href='BooksPageAction.do?bookTypeId=0'>act</a></th>");
                for (int i = 0; i < list.size(); i++) {
                    BooksTypeBean btb = (BooksTypeBean) list.get(i);
                    out.println("<th><a href='BooksPageAction.do?bookTypeId=" +btb.getBookType_Id() + "'>" +btb.getBookType_Name() +"</a></th>");
                }
            } else if (content.equals("option")) {
                for (int i = 0; i < list.size(); i++) {
                    BooksTypeBean btb = (BooksTypeBean) list.get(i);
                    out.println("<option value=\"" + btb.getBookType_Id() +"\">" + btb.getBookType_Name() + "</option>");
                }

            } else if (content.equals("admintr")) {
                out.println(
                        "<th><a href='AdminBooksPageAction.do?bookTypeId=0'>adsdde</a></th>");
                for (int i = 0; i < list.size(); i++) {
                    BooksTypeBean btb = (BooksTypeBean) list.get(i);
                    out.println("<th><a href='AdminBooksPageAction.do?bookTypeId=" + btb.getBookType_Id() + "'>" + btb.getBookType_Name() + "</a></th>");
                }

            } else {
                for (int i = 0; i < list.size(); i++) {
                    BooksTypeBean btb = (BooksTypeBean) list.get(i);
                    if (btb.getBookType_Id() == Integer.parseInt(content)) {
                        out.print(btb.getBookType_Name());
                        break;
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (SKIP_BODY);
    }
}
