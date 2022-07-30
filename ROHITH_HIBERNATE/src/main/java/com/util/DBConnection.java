package com.util;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.MetadataSources;

public class DBConnection {


	public static Session getConnection() {

		return new Configuration().configure().buildSessionFactory().openSession();
	}   
	

	public static void main(String[] args) {

		
		getConnection();
		
	}

}
