package com.employee.dao;

import org.springframework.beans.factory.annotation.Autowired;

//import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.employee.api.Employee;

@Repository("EmployeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

	// using the overloaded constructor of JdbcTemplate class to create an instance
	// of JdbcTemplate with the DataSource Object
	// private JdbcTemplate jt =  new JdbcTemplate(dataSource());
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
	@Autowired
=======
>>>>>>> f9df5584d580aa1c1efc1510eff2084430e31464
>>>>>>> Stashed changes
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
		Object[] arg = {e_name, dept_name};
		int upd = jt.update(sql, arg);
		return upd;
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
