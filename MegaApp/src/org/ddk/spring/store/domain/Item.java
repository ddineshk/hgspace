package org.ddk.spring.store.domain;


public class Item implements java.io.Serializable, Comparable<Object> {
	private static final long serialVersionUID = -5413105874790315292L;
	private Long id;
	private int version;
	private String itemName;
	private Product product;
	public void setProduct(Product product) {
		this.product = product;
	}

	private Double listPrice;

	private Double unitCost;

	private Supplier supplier;
	private String status;
	private String attr1;
	private String attr2;
	private String attr3;
	private String attr4;
	private String attr5;

	private int quantity;

	public Item() {
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
	public void setVersion(int version){
		this.version = version;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Product getProduct() {
		return product;
	}

	public Double getListPrice() {
		return listPrice;
	}

	public void setListPrice(Double listPrice) {
		this.listPrice = listPrice;
	}

	public Double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAttr1() {
		return attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	public String getAttr2() {
		return attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}

	public String getAttr3() {
		return attr3;
	}

	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}

	public String getAttr4() {
		return attr4;
	}

	public void setAttr4(String attr4) {
		this.attr4 = attr4;
	}

	public String getAttr5() {
		return attr5;
	}

	public void setAttr5(String attr5) {
		this.attr5 = attr5;
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

		if (!(o instanceof Item)) {
			return false;
		}

		final Item item = (Item) o;
		if (getItemName() != null && item.getItemName() == null)
			return false;
		if (getItemName() == null && item.getItemName() != null)
			return false;
		if (!getItemName().equals(item.getItemName()))
			return false;

		return true;
	}

	public int hashCode() {
		return getItemName().hashCode();
	}

	public String toString() {
		return "Item (" + getId() + "), " + "Name: " + getItemName() + ", "
				+ "List Price: " + getListPrice() + " " + "Attributes: "
				+ getAttr1() + " " + getAttr2() + " " + getAttr3() + " "
				+ getAttr4() + " " + getAttr5();
	}

	public int compareTo(Object o) {
		if (o instanceof Item) {
			return getItemName().compareTo(((Item) o).getItemName());
		}
		return 0;
	}
}
