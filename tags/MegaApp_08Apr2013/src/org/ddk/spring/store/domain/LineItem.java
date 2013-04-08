package org.ddk.spring.store.domain;


public class LineItem implements java.io.Serializable, Comparable<Object> {

	private static final long serialVersionUID = -8391802673101072739L;
	private Long id;
	private int version;
	private Order order;
	private Integer lineNumber;
	private Item item;
	private int quantity;

	public LineItem() {
	}

	public LineItem(int lineNumber, CartItem cartItem) {
		this.lineNumber = lineNumber;
		this.quantity = cartItem.getQuantity();
		this.item = cartItem.getItem();
	}

	public Long getId() {
		return id;
	}

	public int getVersion() {
		return version;
	}

	public Order getOrder() {
		return order;
	}

	public Integer getLineNumber() {
		return lineNumber;
	}

	public Item getItem() {
		return item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return item.getListPrice();
	}

	public Double getTotalPrice() {
		return this.getUnitPrice()*quantity;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof LineItem)) {
			return false;
		}
		final LineItem lineItem = (LineItem) o;
		return getId().equals(lineItem.getId());
	}

	public int hashCode() {
		int result;
		result = this.getId().hashCode();
		result = 31 * result + quantity;
		return result;
	}

	public String toString() {
		return "LineItem (" + getId().toString() + "), " + "Quantity: "+ getQuantity();
	}

	public int compareTo(Object o) {
		if (o instanceof LineItem) {
			Integer lineNumber = getLineNumber();
			Integer thatLineNumber = ((LineItem) o).getLineNumber();
			return lineNumber.compareTo(thatLineNumber);
		}
		return 0;
	}
}
