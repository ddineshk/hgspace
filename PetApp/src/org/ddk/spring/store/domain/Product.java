package org.ddk.spring.store.domain;

import java.util.HashSet;
import java.util.Set;

public class Product implements java.io.Serializable, Comparable<Object> {

	private static final long serialVersionUID = -7623496525417274809L;
	private Long id;
	private int version;
	private String productNumber;
	private Category category;
	private String productName;
	private String productDesc;

	private Set items = new HashSet();

	public Product() {
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
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

		if (!(o instanceof Product)) {
			return false;
		}

		final Product product = (Product) o;
		if (!getProductNumber().equals(product.getProductNumber()))
			return false;
		if (!getProductName().equals(product.getProductName()))
			return false;
		return true;
	}

	public int hashCode() {
		return getProductNumber().hashCode();
	}

	public String toString() {
		return "Product (" + getProductNumber() + "), " + "Name: "+ getProductName();
	}

	public int compareTo(Object o) {
		if (o instanceof Product) {
			return getProductNumber().compareTo(((Product) o).getProductNumber());
		}
		return 0;
	}
}
