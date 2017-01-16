package com.avneet.controller;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.avneet.entity.Employee;
import com.avneet.service.EmployeeService;

@ManagedBean(name = "employeeController")
@RequestScoped
/*@Controller*/
public class EmployeeController {
	
	private static final Logger logger = Logger.getLogger(EmployeeController.class);
   /* private long id;
    private String name;
    private int age;
    private float salary;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}*/
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmployeeController() {
		System.out.println("EmployeeController()");
	}
	
	  @Autowired
	   EmployeeService employeeService;

	  public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	List<Employee> empList = new ArrayList<Employee>();
	public String hello(){
		 try {
			empList=employeeService.getAllEmployees();
		} catch (Exception e) {
			System.out.println(e);
		}
		 System.out.println(empList);
			return "welcome";
		}

    public String  add(){
		return "index";
	}
}