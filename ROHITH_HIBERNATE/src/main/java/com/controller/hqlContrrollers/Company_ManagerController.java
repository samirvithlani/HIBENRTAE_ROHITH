package com.controller.hqlContrrollers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.HqlBeans.Company;
import com.bean.HqlBeans.Manager;
import com.util.DBConnection;

public class Company_ManagerController {

	public void addData() {

		Session session = DBConnection.getConnection();
		if (session != null) {

			Transaction tr = session.beginTransaction();
			Manager m = new Manager();
			m.setName("Amit");
			m.setAge(15);

			Company c = new Company();
			c.setName("tcs");
			c.setManager(m);

			session.save(c);
			tr.commit();
			session.close();
			System.out.println("Data added !!");

		}

	}
	
	public void getAllData_innerJoin() {
		
		Session session = DBConnection.getConnection();
		if(session!=null) {
			
			Transaction tr = session.beginTransaction();
			Query query = session.createQuery("From Company");
			List<Company> list = query.list();
			for(Company m : list) {
				System.out.println("Company id  = "+m.getId());
				System.out.println("Company Name = "+m.getName());
				System.out.println("Manager Name = "+m.getManager().getName());
				System.out.println("Manager Age = "+m.getManager().getAge());
				
			}
			tr.commit();
			session.close();
		}
		
	}

	public static void main(String[] args) {

		Company_ManagerController obj = new Company_ManagerController();
		//obj.addData();
		obj.getAllData_innerJoin();
	}
}
