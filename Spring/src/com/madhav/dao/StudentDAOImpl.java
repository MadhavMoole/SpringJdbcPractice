package com.madhav.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.madhav.api.Student;

@Repository("Studentdao")   
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
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
	
}
