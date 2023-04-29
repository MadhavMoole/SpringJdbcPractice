package com.employee.dao;

import java.util.List;

import com.employee.api.Employee;

public interface EmployeeDAO {
	void insert(Employee e);
	boolean deleteByID(int eID);
	int deleteByEmployeeNameOrDeptName(String e_name, String dept_name);
	void cleanup();
	void insert(List<Employee> e);
}
