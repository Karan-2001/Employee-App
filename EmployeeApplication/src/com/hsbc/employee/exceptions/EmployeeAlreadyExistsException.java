package com.hsbc.employee.exceptions;

@SuppressWarnings("serial")
public class EmployeeAlreadyExistsException extends Exception{
	public EmployeeAlreadyExistsException() {
		super("employee already exists...");
	}
}
