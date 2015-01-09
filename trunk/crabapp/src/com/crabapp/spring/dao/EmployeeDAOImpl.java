package com.crabapp.spring.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.crabapp.spring.obj.Employee;

public class EmployeeDAOImpl extends HibernateDaoSupport implements EmployeeDAO {
	@Override
	public void insert(Employee employee) {
		getHibernateTemplate().save(employee);
	}

	@Override
	public List<Employee> showAll() {
		return null;
	}

	@Override
	public List<Employee> queryByEmployeeName(String employeeName) {
		return null;
	}

	@Override
	public Employee queryByEmployeeId(Integer id) {
		return null;
	}

	@Override
	public void deleteEmployee(Employee employee) {
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		
	}

}
