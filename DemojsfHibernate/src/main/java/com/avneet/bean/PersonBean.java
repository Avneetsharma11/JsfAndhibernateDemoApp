package com.avneet.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.avneet.service.EmployeeService;

@ManagedBean(name="personBean")
@RequestScoped
public class PersonBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	 EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
		System.out.println("employeeService"+employeeService);
	}
	
	 
	 
	 
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
public String hello(){
	System.out.println(employeeService.getAllEmployees());
	return "welcome";
}
}
