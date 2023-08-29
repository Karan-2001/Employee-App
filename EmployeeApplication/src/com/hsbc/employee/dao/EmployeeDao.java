package com.hsbc.employee.dao;

import java.util.List;

import com.hsbc.employee.beans.Employee;
import com.hsbc.employee.exceptions.EmployeeAlreadyExistsException;
import com.hsbc.employee.exceptions.EmployeeNotFoundExceptions;

public interface EmployeeDao {
	int addEmployee(Employee emp) throws EmployeeAlreadyExistsException;
	int updateEmployee(Employee emp)throws EmployeeNotFoundExceptions;
	int deleteEmployee(int code)throws EmployeeNotFoundExceptions;
	List<Employee> findAll();
	Employee findBycode(int code) throws EmployeeNotFoundExceptions;
}
