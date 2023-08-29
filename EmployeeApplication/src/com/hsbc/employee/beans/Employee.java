package com.hsbc.employee.beans;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
	@Override
	public String toString() {
		return "Employee [code=" + code + ", name=" + name + ", salary=" + salary + ", doj=" + doj + "]";
	}
	private int code;
	private String name;
	private double salary;
	private LocalDate doj;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	@Override
	public int hashCode() {
		return Objects.hash(code, doj, name, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return code == other.code && Objects.equals(doj, other.doj) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}
	
}
