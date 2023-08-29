package com.hsbc.employee.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.hsbc.employee.beans.Employee;
import com.hsbc.employee.dao.EmployeeDao;
import com.hsbc.employee.exceptions.EmployeeAlreadyExistsException;

public class EmployeeDaoImpl implements EmployeeDao{
	List<Employee> emplist = new ArrayList<>();
	@Override
	public int addEmployee(Employee emp) throws EmployeeAlreadyExistsException {
		if(emplist.contains(emp))
			throw new EmployeeAlreadyExistsException();
		emplist.add(emp);
		return 1;
	}
	@Override
	public int updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteEmployee(int code) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Employee findBycode(int code) {
		// TODO Auto-generated method stub
		return null;
	}

}
