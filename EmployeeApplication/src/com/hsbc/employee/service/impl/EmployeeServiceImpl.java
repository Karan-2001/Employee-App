package com.hsbc.employee.service.impl;

import java.util.List;

import com.hsbc.employee.beans.Employee;
import com.hsbc.employee.dao.EmployeeDao;
import com.hsbc.employee.dao.impl.EmployeeDaoImpl;
import com.hsbc.employee.dao.impl.EmployeeDaoImplDB;
import com.hsbc.employee.exceptions.EmployeeAlreadyExistsException;
import com.hsbc.employee.exceptions.EmployeeNotFoundExceptions;
import com.hsbc.employee.service.EmployeeService;
import com.hsbc.employee.utils.EmployeeDaoFactoryPattern;

public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeDao dao ;
	EmployeeDaoFactoryPattern factory = new EmployeeDaoFactoryPattern();
	public EmployeeServiceImpl(String str) {
		dao=factory.getDaoImpl(str);
	}
	@Override
	public int addEmployee(Employee emp) throws EmployeeAlreadyExistsException {
		return dao.addEmployee(emp); 
	}
	@Override
	public int updateEmployee(Employee emp)throws EmployeeNotFoundExceptions {
		return dao.updateEmployee(emp);
	}
	@Override
	public int deleteEmployee(int code) throws EmployeeNotFoundExceptions{
		return dao.deleteEmployee(code);
	}
	@Override
	public List<Employee> findAll() {
		return dao.findAll();
	}
	@Override
	public Employee findBycode(int code)throws EmployeeNotFoundExceptions {
		return dao.findBycode(code);
	}

}
