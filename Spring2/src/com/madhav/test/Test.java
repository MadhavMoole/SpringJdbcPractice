package com.madhav.test;

import java.util.List;
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
		List<Student> sList = student.findAllStudents();
		
		StudentDAOHelper help = ctx.getBean("DAOHelper", StudentDAOHelper.class);
		help.printStudent(sList);
		
	}

}
