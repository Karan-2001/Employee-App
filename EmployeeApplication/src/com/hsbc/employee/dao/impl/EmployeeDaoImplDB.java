package com.hsbc.employee.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.employee.beans.Employee;
import com.hsbc.employee.dao.EmployeeDao;
import com.hsbc.employee.exceptions.EmployeeAlreadyExistsException;
import com.hsbc.employee.exceptions.EmployeeNotFoundExceptions;
import com.hsbc.employee.utils.DBConnection;

public class EmployeeDaoImplDB implements EmployeeDao{
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	@Override
	public int addEmployee(Employee emp) throws EmployeeAlreadyExistsException {
		String addqry = "insert into employee values(?,?,?,?)";
		int rows=0;
		
		conn = DBConnection.getConnection();
		String selectquery="select * from employee where code=?";
		try {
			pst=conn.prepareStatement(selectquery);
			pst.setInt(1, emp.getCode());
			rs=pst.executeQuery();
			if(rs.next())
				throw new EmployeeAlreadyExistsException();
			
		} catch (SQLException e) {
			//
		}
		try {
			pst = conn.prepareStatement(addqry);
			pst.setInt(1, emp.getCode());
			pst.setString(2, emp.getName());
			pst.setDouble(3, emp.getSalary());
			pst.setString(4, emp.getDoj().toString()); 
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnection.close();
		return rows;
	}

	@Override
	public int updateEmployee(Employee emp)throws EmployeeNotFoundExceptions {
		int rows=0;
		conn = DBConnection.getConnection();
		String selectquery="select * from employee where code=?";
		try {
			pst=conn.prepareStatement(selectquery);
			pst.setInt(1, emp.getCode());
			rs=pst.executeQuery();
			if(!rs.next())
				throw new EmployeeNotFoundExceptions();
			
		} catch (SQLException e) {
			//
		}
		String updateQuery="update employee set name=?,salary=?,doj=? where code=?";
		try {
			pst=conn.prepareStatement(updateQuery);
			pst.setString(1, emp.getName());
			pst.setDouble(2, emp.getSalary());
			pst.setString(3, emp.getDoj().toString()); 
			pst.setInt(4, emp.getCode());
			rows=pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnection.close();
		return rows;
	}

	@Override
	public int deleteEmployee(int code)throws EmployeeNotFoundExceptions {
		int rows=0;
		conn = DBConnection.getConnection();
		String selectquery="select * from employee where code=?";
		try {
			pst=conn.prepareStatement(selectquery);
			pst.setInt(1, code);
			rs=pst.executeQuery();
			if(!rs.next())
				throw new EmployeeNotFoundExceptions();
			
		} catch (SQLException e) {
			//
		}
		String deleteQuery="delete from  employee where code=?";
		try {
			pst=conn.prepareStatement(deleteQuery);
			
			pst.setInt(1, code);
			rows=pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnection.close();
		return rows;
		
	}

	@Override
	public List<Employee> findAll() {
		String selectquery="select * from employee";
		List<Employee> empList = new ArrayList<>();
		conn=DBConnection.getConnection();
		try {
			pst=conn.prepareStatement(selectquery);
			rs=pst.executeQuery();
			while(rs.next()) {
				Employee emp =new Employee();
				emp.setCode(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getDouble(3));
				LocalDate date = LocalDate.parse(rs.getDate(4).toString(),DateTimeFormatter.ISO_DATE);
				emp.setDoj(date);
				empList.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnection.close();
		return empList;
	}

	@Override
	public Employee findBycode(int code) throws EmployeeNotFoundExceptions {
		conn = DBConnection.getConnection();
		String selectquery="select * from employee where code=?";
		try {
			pst=conn.prepareStatement(selectquery);
			pst.setInt(1, code);
			rs=pst.executeQuery();
			if(rs.next())
			{
				Employee emp = new Employee();
				emp.setCode(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getDouble(3));
				LocalDate date = LocalDate.parse(rs.getDate(4).toString(),DateTimeFormatter.ISO_DATE);
				emp.setDoj(date);
				return emp;
				
			}
			 
			
		} catch (SQLException e) {
			//
		}
		DBConnection.close();
		throw new EmployeeNotFoundExceptions();
		
	}

}
