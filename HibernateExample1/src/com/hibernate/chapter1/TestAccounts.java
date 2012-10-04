package com.hibernate.chapter1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestAccounts {

	public static void main(String [] args) {
		
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Accounts.class);
		configuration.configure("hibernate.cfg.xml");
		new SchemaExport(configuration).create(true, true);
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		{
			CompoundKey compoundKey = new CompoundKey(1001, 2001);
			Accounts accounts = new Accounts();
			accounts.setCompoundKey(compoundKey);
			accounts.setAccountName("Vidhya");
			
			session.save(accounts);
		}
		session.getTransaction().commit();
	}
}
