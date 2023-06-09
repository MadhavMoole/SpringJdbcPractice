package com.employee.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.employee.api.*;
import com.employee.dao.*;
import com.employee.service.EmployeeDAOHelper;

public class Test {

	// Now here we are going to create an instance of beans.xml file which we will
	// be using to access the instances created by Spring Framework
	private static ApplicationContext ctx;

	// before jumping to further code, check the ApplicationContext Interface
	public static void main(String[] args) {
		// we will modify the code a bit
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Application Context is Loaded");
		
		Employee e = new Employee();
		e.setE_id(0);
		e.setE_name("Madhav");
		e.setDept_name("IT");
		System.out.println(e);

		// we will create a better version of this trash implementation
		// EmployeeDAO ee = new EmployeeDAOImpl();

		// Here we are asking ClassPathApplicationContext whether there is a bean
		// available with the name "EmployeeDAO"
		EmployeeDAO ee = (EmployeeDAOImpl) ctx.getBean("EmployeeDAO");
		ee.insert(e);
		if(ee.deleteByID(0)) {
			System.out.println("SuccessFully Deleted!");
		} else {
			System.err.println("Please Try Again!");
		}
		
		System.out.println(ee.deleteByEmployeeNameOrDeptName("Madhav", "IT"));
		
		EmployeeDAOHelper eHelp = (EmployeeDAOHelper) ctx.getBean("DAOHelper");
		eHelp.setupEmployeeTable();
		
		List<Employee> eList = ee.ReadAllEmployee();
		eHelp.printList(eList);
	}

}
