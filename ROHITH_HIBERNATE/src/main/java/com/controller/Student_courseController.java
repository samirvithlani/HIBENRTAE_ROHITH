package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
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
			c1.setcName("Maths");
			c1.setcFees(50000);
			session.save(c1);
			Courses c2 = new Courses();
			c2.setcName("English");
			c2.setcFees(15450);
			session.save(c2);
			Courses c3 = new Courses();
			c3.setcName("Science");
			c3.setcFees(15450);
			session.save(c3);
			Courses c4 = new Courses();
			c4.setcName("Bio");
			c4.setcFees(15450);
			session.save(c4);
			List<Courses> courses = new ArrayList<Courses>();

			courses.add(c1);
			courses.add(c2);
			courses.add(c3);
			courses.add(c4);

			Student student = new Student();
			student.setsName("Jay");
			student.setCourses(courses);
			session.save(student);
			tr.commit();

			session.close();

		}
	}

	public void displayData() {

		Session session = DBConnection.getConnection();
		if (session != null) {

			Transaction tr = session.beginTransaction();
			Criteria criteria = session.createCriteria(Student.class);
			List<Student> students = criteria.list();
			for (Student s : students) {

				System.out.print("  Student id =" + s.getsId());
				System.out.print("  Student Name =" + s.getsName());

				for (Courses c : s.getCourses()) {

					System.out.println();
					System.out.print("  course id =" + c.getcId());
					System.out.print("  course Name =" + c.getcName());
					System.out.println("  course Fees =" + c.getcFees());
					System.out.println();
				}
				System.out.println();

			}
			tr.commit();

		}

	}

	public static void main(String[] args) {

		Student_courseController s1 = new Student_courseController();
		// s1.addData();
		s1.displayData();
	}
}
