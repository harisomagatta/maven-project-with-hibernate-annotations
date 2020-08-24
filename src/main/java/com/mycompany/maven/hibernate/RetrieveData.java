/**
 * 
 */
package com.mycompany.maven.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author Hari Somagatta
 *
 */
@SuppressWarnings("deprecation")
public class RetrieveData {

	/**
	 * @param args
	 */
	private static SessionFactory factory;
	
	Transaction tx = null;
	Integer employeeID = null;
	Session session = null;
	HibernateSessionsManagement hsm = new HibernateSessionsManagement();

	/* Method to READ all the employees */
	public void listEmployees() {
		
		Transaction tx = null;

		try {
			session = hsm.getHibernateSession();
			tx = session.beginTransaction();
			List<Employee> employees =session.createQuery("FROM Employee").list();
			for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();
				System.out.print("First Name: " + employee.getFirstName());
				System.out.print("  Last Name: " + employee.getLastName());
				System.out.println("  Salary: " + employee.getSalary());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}


//	@SuppressWarnings("unchecked")
//
//	private void displayEmployeesWithDeptName(String deptName) {
//		// Read all employees which belong to Marketing department
//		String hql = "FROM Employee where department.deptName like :dept_name";		
//		Session session = null;
//		try {
//			session = hsm.getHibernateSession();
//
//			Query query = session.createQuery(hql);
//			query.setParameter("dept_name", deptName);
//			System.out.println(query.toString());
//
//			List<Employee> employees = query.list();
//			
//			System.out.println(" List of Employees from Marketing Department are : ");
//			
//			for (int i = 0; i < employees.size(); i++) {
//				Employee e = employees.get(i);
//				System.out.println(e.getFirstName() + " " + e.getMiddleName() + " " + e.getLastName() + " belongs to "
//						+ e.getDepartment().getDeptName());
//
//			}
//		} catch (HibernateException e) {
//			e.printStackTrace();
//		}finally {
//			if(session != null) {
//				session.close();
//			}
//		}
//	}

	@SuppressWarnings({ "unchecked", "unused" })
	private List<Employee> fetchEmployeesWithName(String firstName, String lastName) {
		// Read all employees which belong to Marketing department
		String hql = "FROM Employee where firstName like :firstName  and lastName like :lastName";
		List<Employee> listResult = null;		
		Session session = null;
		session = factory.openSession();

		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);
		query.setParameter("firstName", firstName);
		query.setParameter("lastName", lastName);
		System.out.println(query.toString());

		listResult = query.list();

		return listResult;
	}

}
