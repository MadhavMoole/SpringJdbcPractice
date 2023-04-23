package com.employee.test;

import com.employee.api.*;
import com.employee.dao.*;
public class Test {

	public static void main(String[] args) {
		Employee e = new Employee();
		e.setE_id(0);
		e.setE_name("Madhav");
		e.setDept_name("IT");
		System.out.println(e);
		
		EmployeeDAO ee = new EmployeeDAOImpl();
		ee.insert(e);
	}

}
