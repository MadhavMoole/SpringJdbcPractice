package com.madhav.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.madhav.api.Student;
import com.madhav.resultSetExtractor.*;
import com.madhav.rowMapper.*;

//@Repository("Studentdao")   
public class StudentDAOImpl implements StudentDAO {

	// @Autowired
	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public void insert(Student s) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO STUDENT VALUES(?,?,?)";
		Object[] arg = { s.getRollno(), s.getName(), s.getAddress() };
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
		Object[] arg = { name, address };
		int upd = jt.update(sql, arg);
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
		for (Student temp : ss) {
			Object[] studentData = { temp.getRollno(), temp.getName(), temp.getAddress() };
			sqlArgs.add(studentData);
		}
		jt.batchUpdate(sql, sqlArgs);
		System.out.println("Batch Update Successful");
	}

	@Override
	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub

		String sql = "Select * from Student";
		List<Student> st = jt.query(sql, new StudentRowMapper());
		return st;
	}

	@Override
	public Student findStudentByRollNo(int rollNo) {
		// TODO Auto-generated method stub
		String sql = "Select ROLL_NO as rollNo, STUDENT_NAME as name, STUDENT_ADDR as address from Student where ROLL_NO = ?";

		// difference between queryForObject and query method in JdbcTemplate ,
		// queryForObject simply returns the object of the class i.e returns a single
		// row from the Database whereas query returns the a List<>
		// implementation i.e a list of rows from the DataBase
		Student s = jt.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), rollNo);
		return s;
	}

	@Override
	public int updateStudent(Student s) {
		// TODO Auto-generated method stub
		String sql = "Update Student set STUDENT_ADDR = ? where ROLL_NO = ?";
		Object[] args = {s.getAddress(), s.getRollno()};
		int nor = jt.update(sql, args);
		return nor;
	}

	@Override
	public List<Student> findStudentByName(String name) {
		// TODO Auto-generated method stub
		String sql = "Select * from Student where STUDENT_NAME = ?";
		List<Student> sList = jt.query(sql, new StudentResultSetExtractor(), name);
		return sList;
	}

	@Override
	public Map<String, List<String>> listStudentsByAddress() {
		// TODO Auto-generated method stub
		String sql = "Select * from Student";
		Map<String, List<String>> hm = jt.query(sql, new StudentAddressResultSetExtractor());
		return hm;
	}

	@Override
	public int updateStudent(List<Student> sList) {
		// TODO Auto-generated method stub
		String sql = "Update Student set STUDENT_ADDR = ? where ROLL_NO = ?";
		jt.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				// TODO Auto-generated method stub
				//ps identifies as the sql statement we have set above
				//we are going to provide the values from the ArrayList for each row to be updated
				ps.setString(1, sList.get(i).getAddress());
				ps.setInt(2, sList.get(i).getRollno());
			}
			
			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return sList.size();
			}
		});
		return 0;
	}

}
