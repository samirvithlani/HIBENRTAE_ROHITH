package com.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

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
			employeeBean.seteName("rima");
			employeeBean.seteEmail("rima@gmail.com");
			employeeBean.setAge(25);

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
			EmployeeBean employeeBean = (EmployeeBean) session.load(EmployeeBean.class, 5);
			// select * from employee where eId = 5;
			employeeBean.seteName("jaya");
			employeeBean.seteEmail("jaya@gmail.com");
			// update employee set eName = "" ,set eemail ="" where eId = 5;
			session.saveOrUpdate(employeeBean);
			tr.commit();
			session.close();

		}
	}
	
	public void getAllEmployees() {
		
		Session session = DBConnection.getConnection();
		if(session!=null) {
			
			Transaction tr = session.beginTransaction();
			//ResultSet ==Criteria
			Criteria criteria = session.createCriteria(EmployeeBean.class);
			//criteria.add(Restrictions.like("eName", "r",MatchMode.END));
			//criteria.add(Restrictions.between("age", 18, 25));
			//criteria.add(Restrictions.eq("age", 25));
			//criteria.add(Restrictions.eqProperty("eName", "eEmail"));
			//select * from employee;
			List<EmployeeBean> employees = criteria.list();
			
			for(EmployeeBean emp:employees) {
				
				System.out.print(" "+emp.geteId());
				System.out.print(" "+emp.geteName());
				System.out.print(" "+emp.getAge());
				System.out.print(" "+emp.geteEmail());
				System.out.println();
			}
		
			tr.commit();
			session.close();
		}
		
		
		
	}

	public void getEmployees() {

		Session session = DBConnection.getConnection();
		if (session != null) {

			Transaction tr = session.beginTransaction();
			EmployeeBean employeeBean = (EmployeeBean) session.get(EmployeeBean.class, new Integer(4));
			System.out.println();
			System.out.println(" "+employeeBean.geteName());
			System.out.println(" "+employeeBean.geteEmail());
			System.out.println(" "+employeeBean.geteId());
			System.out.println(" "+employeeBean.getAge());
			System.out.println();

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
		// employeeController.getEmployees();
		//employeeController.updateEmployee();
		employeeController.getAllEmployees();

	}
}
