package com.hsbc.employee.exceptions;

@SuppressWarnings("serial")
public class EmployeeNotFoundExceptions extends Exception {
	public EmployeeNotFoundExceptions() {
		super("Employee not found in database..");
	}

}
