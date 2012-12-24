package org.ddk.spring.store.domain;

import java.util.HashSet;
import java.util.Set;

public class Supplier implements java.io.Serializable, Comparable<Object> {

	private static final long serialVersionUID = -4011870753005865833L;
	private Long id;
	private int version;
	private String supplierName;
	private String status;
	private Address supplierAddr;
	private String phone;
	private Set items = new HashSet();

	public Supplier() {
	}

	public Long getId() {
		return id;
	}

	public int getVersion() {
		return version;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getSupplierAddr() {
		return supplierAddr;
	}

	public void setSupplierAddr(Address supplierAddr) {
		this.supplierAddr = supplierAddr;
	}

	public Set getItems() {
		return items;
	}

	public void setItems(Set items) {
		this.items = items;
	}

	public void addItem(Item item) {
		if (item == null)
			throw new IllegalArgumentException("Can't add a null Item.");
		this.getItems().add(item);
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof Supplier)) {
			return false;
		}

		final Supplier supplier = (Supplier) o;
		if (!getSupplierAddr().equals(supplier.getSupplierAddr()))
			return false;
		if (!getSupplierName().equals(supplier.getSupplierName()))
			return false;
		if (!(getPhone().equals(supplier.getPhone())))
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = getSupplierAddr().hashCode();
		result = 31 * result + getSupplierName().hashCode();
		result = 31 * result + getPhone().hashCode();
		return result;
	}

	public String toString() {
		return "Supplier (" + getId() + "), " + "Name: " + getSupplierName()
				+ " " + "Phone: " + getPhone() + " " + "Address: "
				+ getSupplierAddr();
	}

	public int compareTo(Object o) {
		if (o instanceof Supplier) {
			return getSupplierName().compareTo(((Supplier) o).getSupplierName());
		}

		return 0;
	}

}
