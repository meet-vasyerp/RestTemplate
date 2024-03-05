package com.vasy.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vasy.springboot.model.Employee;
import com.vasy.springboot.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/Employee")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return ResponseEntity.ok(employeeService.getAllData());
	}
	
	@PostMapping("/Employee")
	public String addEmployee(@RequestBody Employee employee) {
		employeeService.addNewEmp(employee);
		return "Success!";
	}
	
	@GetMapping("/Employee/{empId}")
	public Employee getEmployeeById(@PathVariable long empId) {
		return employeeService.getEmployeeById(empId);
	}
	
	@DeleteMapping("/Employee/{empId}")
	public Employee deleteEmployeeById(@PathVariable long empId) {
		Employee employee=employeeService.getEmployeeById(empId);
		employeeService.deleteEmployeeById(empId);
		return employee;
	}
	
	@PutMapping("/Employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		Employee emp = employeeService.addNewEmp(employee);
		return emp;
	}
	
}
