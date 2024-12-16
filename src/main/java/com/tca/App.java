package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args)

	{

		Student student = new Student();
		student.setName("pinki");
		student.setEmail("pinki@gmail.com");
		student.setPassword("pinki123");
		Configuration cfg = new Configuration();
		cfg.configure("com/tca/config/Hibernate.config.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.save(student);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		
	}
}
