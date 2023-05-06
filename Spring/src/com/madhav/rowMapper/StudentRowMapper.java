package com.madhav.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.madhav.api.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Student s = new Student();
		s.setRollno(rs.getInt(1));
		s.setName(rs.getString(2));
		s.setAddress(rs.getString(3));
		return s;
	}

}
