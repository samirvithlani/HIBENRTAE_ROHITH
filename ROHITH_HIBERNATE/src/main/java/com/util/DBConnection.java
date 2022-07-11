package com.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class DBConnection {

	public static Session getConnection() {

		return new Configuration().configure
				().buildSessionFactory().openSession();
	}

	public static void main(String[] args) {

		Session session = getConnection();
		if (session != null) {
			System.out.println("connected with database..");
		} else {
			System.out.println("not connected with Database..");
		}
	}

}
