package com.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.bean.AccountBean;
import com.bean.UserBean;
import com.util.DBConnection;

public class Account_UserController {

	public void addData() {

		Session session = DBConnection.getConnection();
		if (session != null) {

			Transaction tr = session.beginTransaction();
			AccountBean accountBean = new AccountBean();
			accountBean.setaName("prime");
			session.save(accountBean);

			UserBean userBean = new UserBean();
			userBean.setuName("parth");
			userBean.setuAge(26);
			userBean.setAccountBean(accountBean);
			session.save(userBean);
			tr.commit();

		}

	}

	public void addUserToAccount() {

		Session session = DBConnection.getConnection();
		if (session != null) {

			Transaction tr = session.beginTransaction();

			// need to add user into existing account..
			// first fetch existing account...
			AccountBean accountBean = (AccountBean) session.load(AccountBean.class, 1);
			UserBean userBean = new UserBean();
			userBean.setuName("jay");
			userBean.setuAge(45);
			userBean.setAccountBean(accountBean);
			session.save(userBean);
			tr.commit();

		}

	}

	public void getAllData() {

		Session session = DBConnection.getConnection();
		if (session != null) {

			// begine transaction
			Transaction tr = session.beginTransaction();

			// create an object of Criteria....

			Criteria criteria = session.createCriteria(UserBean.class);
			// add restricatons
			// criteria.add(Restrictions.eq("uId",1));
			List<UserBean> users = criteria.list();
			for (UserBean u : users) {

				System.out.print(" " + u.getuName());
				System.out.print(" " + u.getuAge());
				// join using hibernate
				System.out.print(" " + u.getAccountBean().getaName());
				System.out.println(" " + u.getAccountBean().getaId());

			}

		}

	}

	public void deleteUserFromAccount() {

		Session session = DBConnection.getConnection();
		if (session != null) {

			Transaction tr = session.beginTransaction();
			UserBean userBean = new UserBean();
			userBean.setuId(2);
			session.delete(UserBean.class);
			tr.commit();
			session.close();
		}
	}

	public void updateUser() {
		
		Session session = DBConnection.getConnection();
		if(session!=null) {
			Transaction tr = session.beginTransaction();
			UserBean userBean = (UserBean) session.load(UserBean.class, 2);
			userBean.setuName("priya");
			userBean.setuAge(29);
			session.saveOrUpdate(userBean);
			tr.commit();
			session.close();
		}
		
		
	}

	public static void main(String[] args) {

		Account_UserController obj = new Account_UserController();
		// obj.addData();
		// obj.getAllData();
		//obj.deleteUserFromAccount();
		obj.updateUser();
		// obj.addUserToAccount();

	}
}
