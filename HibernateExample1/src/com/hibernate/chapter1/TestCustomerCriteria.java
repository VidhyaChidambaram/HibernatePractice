package com.hibernate.chapter1;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class TestCustomerCriteria {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Customer.class);
		
		//new SchemaExport(configuration).create(true, true);
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		Customer exampleCustomer = new Customer();
		exampleCustomer.setCustomerId(1);
		
		Example example = Example.create(exampleCustomer);
		
		Criteria criteria = session.createCriteria(Customer.class).add(example);
		//criteria.add(Restrictions.gt("customerId", 1)).add(Restrictions.isNotNull("customerName"));
		
	//	criteria.add(Restrictions.or(Restrictions.idEq(2), Restrictions.not(Restrictions.gt("customerId", 1))) );
		
		List<Customer> collectionOfUsers = (List<Customer>)criteria.list();
		
		for(Customer customer : collectionOfUsers) {
			System.out.println(customer.getCustomerName());
		}
		session.getTransaction().commit();
	}
}
