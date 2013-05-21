package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.StrutsStatics;

import com.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor implements
		StrutsStatics {

	/**
	 * 
	 */
	private static final long serialVersionUID = -535115831872750653L;
	
	@Override
	public String intercept(final ActionInvocation invocation) throws Exception {
		System.out.println("Entering Intercept");
		String invocatedAction = invocation.getAction().getClass().getName();
		System.out.println("Invocated Action: " + invocatedAction);
		
		final ActionContext context = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
		HttpSession session = request.getSession(true);
		
		User user = (User)session.getAttribute("user");
		
		if (user == null) {
			System.out.println("User NOT found in the Session");
            String loginIdentifier = request.getParameter("openid_identifier");
            String openIdEndpoint =  request.getParameter("openid.op_endpoint");
            
            if (!StringUtils.isBlank(loginIdentifier)) {
            	System.out.println("The user is attempting to log in");
                return invocation.invoke ();
            }else if(! StringUtils.isBlank (openIdEndpoint) ) {
            	System.out.println("The user has logged in with an OpenId provider");

                return invocation.invoke ();
            }
            else {
//                saveReceivingURL(request, session);
                
            	System.out.println("Forwarding to the Login form");
            }
            return "login";
		}
		
		return null;
	}

}
