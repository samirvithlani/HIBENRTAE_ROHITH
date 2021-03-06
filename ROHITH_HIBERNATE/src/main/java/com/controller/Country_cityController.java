package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.City;
import com.bean.Country;
import com.util.DBConnection;

public class Country_cityController {

	public void Add_city_Coutry() {

		Session session = DBConnection.getConnection();
		if (session != null) {

			Transaction tr = session.beginTransaction();

			Country country = new Country();
			country.setCountryName("India");

			City ci1 = new City();
			ci1.setCityName("Ahmedabad");

			City ci2 = new City();
			ci2.setCityName("Mumbai");

			City ci3 = new City();
			ci3.setCityName("Pune");

			List<City> cities1 = new ArrayList<City>();
			cities1.add(ci1);
			cities1.add(ci2);
			cities1.add(ci3);

			country.setCities(cities1);
			session.save(country);
			tr.commit();
			session.close();
			System.out.println("record stored...");

		}

	}

	public static void main(String[] args) {

		Country_cityController obj = new Country_cityController();
		obj.Add_city_Coutry();
	}
}
