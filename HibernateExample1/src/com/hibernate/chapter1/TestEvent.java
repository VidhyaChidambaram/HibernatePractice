package com.hibernate.chapter1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestEvent {

	public static void main(String [] args) {
		
		Configuration annotationConfig = new Configuration();
		annotationConfig.addAnnotatedClass(Delegate.class);
		annotationConfig.addAnnotatedClass(Event.class);
		annotationConfig.configure("hibernate.cfg.xml");
		
		new SchemaExport(annotationConfig).create(true, true);
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(annotationConfig.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = annotationConfig.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		{
			
			Event event1 = new Event();
			event1.setEventName("Core Java");
			
			
			Event event2 = new Event();
			event2.setEventName("Advanced Java");
			
			Event event3 = new Event();
			event3.setEventName("Struts");
			
			Event event4 = new Event();
			event4.setEventName("Spring");
			
			Event event5 = new Event();
			event5.setEventName("Hibernate");
			
			Delegate delegate1 = new Delegate();
			delegate1.setDelegateName("Alex");
			
			
			Delegate delegate2 = new Delegate();
			delegate2.setDelegateName("Berry");
			
			Delegate delegate3 = new Delegate();
			delegate3.setDelegateName("Cindy");
			
			Delegate delegate4 = new Delegate();
			delegate4.setDelegateName("Dave");
			
			Delegate delegate5 = new Delegate();
			delegate5.setDelegateName("Earl");
			
			event1.getDelegates().add(delegate1);
			event1.getDelegates().add(delegate2);
			
			event2.getDelegates().add(delegate2);
			event2.getDelegates().add(delegate3);
			
			event3.getDelegates().add(delegate3);
			event3.getDelegates().add(delegate4);
			
			event4.getDelegates().add(delegate4);
			event4.getDelegates().add(delegate5);
			
			event5.getDelegates().add(delegate5);
			event5.getDelegates().add(delegate1);
			
			delegate1.getEvents().add(event5);
			
			session.save(event1);
			session.save(event2);
			session.save(event3);
			session.save(event4);
			session.save(event5);
			
			session.save(delegate1);
			session.save(delegate2);
			session.save(delegate3);
			session.save(delegate4);
			session.save(delegate5);
		}
		session.getTransaction().commit();
		
	}
}
