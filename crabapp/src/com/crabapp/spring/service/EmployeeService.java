package com.crabapp.spring.service;

import java.util.List;

import com.crabapp.spring.obj.Employee;

public interface EmployeeService {
	void insert(Employee employee);

	List<Employee> showAll();

	List<Employee> queryByEmployeeName(String employeeName);

	Employee queryByEmployeeId(Integer id);

	void deleteEmployee(Employee employee);

	void updateEmployee(Employee employee);
}
