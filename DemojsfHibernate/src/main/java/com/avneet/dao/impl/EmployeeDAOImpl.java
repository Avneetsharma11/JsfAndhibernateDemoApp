/**
 * 
 */
package com.avneet.dao.impl;

import com.avneet.dao.EmployeeDAO;
import com.avneet.entity.Employee;
import com.avneet.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;



@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    
	public EmployeeDAOImpl() {
    	System.out.println("EmployeeDAOImpl object is cretaed");
    }
	
	@Autowired
    private HibernateUtil hibernateUtil;

    public long createEmployee(Employee employee) {        
        return (Long) hibernateUtil.create(employee);
    }
    
  
    public Employee updateEmployee(Employee employee) {        
        return hibernateUtil.update(employee);
    }
    
   
    public void deleteEmployee(long id) {
        Employee employee = new Employee();
        employee.setId(id);
        hibernateUtil.delete(employee);
    }
    
   
    public List<Employee> getAllEmployees() {        
        return hibernateUtil.fetchAll(Employee.class);
    }
    
  
    public Employee getEmployee(long id) {
        return hibernateUtil.fetchById(id, Employee.class);
    }

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees(String employeeName) { 
		String query = "SELECT e.* FROM Employees e WHERE e.name like '%"+ employeeName +"%'";
		List<Object[]> employeeObjects = hibernateUtil.fetchAll(query);
		List<Employee> employees = new ArrayList<Employee>();
		for(Object[] employeeObject: employeeObjects) {
			Employee employee = new Employee();
			long id = ((BigInteger) employeeObject[0]).longValue();			
			int age =  (Integer) employeeObject[1];
			String name =  (String) employeeObject[2];
			float salary =  (Float) employeeObject[3];
			employee.setId(id);
			employee.setName(name);
			employee.setAge(age);
			employee.setSalary(salary);
			employees.add(employee);
		}
		System.out.println(employees);
		return employees;
	}
}