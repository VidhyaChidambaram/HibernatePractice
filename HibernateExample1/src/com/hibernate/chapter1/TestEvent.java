package com.hibernate.chapter1;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class TestEvent {

	public static void main(String [] args) {
		
		Configuration annotationConfig = new Configuration();
		annotationConfig.addAnnotatedClass(Delegate.class);
		annotationConfig.addAnnotatedClass(Event.class);
		annotationConfig.configure("hibernate.cfg.xml");
		
	//	new SchemaExport(annotationConfig).create(true, true);
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(annotationConfig.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = annotationConfig.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		{
			Query testQueryCache = session.createQuery("from Event where eventId>1");
			testQueryCache.setCacheable(true);
			List<Event> eventList = (List<Event>)testQueryCache.list();
		}
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		{
			Query testQueryCache = session.createQuery("from Event where eventId>1");
			testQueryCache.setCacheable(true);
			List<Event> eventList = (List<Event>)testQueryCache.list();
		}
		session.getTransaction().commit();
		session.close();
		
	}
}
