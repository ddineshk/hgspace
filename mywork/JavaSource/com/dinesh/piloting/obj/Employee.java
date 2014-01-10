package com.dinesh.piloting.obj;

public class Employee {
	private String name;
	private String ssNum;

	public Employee(String name, String ssNum) {
		this.name = name;
		this.ssNum = ssNum;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the ssNum
	 */
	public String getSsNum() {
		return ssNum;
	}

	/**
	 * @param ssNum the ssNum to set
	 */
	public void setSsNum(String ssNum) {
		this.ssNum = ssNum;
	}

}
