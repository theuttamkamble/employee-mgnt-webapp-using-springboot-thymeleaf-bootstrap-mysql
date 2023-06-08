package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployeess();
	Employee saveEmployee(Employee employee);
	
	Employee getEmployeeById(Long id);
	Employee updateEmployee(Employee employee);
	
	void deleteEmployee(Long id);
}
