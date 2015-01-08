package com.crabapp.spring.obj;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private String name, email;
	private int age;
	private int empId;
	private Address address;
	
	@Override
	public String toString() {
		return String.format("Person [name = %s, email = %s, age = %d, address = %s %s]",name, email, age,address.getAddress1(), address.getAddress2());
	}

	public Person(String name, String email, int age, Address address) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.address = address;
	}
	
	public static List<Person> createPersons(){
		List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Dinesh", "dinesh@mail.com", 32,new Address()));
        persons.add(new Person("Ashok", "ashok@mail.com", 28,new Address()));
        persons.add(new Person("Chitra", "chitra@mail.com", 26,new Address()));
        persons.add(new Person("Raja", "raja@mail.com", 32,new Address()));
        persons.add(new Person("Suresh", "suresh@mail.com", 33,new Address()));
        persons.add(new Person("Divya", "divya@mail.com", 31,new Address()));
        return persons;
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
