package com.employee.dao;

//import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.employee.api.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	// using the overloaded constructor of JdbcTemplate class to create an instance
	// of JdbcTemplate with the DataSource Object
	private JdbcTemplate jt;

	//We are going to use this mutator/setter in our bean configuration to set the JdbcTemplate object
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

	// This is a very stupid way of creating DataSource implementation, as you are
	// manually creating an Object of the dataSource Interface (using
	// DriverManagerDataSource Implementation), instead use Spring beans to ensure
	// that Spring is the one creating the Object of this Implementation and not the
	// programmer
	/* 	
	 * 	public DataSource dataSource() {
			String url = "jdbc:mysql://127.0.0.1:3306/employee";
			String username = "root";
			String password = "madh";
			return new DriverManagerDataSource(url, username, password);
		}
	*/
}
