package org.ddk.spring.store.web.struts;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.ddk.spring.store.domain.Order;

public class OrderActionForm extends BaseActionForm {

	private static final long serialVersionUID = 8067102717416095692L;
	private static final List CARD_TYPE_List = new ArrayList();
	private Order order;
	private boolean shippingAddressRequired;
	private List cardTypeList;
	private String step;
	static {
		CARD_TYPE_List.add("Visa");
		CARD_TYPE_List.add("MasterCard");
		CARD_TYPE_List.add("American Express");
	}
	public OrderActionForm() {
		this.order = new Order();
		this.shippingAddressRequired = false;
		this.cardTypeList = CARD_TYPE_List;
	}

	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public boolean isShippingAddressRequired() {
		return shippingAddressRequired;
	}

	public void setShippingAddressRequired(boolean shippingAddressRequired) {
		this.shippingAddressRequired = shippingAddressRequired;
	}

	public List getCreditCardTypes() {
		return cardTypeList;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public void doValidate(ActionMapping mapping, HttpServletRequest request,List errors) {
		if (step.equals("1")) {
			addErrorIfStringEmpty(errors, "Card type is required.",order.getCardType());
			addErrorIfStringEmpty(errors,"FAKE (!) credit card number required.",order.getCardNumber());
			addErrorIfStringEmpty(errors, "Expiry date is required.",order.getExpireDate());
			addErrorIfStringEmpty(errors,"Billing Info: first name is required.",order.getBillToFirstname());
			addErrorIfStringEmpty(errors,"Billing Info: last name is required.",order.getBillToLastname());
			addErrorIfStringEmpty(errors, "Billing Info: address is required.",order.getBillAddr().getAddr1());
			addErrorIfStringEmpty(errors, "Billing Info: city is required.",order.getBillAddr().getCity());
			addErrorIfStringEmpty(errors, "Billing Info: state is required.",order.getBillAddr().getState());
			addErrorIfStringEmpty(errors,"Billing Info: zip/postal code is required.", order.getBillAddr().getZipcode());
			addErrorIfStringEmpty(errors, "Billing Info: country is required.",order.getBillAddr().getCountry());
			if (errors.size() > 0) {
				order.setBillAddr(order.getBillAddr());
			}
		} else if (step.equals("2")) {
			addErrorIfStringEmpty(errors,"Shipping Info: first name is required.",order.getShipToFirstname());
			addErrorIfStringEmpty(errors,"Shipping Info: last name is required.",order.getShipToLastname());
			addErrorIfStringEmpty(errors,"Shipping Info: address is required.", order.getShipAddr().getAddr1());
			addErrorIfStringEmpty(errors, "Shipping Info: city is required.",order.getShipAddr().getCity());
			addErrorIfStringEmpty(errors, "Shipping Info: state is required.",order.getShipAddr().getState());
			addErrorIfStringEmpty(errors,"Shipping Info: zip/postal code is required.", order.getShipAddr().getZipcode());
			addErrorIfStringEmpty(errors,"Shipping Info: country is required.", order.getShipAddr().getCountry());
			if (errors.size() > 0) {
				order.setShipAddr(order.getShipAddr());
			}
		}
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.shippingAddressRequired = false;
	}
}
