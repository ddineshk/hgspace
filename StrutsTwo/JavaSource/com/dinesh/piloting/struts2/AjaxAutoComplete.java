package com.dinesh.piloting.struts2;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.opensymphony.xwork2.ActionSupport;

public class AjaxAutoComplete extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String data = "Afghanistan, Zimbabwe, India, United States, Germany, China, Israel";
	private List<String> countries;
	private String country;
	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}
	/**
	 * @return the countries
	 */
	public List<String> getCountries() {
		return countries;
	}
	/**
	 * @param countries the countries to set
	 */
	public void setCountries(List<String> countries) {
		this.countries = countries;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String execute(){
		countries = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(data,",");
		while (st.hasMoreTokens()) {
            countries.add(st.nextToken().trim());
        }
		return SUCCESS;
	}

}
