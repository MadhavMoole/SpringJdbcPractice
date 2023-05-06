package com.madhav.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.madhav.api.Student;

public class StudentResultSetExtractor implements ResultSetExtractor<List<Student>> {

	@Override
	public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		List<Student> sList = new ArrayList<>();
		while(rs.next()) {
			Student s = new Student();
			s.setRollno(rs.getInt("ROLL_NO"));
			s.setName(rs.getString("STUDENT_NAME"));
			s.setAddress(rs.getString("STUDENT_ADDR"));
			sList.add(s);
		}
		System.out.println("Inside the extract data method");
		return sList;
	}

}
