package com.employee.service;

import com.employee.api.*;
import java.util.*;

//Creating a Helper class to be able to push test data into our database for convenient testing of various functions, in this case batchInsert
public class EmployeeDAOHelper {
	public void setupEmployeeTable() {
		Employee e1 = new Employee();
		e1.setE_id(0);
		e1.setE_name("Madhav");
		e1.setDept_name("IT");

		Employee e2 = new Employee();
		e2.setE_id(1);
		e2.setE_name("Madhav");
		e2.setDept_name("IT");

		Employee e3 = new Employee();
		e3.setE_id(2);
		e3.setE_name("Madhav");
		e3.setDept_name("IT");

		ArrayList<Employee> eList = new ArrayList<>();
		eList.add(e1);
		eList.add(e2);
		eList.add(e3);
	}
}
