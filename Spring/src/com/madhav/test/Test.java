package com.madhav.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.madhav.api.Student;
import com.madhav.dao.StudentDAO;
import com.madhav.dao.StudentDAOImpl;

public class Test {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		// Note:
		// Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver
		// class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered
		// via the SPI and manual loading of the driver class is generally unnecessary.
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Application Context Loaded!");

		Student t = new Student();
		t.setRollno(1);
		t.setAddress("Goregaon");
		t.setName("Test1");
		System.out.println(t);
	   

		// Creating the object
		StudentDAO ss = (StudentDAOImpl) ctx.getBean("Studentdao");
		/* 
		if(ss.deleteRecordByRollNo(0)) {
			System.out.println("Data Deleted!");
		} else {
			System.err.println("Error!");
		}
		*/
		ss.insert(t);
		if(ss.deleteRecordByStudentNameOrStudentAddress(null, "Goregaon") == 1) {
			System.out.println("DONE!");
		} else {
			System.out.println("YOU SUCK!");
		}
		
	}

}
