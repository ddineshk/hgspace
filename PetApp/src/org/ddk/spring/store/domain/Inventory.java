package org.ddk.spring.store.domain;

import java.util.Date;

public class Inventory implements java.io.Serializable, Comparable<Object> {
	private static final long serialVersionUID = 8893433348233906222L;
	private Long id;
	private int version;
	private Item item;
	private Date dateAdded = new Date();

	private int quantity;

	public Inventory() {
	}

	public Long getId() {
		return id;
	}

	public int getVersion() {
		return version;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof Category)) {
			return false;
		}

		final Inventory inventory = (Inventory) o;
		return dateAdded.getTime() == inventory.dateAdded.getTime();
	}

	public int hashCode() {
		return dateAdded.hashCode();
	}

	public String toString() {
		return "Inventory, (" + getId() + ")" + "Item: " + getItem().getItemName() + " " + "Added date: " + getDateAdded();
	}

	public int compareTo(Object o) {
		if (o instanceof Inventory) {
			return Long.valueOf(this.getDateAdded().getTime()).compareTo(Long.valueOf(((Inventory) o).getDateAdded().getTime()));
		}

		return 0;
	}
}
