package com.crabapp.spring.service;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.crabapp.spring.dao.EmployeeDAOImpl;
import com.crabapp.spring.obj.Employee;

public class EmployeeServiceImpl extends HibernateDaoSupport implements EmployeeService {

	

	public EmployeeDAOImpl employeeDAOImpl = null;
	
	@Override
	public void insert(Employee employee) {
		employeeDAOImpl.insert(employee);
	}

	@Override
	public List<Employee> showAll() {
		return employeeDAOImpl.showAll();
	}

	@Override
	public List<Employee> queryByEmployeeName(String employeeName) {
		return employeeDAOImpl.queryByEmployeeName(employeeName);
	}

	@Override
	public Employee queryByEmployeeId(Integer id) {
		return employeeDAOImpl.queryByEmployeeId(id);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeDAOImpl.deleteEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDAOImpl.updateEmployee(employee);
	}

	/**
	 * @return the employeeDAOImpl
	 */
	public EmployeeDAOImpl getEmployeeDAOImpl() {
		return employeeDAOImpl;
	}

	/**
	 * @param employeeDAOImpl the employeeDAOImpl to set
	 */
	public void setEmployeeDAOImpl(EmployeeDAOImpl employeeDAOImpl) {
		this.employeeDAOImpl = employeeDAOImpl;
	}
}
