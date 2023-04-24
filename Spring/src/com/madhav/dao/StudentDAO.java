package com.madhav.dao;

import com.madhav.api.Student;

public interface StudentDAO {
	void insert(Student s);
	boolean deleteRecordByRollNo(int rollno);
	int deleteRecordByStudentNameOrStudentAddress(String name, String address);
}
