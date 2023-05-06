package com.madhav.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.madhav.resultSetExtractor.*;

import com.madhav.api.Student;
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
		String sql = "SELECT * FROM school.student";
		List<Student> studentList = jt.query(sql, new StudentRowMapper());
		return studentList;
	}

	// Here we are going to use BeanPropertyRowMapper class which is an
	// implementation of the RowMapper class similar to what we have used in
	// StudentRowMapper but is provided by spring, it uses a Generic template which
	// we can use to set it according to the class we have in need i.e The Student
	// Class in this case, it will Map the values of the database to an object of
	// the student class and return it back to the user
	@Override
	public Student findStudentByRollNo(int rollNo) {
		// TODO Auto-generated method stub
		String sql = "SELECT ROLL_NO as rollno, STUDENT_NAME as name, STUDENT_ADDR as address FROM school.student where ROLL_NO = ?";
		Student st = jt.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), rollNo);
		return st;
	}

	@Override
	public List<Student> findStudentByName(String name) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM STUDENT WHERE STUDENT_NAME = ?";
		List<Student> sList = jt.query(sql, new StudentResultSetExtractor(), name);
		return sList;
	}

	@Override
	public Map<String, List<String>> listStudentsByAddress() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM school.student";
		HashMap<String, List<String>> uwu = jt.query(sql, new StudentAddressExtractor());
		return uwu;
	}

	@Override
	public int updateStudent(Student s) {
		// TODO Auto-generated method stub
		String sql = "Update Student set STUDENT_ADDR = ? where ROLL_NO = ?";
		Object[] args = { s.getAddress(), s.getRollno() };
		jt.update(sql, args);
		System.out.println("Data Updated!");
		return 0;
	}

	@Override
	public int updateStudent(List<Student> sList) {
		// TODO Auto-generated method stub
		String sql = "Update Student set STUDENT_ADDR = ? where ROLL_NO = ?";

		jt.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				// TODO Auto-generated method stub

				// For setting the arguments for the sql statement
				ps.setString(1, sList.get(i).getAddress());
				ps.setInt(2, sList.get(i).getRollno());
				System.out.println("Inside setValues method");
			}

			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub

				// in this we need to define how many times our query will execute i.e how many
				// times the setValues() is going to get executed.
				System.out.println("Inside getBatchSize method");
				return sList.size();
			}
		});
		return 0;
	}

}
