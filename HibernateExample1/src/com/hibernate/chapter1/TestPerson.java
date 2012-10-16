package com.hibernate.chapter1;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class TestPerson {

	public static void main(String [] args) {
		Configuration annotationConfig = new Configuration();
		annotationConfig.addAnnotatedClass(Person.class);
		annotationConfig.addAnnotatedClass(PersonDetail.class);
		annotationConfig.configure("hibernate.cfg.xml");
		
	//	new SchemaExport(annotationConfig).create(true, true);
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(annotationConfig.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = annotationConfig.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		{
			Person person1 = (Person)session.get(Person.class, 1);
			
			Person person2 = (Person)session.get(Person.class, 1);
		}
		
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		{
			Person person1 = (Person)session.get(Person.class, 1);
			
			Person person2 = (Person)session.get(Person.class, 1);
		}
		
		session.getTransaction().commit();
		session.close();
		
	}
}
