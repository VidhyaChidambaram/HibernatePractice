package com.hibernate.chapter1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestProject {

	public static void main(String [] args) {
		
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Project.class);
		configuration.addAnnotatedClass(Module.class);
		configuration.addAnnotatedClass(Task.class);
		
		configuration.configure("hibernate.cfg.xml");
		
		new SchemaExport(configuration).create(true, true);
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		{
			Project smallProject = new Project();
			smallProject.setProjectId(1);
			smallProject.setProjectName("Sample Project");
			
			Module subModule = new Module();
			subModule.setModuleId(2);
			subModule.setModuleName("Module Name");
			
			Task task = new Task();
			task.setTaskId(3);
			task.setTaskName("Sub task name");
			
			session.save(smallProject);
			session.save(subModule);
			session.save(task);
			
		}
		session.getTransaction().commit();
		
	}
}
