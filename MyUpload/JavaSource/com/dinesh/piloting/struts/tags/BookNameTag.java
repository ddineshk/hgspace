package com.dinesh.piloting.struts.tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.dinesh.piloting.struts.bean.DataBean;

public class BookNameTag extends BodyTagSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7008843803997220206L;
	JspWriter out = null;
    public int doAfterBody() {
        BodyContent body = getBodyContent();
        String content = body.getString();
        out = body.getEnclosingWriter();
        DataBean db = new DataBean();
        int bookId=Integer.parseInt(content);
        String name=db.getBooksBean(bookId).getBooks_Name();
        db.Close();
        try {
          out.print(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (SKIP_BODY);
   }
}
