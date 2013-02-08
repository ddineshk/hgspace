package com.dinesh.piloting.mybatis.model;

import java.io.Serializable;


/**
 * The persistent class for the "product" database table.
 * 
 */

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3827101148508977084L;

	private String categoryId;

	private String productDesc;

	private int productId;

	private String productName;

	private String productNumber;

	private String subCategoryId;

	public Product() {
	}

	public String getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductDesc() {
		return this.productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductNumber() {
		return this.productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getSubCategoryId() {
		return this.subCategoryId;
	}

	public void setSubCategoryId(String subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

}