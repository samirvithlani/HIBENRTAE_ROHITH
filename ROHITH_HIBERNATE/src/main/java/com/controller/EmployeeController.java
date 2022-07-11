package com.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.EmployeeBean;
import com.util.DBConnection;

public class EmployeeController {

	public void addEmployee() {

		// need connection
		Session session = DBConnection.getConnection();
		if (session != null) {
			// transaction
			Transaction tr = session.beginTransaction();
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.seteName("jay");
			employeeBean.seteEmail("jay@gmail.com");
			employeeBean.setAge(22);

			session.save(employeeBean);
			tr.commit();

			System.out.println("employee data saved...");
			session.close();

		}
	}

	public void updateEmployee() {

		Session session = DBConnection.getConnection();
		if (session != null) {

			Transaction tr = session.beginTransaction();
			// EmployeeBean emp = session.get(clazz, id)

		}
	}

	public void getEmployees() {

		Session session = DBConnection.getConnection();
		if (session != null) {

			Transaction tr = session.beginTransaction();
			EmployeeBean employeeBean = (EmployeeBean)session.get(EmployeeBean.class, new Integer(4));
			System.out.println(employeeBean.geteName());
			System.out.println(employeeBean.geteEmail());
			System.out.println(employeeBean.geteId());
			System.out.println(employeeBean.getAge());
			
			tr.commit();

		}
	}

	public void deleteEmployee() {

		Session session = DBConnection.getConnection();
		if (session != null) {

			Transaction tr = session.beginTransaction();
			// EmployeeBean emp = session.get(clazz, id)
			EmployeeBean employeeBean = new EmployeeBean();
			// delete from employee where eId = 3
			employeeBean.seteId(3);
			session.delete(employeeBean);
			System.out.println("record delted...");
			tr.commit();
			session.close();

		}

	}

	public static void main(String[] args) {

		EmployeeController employeeController = new EmployeeController();
		//employeeController.addEmployee();
		// employeeController.deleteEmployee();
		employeeController.getEmployees();

	}
}
