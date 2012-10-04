package com.hibernate.chapter1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestUser {

	public static void main(String [] args) {
		
		Configuration annotConfig = new Configuration();
		annotConfig.configure("hibernate.cfg.xml");
		annotConfig.addAnnotatedClass(User.class);
		//annotConfig.addAnnotatedClass(Address.class);
		
		new SchemaExport(annotConfig).create(true, true);
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(annotConfig.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = annotConfig.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		{
		User newUser = new User();
		newUser.setUserName("Vidhya");
		
		Address address1 = new Address();
		address1.setApartmentName("LT EDEN park");
		address1.setStreetName("siruseri");
		address1.setStreetNumber("101");
		
		Address address2 = new Address();
		address2.setApartmentName("KP Koil");
		address2.setStreetName("My home");
		address2.setStreetNumber("202");
		
		newUser.getListOfAddress().add(address1);
		newUser.getListOfAddress().add(address2);
		
		session.save(newUser);
		session.getTransaction().commit();
		
		session.close();
	}
	}
}
