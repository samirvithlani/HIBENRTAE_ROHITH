package com.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.AccountBean;
import com.bean.UserBean;
import com.util.DBConnection;

public class Account_UserController {

	public void addData() {

		Session session = DBConnection.getConnection();
		if (session != null) {

			Transaction tr = session.beginTransaction();
			AccountBean accountBean = new AccountBean();
			accountBean.setaName("netflix");
			session.save(accountBean);

			UserBean userBean = new UserBean();
			userBean.setuName("raj");
			userBean.setuAge(25);
			userBean.setAccountBean(accountBean);
			session.save(userBean);
			tr.commit();

		}

	}

	public static void main(String[] args) {

		Account_UserController obj = new Account_UserController();
		obj.addData();

	}
}