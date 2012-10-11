package com.dinesh.piloting.struts.tools;

import org.apache.struts.action.ActionForward;

/**
 * @author ddurairaj
 *
 */
public class ForwardUtil {
	/**
	 * 
	 */
	public ForwardUtil() {
	}
	/**
	 * @param forward
	 * @param param
	 * @return
	 */
	public static ActionForward forward(ActionForward forward,String param) {
		StringBuffer path = new StringBuffer(forward.getPath());
		path.append(param);
		return new ActionForward(path.toString());
	}
}
