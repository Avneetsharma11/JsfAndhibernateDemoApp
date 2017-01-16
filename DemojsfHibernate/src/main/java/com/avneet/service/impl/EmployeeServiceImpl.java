package com.avneet.service.impl;
import com.avneet.dao.EmployeeDAO;
import com.avneet.entity.Employee;
import com.avneet.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //@Component
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	public EmployeeServiceImpl() {
		System.out.println("EmployeeServiceImpl(object is crteaed )");
	}
	
	@Autowired
     EmployeeDAO employeeDAO;

    /*public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    	System.out.println("EmployeeDAO"+employeeDAO);
		this.employeeDAO = employeeDAO;
	}*/

	public long createEmployee(Employee employee) {
        return employeeDAO.createEmployee(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }

    public void deleteEmployee(long id) {
        employeeDAO.deleteEmployee(id);
    }
 
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
 
    public Employee getEmployee(long id) {
        return employeeDAO.getEmployee(id);
    }    
   
    public List<Employee> getAllEmployees(String employeeName) {
    	return employeeDAO.getAllEmployees(employeeName);
    }
}
