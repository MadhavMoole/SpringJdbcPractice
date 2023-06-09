package com.employee.dao;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
//import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import com.employee.api.Employee;
import com.employee.rowMapper.*;

@Repository("EmployeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

	// using the overloaded constructor of JdbcTemplate class to create an instance
	// of JdbcTemplate with the DataSource Object
	// private JdbcTemplate jt = new JdbcTemplate(dataSource());
	@Autowired
	private JdbcTemplate jt;

	// We are going to use this mutator/setter in our bean configuration to set the
	// JdbcTemplate object
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public void insert(Employee e) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO EMPLOYEE VALUES (?, ?, ?)";
		Object[] args = { e.getE_id(), e.getE_name(), e.getDept_name() };
		int nor = jt.update(sql, args);
		System.out.println("No of rows updated: " + nor);
	}

	@Override
	public boolean deleteByID(int eID) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM EMPLOYEE WHERE e_ID = ?";
		return jt.update(sql, eID) == 1;
	}

	@Override
	public int deleteByEmployeeNameOrDeptName(String e_name, String dept_name) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM EMPLOYEE WHERE e_NAME = ? OR dept_NAME = ?";
		Object[] arg = { e_name, dept_name };
		int upd = jt.update(sql, arg);
		return upd;
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		String sql = "TRUNCATE TABLE EMPLOYEE";
		// Note : You can use update method as well but it will return 1 upon
		// successfully performing the methods, usually execute is preferred for all
		// these DDL statements
		jt.execute(sql);
		System.out.println("All records deleted!");
	}

	@Override
	public void insert(List<Employee> e) {
		// TODO Auto-generated method stub
		ArrayList<Object[]> eList = new ArrayList<>();
		for (Employee ee : e) {
			Object[] employeeList = { ee.getE_id(), ee.getE_name(), ee.getDept_name() };
			eList.add(employeeList);
		}
		String sql = "INSERT INTO EMPLOYEE VALUES (?, ?, ?)";
		jt.batchUpdate(sql, eList);
		System.out.println("Inserted Batch SuccessFully");
	}

	@Override
	public List<Employee> ReadAllEmployee() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM EMPLOYEE";

		// This will call the rowMap function in the employeeRowMapper class as long as
		// values exist in the database
		List<Employee> eList = jt.query(sql, new employeeRowMapper());
		return eList;
	}

	@Override
	public Employee returnEmployeeByID(int e_ID) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM EMPLOYEE WHERE e_ID = ?";
		Employee obj = jt.queryForObject(sql, new employeeRowMapper(), e_ID);
		
		/* We can also use the BeanPropertyRowMapper class to do the same...
		 * 
		 * Employee TestObj = jt.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class), e_ID);
		 * return TestObj;
		 * 
		 * */
		return obj;
	}

	// This is a very stupid way of creating DataSource implementation, as you are
	// manually creating an Object of the dataSource Interface (using
	// DriverManagerDataSource Implementation), instead use Spring beans to ensure
	// that Spring is the one creating the Object of this Implementation and not the
	// programmer
	/*
	 * public DataSource dataSource() { String url =
	 * "jdbc:mysql://127.0.0.1:3306/employee"; String username = "root"; String
	 * password = "madh"; return new DriverManagerDataSource(url, username,
	 * password); }
	 */
}
