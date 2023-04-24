package com.employee.dao;

import com.employee.api.Employee;

public interface EmployeeDAO {
	void insert(Employee e);
	boolean deleteByID(int eID);
	int deleteByEmployeeNameOrDeptName(String e_name, String dept_name);
}
