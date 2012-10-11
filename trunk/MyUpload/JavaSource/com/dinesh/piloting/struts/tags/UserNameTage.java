package com.dinesh.piloting.struts.tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.dinesh.piloting.struts.bean.DataBean;

public class UserNameTage extends BodyTagSupport {
    /**
	 * 
	 */
	private static final long serialVersionUID = 850082861857063530L;
	JspWriter out = null;
     public int doAfterBody() {
         BodyContent body = getBodyContent();
         String content = body.getString();
         out = body.getEnclosingWriter();
         DataBean db = new DataBean();
         int users_Id=Integer.parseInt(content);
        String name=db.getUserBean(users_Id).getUsers_Name();
         db.Close();
         try {
           out.print(name);
         } catch (IOException e) {
             e.printStackTrace();
         }
         return (SKIP_BODY);
    }
}
