package com.madhav.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.madhav.api.Student;

//@Repository("Studentdao")   
public class StudentDAOImpl implements StudentDAO {
	
	//@Autowired
	private JdbcTemplate jt;
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	@Override
	public void insert(Student s) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO STUDENT VALUES(?,?,?)";
		Object[] arg = {s.getRollno(), s.getName(), s.getAddress()};
		int nor = jt.update(sql, arg);
		System.out.println("No of rows inserted: " + nor);
	}

	@Override
	public boolean deleteRecordByRollNo(int rollno) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM STUDENT WHERE ROLL_NO = ?";
		return jt.update(sql, rollno) == 1;
	}

	@Override
	public int deleteRecordByStudentNameOrStudentAddress(String name, String address) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM STUDENT WHERE STUDENT_NAME = ? OR STUDENT_ADDR = ?";
		Object[] arg = {name, address};
		int upd = jt.update(sql , arg);
		return upd;
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		String sql = "TRUNCATE TABLE STUDENT";
		jt.execute(sql);
		System.out.println("Table Cleaned up!");
	}

	@Override
	public void insert(List<Student> ss) {
		// TODO Auto-generated method stub
		ArrayList<Object[]> sqlArgs = new ArrayList<>();
		String sql = "INSERT INTO STUDENT VALUES (?, ?, ?)";
		for(Student temp : ss) {
			Object[] studentData = {temp.getRollno(), temp.getName(), temp.getAddress()};
			sqlArgs.add(studentData);
		}
		jt.batchUpdate(sql, sqlArgs);
		System.out.println("Batch Update Successful");
	}
	
	
}
