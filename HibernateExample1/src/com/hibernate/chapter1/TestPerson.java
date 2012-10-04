package com.hibernate.chapter1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestPerson {

	public static void main(String [] args) {
		Configuration annotationConfig = new Configuration();
		annotationConfig.addAnnotatedClass(Person.class);
		annotationConfig.addAnnotatedClass(PersonDetail.class);
		annotationConfig.configure("hibernate.cfg.xml");
		
		new SchemaExport(annotationConfig).create(true, true);
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(annotationConfig.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = annotationConfig.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		{
			
			PersonDetail personDetail = new PersonDetail();
			personDetail.setIncome("1000");
			personDetail.setJob("engineer");
			personDetail.setZipCode("23294");
			
			Person person = new Person();
			person.setPersonName("Person1");
			person.setPersonDetail(personDetail);
			
			session.save(person);
			// no need to save person detail since cascade type is set
		}
		
		session.getTransaction().commit();
		
	}
}
