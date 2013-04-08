package org.ddk.spring.store.web.struts;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.ddk.spring.store.domain.Cart;
import org.ddk.spring.store.domain.Item;
import org.ddk.spring.store.domain.Product;

/**
 * @author ddurairaj
 *
 */
public class ItemInfoAction extends BaseAction{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String workingItemName = request.getParameter("itemId");
		CartActionForm cartForm = (CartActionForm)request.getSession().getAttribute("cartForm");
		Cart cart = cartForm.getCart();
		JSONObject mapObj = null;
		HashMap resMap = new HashMap();
		boolean isInStock = getStore().isItemInStock(workingItemName);
		if (cart!=null && cart.containsItemName(workingItemName)) {
			cart.incrementQuantityByItemName(workingItemName);
			
			resMap.put("total", cart.getSubTotal());
			resMap.put("item", null);
			resMap.put("isInStock", isInStock);
			resMap.put("itemName", workingItemName);
			
			List ls = getStore().getItem(workingItemName);
			Object[] obj=(Object[])ls.get(0);
			
			resMap.put("listPrice", (Double)obj[4]);
		}else{
		
			List list = getStore().getItem(workingItemName);
			Item item = null;
			Product product = null;
			for (Iterator it = list.iterator(); it.hasNext();) {
				Object[] object = (Object[]) it.next();
				item = new Item();
				
				item.setId((Long)object[0]);
				item.setVersion((Integer)object[1]);
				item.setItemName((String)object[2]);
				product = new Product();
				product.setId((Long)object[3]);
				item.setListPrice((Double)object[4]);
				item.setUnitCost((Double)object[5]);
				item.setStatus((String)object[7]);
				item.setAttr1((String)object[8]);
				item.setAttr2((String)object[9]);
				item.setAttr3((String)object[10]);
				item.setAttr4((String)object[11]);
				item.setAttr5((String)object[12]);
				product.setVersion((Integer)object[14]);
				product.setProductNumber((String)object[15]);
				product.setProductName((String)object[17]);
				product.setProductDesc((String)object[18]);
				item.setProduct(product);
			}
			cartForm.getCart().addItem(item, isInStock);
			resMap.put("item", item);
			resMap.put("total", cart.getSubTotal());
			resMap.put("isInStock", isInStock);
			resMap.put("itemName", workingItemName);
		}
		mapObj = JSONObject.fromObject(resMap);
		response.setContentType("application/json");
		response.setHeader("cache-control", "no-cache");
		PrintWriter out = response.getWriter();
		out.print(mapObj);
		return null;
	}

}
