package com.hibernate.chapter1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class TestStudent {

	public static void main(String [] args) {
		
		Configuration annotationConfig = new Configuration();
		annotationConfig.addAnnotatedClass(College.class);
		annotationConfig.addAnnotatedClass(Student.class);
		annotationConfig.configure("hibernate.cfg.xml");
		
		//new SchemaExport(annotationConfig).create(true, true);
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(annotationConfig.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = annotationConfig.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
			College studentCollege = (College)session.get(College.class, 5);
			session.save(studentCollege);
			studentCollege.setCollegeName("newName5");
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		session.beginTransaction();
	//	session.saveOrUpdate(studentCollege);
	//	studentCollege.setCollegeName("persistedName");
		session.getTransaction().commit();
		session.close();
	}
	
	
}
