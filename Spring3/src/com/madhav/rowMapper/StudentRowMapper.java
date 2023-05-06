package com.madhav.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.madhav.api.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Student newStudent = new Student();

		newStudent.setRollno(rs.getInt("ROLL_NO"));
		newStudent.setName(rs.getString("STUDENT_NAME"));
		newStudent.setAddress(rs.getString("STUDENT_ADDR"));
		System.out.println("Inside the map row method");
		return newStudent;
	}

}
