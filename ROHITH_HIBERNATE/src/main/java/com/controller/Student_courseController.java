package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.Courses;
import com.bean.Student;
import com.util.DBConnection;

public class Student_courseController {

	public void addData() {

		Session session = DBConnection.getConnection();
		if (session != null) {

			Transaction tr = session.beginTransaction();
			Courses c1 = new Courses();
			c1.setcName("java");
			c1.setcFees(15000);
			session.save(c1);
			Courses c2 = new Courses();
			c2.setcName("python");
			c2.setcFees(12000);
			session.save(c2);
			List<Courses> courses = new ArrayList<Courses>();

			courses.add(c1);
			courses.add(c2);

			Student student = new Student();
			student.setsName("parth");
			student.setCourses(courses);
			session.save(student);
			tr.commit();

			session.close();

		}
	}

	public static void main(String[] args) {

		Student_courseController s1 = new Student_courseController();
		s1.addData();
	}
}
