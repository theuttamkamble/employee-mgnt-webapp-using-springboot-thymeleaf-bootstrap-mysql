package com.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@Controller
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
	@GetMapping({"/employees", "list-employees"})
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployeess());
		return "views/list_employees";
	}
	
	@GetMapping("/add")
	public String createEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "views/create_employee";
	}
	
	@PostMapping("/processform")
	public String createEmployeeForm(@ModelAttribute Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	
	@GetMapping("/employee/update/{id}")
	public String editEmployeeForm(@PathVariable Long id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "views/update_employee";
	}
	
	@PostMapping("/updateform/{id}")
	public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee employee, Model model) {
		Employee existingEmployee = employeeService.getEmployeeById(id);
		existingEmployee.setId(id);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setGender(employee.getGender());
		existingEmployee.setCity(employee.getCity());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setMobile(employee.getMobile());
		existingEmployee.setDepartment(employee.getDepartment());
		existingEmployee.setSalary(employee.getSalary());
		
		employeeService.updateEmployee(existingEmployee);
		System.out.println(existingEmployee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employee/delete/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		
		return "redirect:/employees";
	}
	
}
