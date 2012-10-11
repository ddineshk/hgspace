package com.dinesh.piloting.struts.bean;

public class AdminBean {
	private int admin_Id;
    private String admin_Name;
    private String admin_Pwd;
    private String admin_Flag;
	public AdminBean() {
		
	}
	
	
	/**
	 * @return the admin_Id
	 */
	public int getAdmin_Id() {
		return admin_Id;
	}


	/**
	 * @param admin_Id the admin_Id to set
	 */
	public void setAdmin_Id(int admin_Id) {
		this.admin_Id = admin_Id;
	}


	/**
	 * @return the admin_Name
	 */
	public String getAdmin_Name() {
		return admin_Name;
	}
	/**
	 * @param admin_Name the admin_Name to set
	 */
	public void setAdmin_Name(String admin_Name) {
		this.admin_Name = admin_Name;
	}
	/**
	 * @return the admin_Pwd
	 */
	public String getAdmin_Pwd() {
		return admin_Pwd;
	}
	/**
	 * @param admin_Pwd the admin_Pwd to set
	 */
	public void setAdmin_Pwd(String admin_Pwd) {
		this.admin_Pwd = admin_Pwd;
	}
	/**
	 * @return the admin_Flag
	 */
	public String getAdmin_Flag() {
		return admin_Flag;
	}
	/**
	 * @param admin_Flag the admin_Flag to set
	 */
	public void setAdmin_Flag(String admin_Flag) {
		this.admin_Flag = admin_Flag;
	}

}
