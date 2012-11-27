package com.dinesh.piloting.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.dinesh.piloting.obj.Employee;

public class RegForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private List<Employee> personList=null;
	  private String[] selPerson=null;
	/**
	 * @return the personList
	 */
	public List<Employee> getPersonList() {
		return personList;
	}
	/**
	 * @param personList the personList to set
	 */
	public void setPersonList(List<Employee> personList) {
		this.personList = personList;
	}
	/**
	 * @return the selPerson
	 */
	public String[] getSelPerson() {
		return selPerson;
	}
	/**
	 * @param selPerson the selPerson to set
	 */
	public void setSelPerson(String[] selPerson) {
		this.selPerson = selPerson;
	}
	
	  
	}
