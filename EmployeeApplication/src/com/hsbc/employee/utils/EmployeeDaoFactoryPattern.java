package com.hsbc.employee.utils;

import com.hsbc.employee.dao.EmployeeDao;
import com.hsbc.employee.dao.impl.EmployeeDaoImpl;
import com.hsbc.employee.dao.impl.EmployeeDaoImplDB;

public class EmployeeDaoFactoryPattern {
	EmployeeDao dao;
	public EmployeeDao getDaoImpl(String impl) {
		switch(impl) {
		case "database":
			dao = new EmployeeDaoImplDB();break;
		case "collection":
			dao = new EmployeeDaoImpl();break;
		}
		return dao;
	}

}
