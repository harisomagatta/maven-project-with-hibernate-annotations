/**
 * 
 */
package com.mycompany.maven.hibernate;

import java.math.BigDecimal;

/**
 * @author Hari Somagatta
 *
 */
public class ManageData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//saveEmployee();
		
		RetrieveData retriveData = new RetrieveData();
		retriveData.listEmployees();
		
		storeEmployeeWithElements();
		retriveData.listEmployees();

	}

	//Store Employee by passing Employee object to Store Data
	private static void saveEmployee() {

		// Create employee
		Employee employee = new Employee();
		employee.setFirstName("Save");
		employee.setLastName("Employee");
		employee.setSalary(new BigDecimal(25000));
		employee.setMiddleName("Object");
		employee.setDeptId(3);

		StoreData storedata = new StoreData();
		storedata.addEmployee(employee);

	}
	
	
	
	private static void storeEmployeeWithElements() {

		StoreData storedata = new StoreData();
		storedata.addEmployee("Store","Employee","WithElements",new BigDecimal(25000),2);

	}

}
