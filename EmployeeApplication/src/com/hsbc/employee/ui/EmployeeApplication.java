package com.hsbc.employee.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import com.hsbc.employee.beans.Employee;
import com.hsbc.employee.exceptions.EmployeeAlreadyExistsException;
import com.hsbc.employee.exceptions.EmployeeNotFoundExceptions;
import com.hsbc.employee.service.EmployeeService;
import com.hsbc.employee.service.impl.EmployeeServiceImpl;
import com.hsbc.employee.utils.EmployeeDaoFactoryPattern;

public class EmployeeApplication {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeService service = new EmployeeServiceImpl("database");
		int choice=0;
		while(choice!=6) {
			System.out.println("1. Add Employee");
			System.out.println("2. Update Employee by code");
			System.out.println("3. Delete Employee by code");
			System.out.println("4. Search Employee");
			System.out.println("5. Display ALL Employee");
			System.out.println("6. Exit");
			System.out.println("Enter choice ");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
			{
				System.out.println("Enter code name, salary doj");
				int code = sc.nextInt();
				String name = sc.next();
				double salary = sc.nextDouble();
				String doj = sc.next();
				LocalDate datejoin = LocalDate.parse(doj, 
						DateTimeFormatter.ISO_DATE);
				Employee emp = new Employee();
				emp.setCode(code);
				emp.setName(name);
				emp.setSalary(salary);
				emp.setDoj(datejoin);
				try {
					int rows=service.addEmployee(emp);
					if(rows>0)
						System.out.println("inserted");
					else
						System.out.println("not-inserted");
				} catch (EmployeeAlreadyExistsException e) {
					System.err.println(e.getMessage());
				}
				break;
				}
			case 2:
			{	System.out.println("Enter code, updated name, updated salary, updated doj:");
				int code = sc.nextInt();
				String name = sc.next();
				double salary = sc.nextDouble();
				String doj = sc.next();
				LocalDate datejoin = LocalDate.parse(doj, 
						DateTimeFormatter.ISO_DATE);
				Employee emp = new Employee();
				emp.setCode(code);
				emp.setName(name);
				emp.setSalary(salary);
				emp.setDoj(datejoin);
				try {
					int rows=service.updateEmployee(emp);
					if(rows>0)
						System.out.println("Updated");
					else
						System.out.println("not-Updated");
				} catch (EmployeeNotFoundExceptions e) {
					System.err.println(e.getMessage());
				}
				break;
			}
			case 3:
			{
				System.out.println("Enter the employee code:");
				int code =sc.nextInt();
				try {
					int rows= service.deleteEmployee(code);
					if(rows>0)
						System.out.println("Deleted");
					else
						System.out.println("Not-Deleted");
					
				} catch (EmployeeNotFoundExceptions e) {
					System.err.println(e.getMessage());
					// TODO Auto-generated catch block
					
				
			}
				break;
			}
			case 4:{
				System.out.println("Enter the employee code:");
				int code =sc.nextInt();
				try {
					Employee emp= service.findBycode(code);
					System.out.println(emp);
				} catch (EmployeeNotFoundExceptions e) {
					System.err.println(e.getMessage());
					// TODO Auto-generated catch block
					
				}
				break;
			}
			case 5:
			{
				List<Employee> list = service.findAll();
				for (Employee emp : list) {
					System.out.println(emp);
				}
			}
			}
		}
		System.out.println("completed");  
		sc.close();
	}
}
