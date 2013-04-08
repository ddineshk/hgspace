package org.ddk.spring.store.domain;

import java.io.Serializable;

public class CartItem implements Serializable {
    
	private static final long serialVersionUID = -5403059218086939213L;
	private Item item;
	private int quantity;
	private boolean inStock;

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		if (item != null) {
			return item.getListPrice()*quantity;
		} else {
			return new Double(0);
		}
	}
    public void incrementQuantity() {
        quantity++;
    }
    
}
