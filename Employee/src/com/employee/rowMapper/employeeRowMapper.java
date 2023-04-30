package com.employee.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.employee.api.Employee;

public class employeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Employee e = new Employee();

		// Note: Column indices start from 1 so, in case we do not remember column
		// names(Majority of the situations), use column indices to access the values of
		// the columns
		e.setE_id(rs.getInt(1));
		e.setE_name(rs.getString(2));
		e.setDept_name(rs.getString(3));
		return e;
	}

}
