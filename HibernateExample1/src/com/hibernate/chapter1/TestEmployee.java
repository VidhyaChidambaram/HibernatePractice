package com.hibernate.chapter1;

import java.sql.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestEmployee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Employee.class);
		configuration.configure("hibernate.cfg.xml");

		new SchemaExport(configuration).create(true, true);
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		{
		Employee alex = new Employee();
		//alex.setEmployeeId("420");
		alex.setEmployeeName("Chandramouli");
		alex.setEmployeeEmail("mouli.venku@gmail.com");
		alex.setEmployeePassword("1234");
		alex.setEmployeeJoinDate(new GregorianCalendar(2009, 10, 01));
		alex.setEmployeeLoginTime(Date.valueOf("2009-10-01"));
		
		session.save(alex);
		}
		{
		Employee vidhya= new Employee();
		vidhya.setEmployeeName("Vidhya");
		vidhya.setEmployeeEmail("vidh.rupa@gmail.com");
		vidhya.setEmployeePassword("1234");
		vidhya.setEmployeeJoinDate(new GregorianCalendar(2009, 10, 02));
		vidhya.setEmployeeLoginTime(Date.valueOf("2009-10-02"));
		
		session.save(vidhya);
		}
		{
		Employee srinath = new Employee();
		
		srinath.setEmployeeName("Srinath");
		srinath.setEmployeeEmail("srinath@gmail.com");
		srinath.setEmployeePassword("1234");
		srinath.setEmployeeJoinDate(new GregorianCalendar(2009, 10, 03));
		srinath.setEmployeeLoginTime(Date.valueOf("2009-10-03"));
		
		session.save(srinath);
		}
		{
		Employee surya = new Employee();
		surya.setEmployeeName("Surya");
		surya.setEmployeeEmail("surya@gmail.com");
		surya.setEmployeePassword("1234");
		surya.setEmployeeJoinDate(new GregorianCalendar(2009, 10, 04));
		surya.setEmployeeLoginTime(Date.valueOf("2009-10-04"));
		session.save(surya);
		}
		{
		Employee sujatha = new Employee();
		sujatha.setEmployeeName("Sujatha");
		sujatha.setEmployeeEmail("suju@gmail.com");
		sujatha.setEmployeePassword("1234");
		sujatha.setEmployeeJoinDate(new GregorianCalendar(2009, 10, 05));
		sujatha.setEmployeeLoginTime(Date.valueOf("2009-10-05"));
		session.save(sujatha);
		}
		{
		Employee radha = new Employee();
		radha.setEmployeeName("Radha");
		radha.setEmployeeEmail("mouli.venku@gmail.com");
		radha.setEmployeePassword("1234");
		radha.setEmployeeJoinDate(new GregorianCalendar(2009, 10, 06));
		radha.setEmployeeLoginTime(Date.valueOf("2009-10-06"));
		session.save(radha);
		}
		{
		Employee gayathri = new Employee();
		gayathri.setEmployeeName("Gayathri");
		gayathri.setEmployeeEmail("gayathri@gmail.com");
		gayathri.setEmployeePassword("1234");
		gayathri.setEmployeeJoinDate(new GregorianCalendar(2009, 10, 07));
		gayathri.setEmployeeLoginTime(Date.valueOf("2009-10-08"));
		session.save(gayathri);
		}
		session.getTransaction().commit();
		
	}

}
