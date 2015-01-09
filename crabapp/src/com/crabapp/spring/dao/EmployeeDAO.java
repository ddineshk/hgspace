package com.crabapp.spring.dao;


import java.util.List;

import com.crabapp.spring.obj.Employee;


public interface EmployeeDAO {
	void insert(Employee employee);
	
	List<Employee> showAll();
	
	List<Employee> queryByEmployeeName(String employeeName);
	
	Employee queryByEmployeeId(Integer id);
	
	void deleteEmployee(Employee employee);
	
	void updateEmployee(Employee employee);
}
