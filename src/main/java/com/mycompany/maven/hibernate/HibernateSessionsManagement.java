/**
 * 
 */
package com.mycompany.maven.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author Hari Somagatta
 *
 */
public class HibernateSessionsManagement {


	public Session getHibernateSession() {

		Session session = null;

		try {

			Configuration config = new Configuration();
			config.configure();
			config.addAnnotatedClass(Employee.class);

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			SessionFactory factory = config.buildSessionFactory(serviceRegistry);
			session = factory.openSession();
		} catch (Exception ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		return session;
	}

	public void closeHibernateSession(Session session) {
		if(session !=null) {
			session.close();
		}
		
	}
	
	public void closeHibernateSessionFactory(SessionFactory factory) {
		if(factory !=null) {
			factory.close();
		}
		
	}

}
