package com.crabapp.spring.obj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8027642888460896491L;
	private String name, email;
	private int age;
	private int empId;
	private Address address;
	
	@Override
	public String toString() {
		return String.format("Employee [name = %s, email = %s, age = %d, address = %s %s]",name, email, age,address.getAddress1(), address.getAddress2());
	}

	public Employee(String name, String email, int age, Address address) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.address = address;
	}
	
	public static List<Employee> createEmployees(){
		List<Employee> employee = new ArrayList<Employee>();
		employee.add(new Employee("Dinesh", "dinesh@mail.com", 32,new Address()));
		employee.add(new Employee("Ashok", "ashok@mail.com", 28,new Address()));
		employee.add(new Employee("Chitra", "chitra@mail.com", 26,new Address()));
		employee.add(new Employee("Raja", "raja@mail.com", 32,new Address()));
		employee.add(new Employee("Suresh", "suresh@mail.com", 33,new Address()));
		employee.add(new Employee("Divya", "divya@mail.com", 31,new Address()));
        return employee;
	}
	
	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
