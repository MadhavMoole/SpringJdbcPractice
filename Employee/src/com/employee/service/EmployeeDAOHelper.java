package com.employee.service;

import com.employee.api.*;
import com.employee.dao.EmployeeDAOImpl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Creating a Helper class to be able to push test data into our database for convenient testing of various functions, in this case batchInsert

@Service("DAOHelper")
public class EmployeeDAOHelper {
	@Autowired
	private EmployeeDAOImpl eDAO; 
	
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
		
		eDAO.insert(eList);
	}
	
	public void printList(List<Employee> eList) {
		for(Employee e : eList) {
			System.out.println("Employee [e_id=" + e.getE_id() + ", e_name=" + e.getE_name() + ", dept_name=" + e.getDept_name() + "]");
		}
	}
}
