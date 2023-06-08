package com.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception {
//		Employee e1 = new Employee("Tony", "Stark", "Male", "NewYork", "tony@gmail.com", 9874563211l, "Marketing", 47000l);
//		Employee e2 = new Employee("Ram", "Pothineni", "Male", "Hydrabad", "ram@gmail.com", 9852361477l, "Sales", 45000l);
//		
//		List<Employee> list = List.of(e1, e2);
//		
//		employeeRepository.saveAll(list);
	}

}
