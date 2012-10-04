package com.hibernate.chapter1;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class TestCollegeHQL {

	public static void main(String [] args) {
		
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(College.class);
		configuration.addAnnotatedClass(Student.class);
		
		configuration.configure();
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		// avoid sql injection : What is sql injection hacking? suppose you append queryString at end of query, hacker can modify your query string and extract data.
		// So, use placeholder like ? or :parameterBinding to avoid sql injection hacking
		Query query = session.createQuery("from College where collegeName like :collegeName");
		query.setString("collegeName", "%"+"Col"+"%");
		query.setMaxResults(10);
		
		List<College> list = (List<College>)query.list();
		session.getTransaction().commit();
		session.close();
		
		for(College collegeName : list) {
			System.out.println("User name is"+ collegeName.getCollegeName());
		}
		
	}

}
