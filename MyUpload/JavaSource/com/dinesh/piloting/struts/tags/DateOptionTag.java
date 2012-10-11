package com.dinesh.piloting.struts.tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.dinesh.piloting.struts.bean.DataBean;
import com.dinesh.piloting.struts.util.MyDate;
public class DateOptionTag extends BodyTagSupport {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5470183635526043114L;
	JspWriter out=null;
    public int doAfterBody()
    {
            BodyContent body=getBodyContent();
            String content=body.getString();
            DataBean db=new DataBean();String msg="";
            int day=db.getDateCha(MyDate.getDate().substring(0,8),content.substring(0,8));
            if(day<0)
            {
                msg=""+(day*-1)+"";
            }else if(day==0)
            {
                msg="";
            }else
            {
                msg=""+day+"";
            }
            db.Close();
            out=body.getEnclosingWriter();
            try {
                    out.print(msg);
            } catch (IOException e) {
                    e.printStackTrace();
            }
            return (SKIP_BODY);
	}
}
