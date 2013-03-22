package org.ddk.spring.store.domain;

import java.util.HashSet;
import java.util.Set;

public class Category implements java.io.Serializable, Comparable<Object> {
	private static final long serialVersionUID = -4455664577104325724L;
	private Long id;
	private int version;
	private String categoryName;
	private String categoryDesc;

	private Set products = new HashSet();

	public Category() {
	}

	public Long getId() {
		return id;
	}

	public int getVersion() {
		return version;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public Set getProducts() {
		return products;
	}
  
	public void setProducts(Set products) {
		this.products = products;
	}

	public void addItem(Product product) {
		if (product == null)
			throw new IllegalArgumentException("Can't add a null product.");
		this.getProducts().add(product);
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof Category)) {
			return false;
		}

		final Category category = (Category) o;
		return getCategoryName().equals(category.getCategoryName());
	}

	public int hashCode() {
		return getCategoryName().hashCode();
	}

	public String toString() {
		return getCategoryName();
	}

	public int compareTo(Object o) {
		if (o instanceof Category) {
			return this.getCategoryName().compareTo(((Category) o).getCategoryName());
		}
		return 0;
	}
}
