package com.madhav.service;
import com.madhav.api.*;
import com.madhav.dao.StudentDAOImpl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class StudentDAOHelper {
	
	private StudentDAOImpl sDAO;
	
	public void setsDAO(StudentDAOImpl sDAO) {
		this.sDAO = sDAO;
	}

	public void setupStudentTable() {
		Student s1 = new Student();
		s1.setRollno(1);
		s1.setName("Madhav");
		s1.setAddress("Borivali");
		
		Student s2 = new Student();
		s2.setRollno(2);
		s2.setName("Musashi");
		s2.setAddress("Dahisar");
		
		Student s3 = new Student();
		s3.setRollno(3);
		s3.setName("Kama");
		s3.setAddress("Kandivali");
		
		ArrayList<Student> sList = new ArrayList<>();
		sList.add(s1);
		sList.add(s2);
		sList.add(s3);
		
		sDAO.insert(sList);
	}
}
