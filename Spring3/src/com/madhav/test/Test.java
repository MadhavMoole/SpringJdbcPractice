package com.madhav.test;

import java.util.*;
import java.util.ListIterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.madhav.api.Student;
import com.madhav.dao.StudentDAO;
import com.madhav.dao.StudentDAOImpl;
import com.madhav.service.StudentDAOHelper;

public class Test {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		// Note:
		// Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver
		// class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered
		// via the SPI and manual loading of the driver class is generally unnecessary.
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Application Context Loaded!");
		
		StudentDAOImpl student = ctx.getBean("Studentdao", StudentDAOImpl.class);
		//List<Student> sList = student.findAllStudents();
		//System.out.println(student.findStudentByRollNo(2));
		//System.out.println(student.findStudentByName("Musashi"));
		
		//StudentDAOHelper help = ctx.getBean("DAOHelper", StudentDAOHelper.class);
		//help.printStudent(sList);
		
		//Map<String,  List<String>> hm = student.listStudentsByAddress();
		//System.out.println(hm);
		
		Student s = new Student();
		s.setAddress("Andheri");
		s.setRollno(1);
		
		Student s1 = new Student();
		s1.setAddress("Andheri");
		s1.setRollno(2);
		
		Student s2 = new Student();
		s2.setAddress("Andheri");
		s2.setRollno(3);
		
		Student s3 = new Student();
		s3.setAddress("Andheri");
		s3.setRollno(4);
		
		List<Student> sList =  new ArrayList<>();
		sList.add(s);
		sList.add(s1);
		sList.add(s2);
		sList.add(s3);
		
		student.updateStudent(sList);
	}

}
