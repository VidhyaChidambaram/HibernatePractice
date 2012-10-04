package com.hibernate.chapter1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestSchool {

	public static void main(String [] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(School.class);
		configuration.addAnnotatedClass(SchoolDetail.class);
		new SchemaExport(configuration).create(true, true);
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		{
			School mySchool = new School();
			mySchool.setSchoolName("Narayana Mission");
			
			SchoolDetail publicSchoolDetail = new SchoolDetail();
			publicSchoolDetail.setPublicSchool(true);
			publicSchoolDetail.setSchoolAddress("T.Nagar");
			publicSchoolDetail.setSchoolYear("1956");
			publicSchoolDetail.setStudentCount("5000");
			
			SchoolDetail privateSchoolDetail = new SchoolDetail();
			privateSchoolDetail.setPublicSchool(false);
			privateSchoolDetail.setSchoolAddress("Mandeveli");
			privateSchoolDetail.setSchoolYear("1926");
			privateSchoolDetail.setStudentCount("3000");
			
			mySchool.setPublicSchoolDetail(publicSchoolDetail);
			mySchool.setPrivateSchoolDetail(privateSchoolDetail);
			session.save(mySchool);
			session.getTransaction().commit();
			
		}
	
	}
}
