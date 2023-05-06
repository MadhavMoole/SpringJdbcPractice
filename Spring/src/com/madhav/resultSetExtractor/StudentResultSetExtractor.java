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
			s.setRollno(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setAddress(rs.getString(3));
			sList.add(s);
		}
		return sList;
	}

}
