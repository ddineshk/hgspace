
package org.ddk.spring.store.web.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public abstract class BaseDispatchAction extends BaseAction {
  public ActionForward execute(
          ActionMapping mapping,
          ActionForm form,
          HttpServletRequest request,
          HttpServletResponse response)
          throws Exception {
    
    ActionMessages am = getMessages(request);
    String parameter = mapping.getParameter();
    String name = request.getParameter(parameter);
    
    if (null == name) { 
      name = "List";
    }
    
    if ("add".equals(name)) {
      if ("add".equals(name)) {
        saveToken(request);
      }
    } else if ("insert".equals(name)) {
      if (!isTokenValid(request, true)) {
        resetToken(request);
        
        am.add(ActionErrors.GLOBAL_MESSAGE, 
                new ActionMessage("error.transaction.token"));
        
        return mapping.findForward("error");
      }
    }
    
    return mapping.findForward("success");
  }
}
