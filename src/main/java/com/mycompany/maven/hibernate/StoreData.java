package com.mycompany.maven.hibernate;

import java.math.BigDecimal;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StoreData {

	/* Method to CREATE an employee in the database */
	public Integer addEmployee(String fname, String lname, String mname, BigDecimal salary, int deptId) {

		Transaction tx = null;
		Integer employeeID = null;
		Session session = null;
		HibernateSessionsManagement hsm = new HibernateSessionsManagement();
		try {

			session = hsm.getHibernateSession();
			tx = session.beginTransaction();
			// One way of doing it
			/*
			 * Employee employee = new Employee(); 
			 * employee.setFirstName(fname);
			 * employee.setLastName(lname); 
			 * employee.setSalary(salary);
			 * employee.setMiddleName(mname); 
			 * employee.setDeptId(deptId);
			 */

			// Other way of doing it
			Employee employee = new Employee(fname, lname, mname, salary, deptId);
			employeeID = (Integer) session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			// session.close();
			hsm.closeHibernateSession(session);
		}
		return employeeID;
	}

	//overloading
	public Integer addEmployee(Employee employee) {

		Transaction tx = null;
		Integer employeeID = null;
		Session session = null;
		HibernateSessionsManagement hsm = new HibernateSessionsManagement();
		try {
			session = hsm.getHibernateSession();
			tx = session.beginTransaction();
			employeeID = (Integer) session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			hsm.closeHibernateSession(session);
		}
		return employeeID;
	}

}
