package com.hibernate.chapter1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestCustomer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Customer.class);
		
		new SchemaExport(configuration).create(true, true);
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		{
			Customer alex = new Customer();
			alex.setCreditScore(1);
			alex.setCustomerAddress("Chennai");
			alex.setCustomerName("Alex");
			alex.setRewardPoints(100);
			session.save(alex);
		}
		{
			Customer barb = new Customer();
			barb.setCreditScore(5);
			barb.setCustomerAddress("Blore");
			barb.setCustomerName("Barb");
			barb.setRewardPoints(500);
			session.save(barb);
		}
		{
			Customer cindy = new Customer();
			cindy.setCreditScore(8);
			cindy.setCustomerAddress("Mumbai");
			cindy.setCustomerName("cindy");
			cindy.setRewardPoints(700);
			session.save(cindy);	
		}
		session.getTransaction().commit();
	}
}
