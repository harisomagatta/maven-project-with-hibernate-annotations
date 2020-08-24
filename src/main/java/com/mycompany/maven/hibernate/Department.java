package com.mycompany.maven.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "DEPARTMENT")
public class Department {
	
	 @Column(name = "id")
	private Long id;
	 
	 @Column(name = "deptname")
	private String deptName;
	

	public Department() {
		
	}

	public Department(Long id, String deptName) {
		super();
		this.id = id;
		this.deptName = deptName;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName  + "]";
	}
	
	

}
