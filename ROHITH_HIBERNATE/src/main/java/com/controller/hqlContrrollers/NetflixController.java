package com.controller.hqlContrrollers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.HqlBeans.NetflixBean;
import com.util.DBConnection;

public class NetflixController {

	public void addAccount() {

		Session session = DBConnection.getConnection();
		if (session != null) {

			// begin transaction
			Transaction tr = session.beginTransaction();
			NetflixBean n = new NetflixBean();
			n.setUserName("raj");
			n.setUserAge(20);
			session.save(n);

			tr.commit();
		}

	}

	public void deleteAccount() {

		Session session = DBConnection.getConnection();
		if (session != null) {

			Transaction tr = session.beginTransaction();

			Query query = session.createQuery("DELETE FROM NetflixBean where userName=:name");
			// query.setString("name", "raj");
			// query.setString(0, "raj");

			int res = query.executeUpdate();
			if (res > 0) {
				System.out.println("record deleted");
			} else {
				System.out.println("record not deleted..");
			}

			tr.commit();
		}

	}

	public void updateAccount() {

		Session session = DBConnection.getConnection();
		if (session != null) {

			Transaction tr = session.beginTransaction();
			Query query = session.createQuery("UPDATE NetflixBean set userAge=:age,userName=:name where id =:id");
			query.setInteger("age", 25);
			query.setString("name", "jay");
			query.setInteger("id", 5);

			int res = query.executeUpdate();
			if (res > 0) {
				System.out.println("record updated !!");
			} else {
				System.out.println("record not updated !!");
			}
			tr.commit();
			session.close();
		}
	}

	public void getAllRecords() {

		Session session = DBConnection.getConnection();
		if (session != null) {

			Transaction tr = session.beginTransaction();
			Query query = session.createQuery("FROM NetflixBean where id >=4");
			//query.setString("name", "raj");
			List<NetflixBean> list = query.list();
			for (NetflixBean n : list) {
				System.out.println("Id " + n.getId());
				System.out.println("User Name " + n.getUserName());
				System.out.println("User Age " + n.getUserAge());
			}

			tr.commit();
			session.close();
			
		}
	}

	public static void main(String[] args) {

		NetflixController n = new NetflixController();
		 //n.addAccount();
		// n.deleteAccount();
		//n.updateAccount();
		n.getAllRecords();
	}
}
