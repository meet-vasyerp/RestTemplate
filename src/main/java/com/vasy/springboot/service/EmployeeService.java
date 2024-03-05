package com.vasy.springboot.service;

import java.util.List;

import com.vasy.springboot.model.Employee;


public interface EmployeeService {

	List<Employee> getAllData();
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
	Employee addNewEmp(Employee employee);
}
