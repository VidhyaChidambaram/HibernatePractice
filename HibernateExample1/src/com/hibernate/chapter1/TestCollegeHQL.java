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
		//Query query = session.createQuery("from College where collegeName like :collegeName");
		//query.setString("collegeName", "%"+"Col"+"%");
		//query.setMaxResults(10);
		
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("College.byId");
		query.setString("collegeName", "Coll4");
		
		Query nativeQuery = session.getNamedQuery("College.byName");
		
		
		@SuppressWarnings("unchecked")
		List<College> nativeList = (List<College>) nativeQuery.list();
		@SuppressWarnings("unchecked")
		List<College> list = (List<College>)query.list();
		session.getTransaction().commit();
		session.close();
		
		for(College collegeId : list) {
			System.out.println("CollegeId is"+ collegeId.getCollegeId());
		}
		
		for(College collegeName : nativeList) {
			System.out.println("College name is"+ collegeName.getCollegeName());
		}
		
	}

}
