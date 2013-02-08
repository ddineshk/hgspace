package com.dinesh.piloting.mybatis.model;

import java.io.Serializable;

/**
 * The persistent class for the "subcategory" database table.
 * 
 */
public class Subcategory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5450703477448778765L;

	private String categoryId;

	private int subcategoryId;

	private String subcategoryName;

	public Subcategory() {
	}

	public String getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public int getSubcategoryId() {
		return this.subcategoryId;
	}

	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public String getSubcategoryName() {
		return this.subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

}