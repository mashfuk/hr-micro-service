package com.example.hrservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrservice.model.Employee;
import com.example.hrservice.model.EmployeesList;

@RestController
@RequestMapping("/hr")
public class HrResource {
	
	//Hardcoded list of employees
	List<Employee> employees = Arrays.asList(
		new Employee("E1", "Kindson", "Munonye", "MedTech"),
		new Employee("E2", "Kate", "Winters", "Surgery")
	);
	
	//getEmployees returns list of employees
	@RequestMapping("/employees")
	public EmployeesList getEmployees() {
		
		EmployeesList employeesList = new EmployeesList();
		employeesList.setEmployees(employees);		
		return employeesList;
	}
	
	//getEmployeeById returns an employee with the given Id
	@RequestMapping("/employees/{Id}")
	public Employee getEmployeeById(@PathVariable("Id") String Id) {
		Employee e = employees.stream()
				.filter(employee ->Id.equals(employee.getId()))
				.findAny()
				.orElse(null);
		return e;
	}		
}