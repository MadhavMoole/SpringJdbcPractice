package com.madhav.dao;

import java.util.List;

import com.madhav.api.Student;

public interface StudentDAO {
	void insert(Student s);
	void insert(List<Student> ss);
	boolean deleteRecordByRollNo(int rollno);
	int deleteRecordByStudentNameOrStudentAddress(String name, String address);
	void cleanup();
	List<Student> findAllStudents();
	Student findStudentByRollNo(int rollNo);
}
