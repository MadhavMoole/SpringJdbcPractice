package com.employee.dao;

import java.util.List;

import com.employee.api.Employee;

public interface EmployeeDAO {
	void insert(Employee e);

	boolean deleteByID(int eID);

	int deleteByEmployeeNameOrDeptName(String e_name, String dept_name);

	void cleanup();

	void insert(List<Employee> e);

	// Here we consider the return type as List because we do not know how many
	// records are going to be returned , since Lists are dynamic in size we will
	// use them over normal arrays.
	List<Employee> ReadAllEmployee();
	
	Employee returnEmployeeByID(int e_ID);
}
