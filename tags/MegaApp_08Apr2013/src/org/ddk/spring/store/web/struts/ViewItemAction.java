package org.ddk.spring.store.web.struts;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.ddk.spring.store.domain.Item;
import org.ddk.spring.store.domain.Product;

public class ViewItemAction extends BaseAction {
  
  public ActionForward execute(ActionMapping mapping, ActionForm form,
          HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    String itemName = request.getParameter("itemName");
    
    List list = getStore().getItem(itemName);
    Item item = new Item();
    Product product = new Product();

    for (Iterator it = list.iterator(); it.hasNext();) {
        Object[] object = (Object[]) it.next();
		item.setId((Long)object[0]);
		item.setVersion((Integer)object[1]);
		item.setItemName((String)object[2]);
		item.setListPrice((Double)object[4]);
		item.setAttr1((String)object[8]);
		item.setAttr2((String)object[9]);
		item.setAttr3((String)object[10]);
		item.setAttr4((String)object[11]);
		item.setAttr5((String)object[12]);
		
		product.setProductNumber((String)object[15]);
		product.setProductName((String)object[17]);
		product.setProductDesc((String)object[18]);
		item.setProduct(product);      
    }
    if(item.getId()!=null){
    	item.setQuantity(getStore().getItemQuantity(itemName));
    }else{
    	item.setQuantity(0);
    }
    request.setAttribute("item", item);
    request.setAttribute("product", product);
    
    saveToken(request);
    return mapping.findForward("success");
  }
  
}
