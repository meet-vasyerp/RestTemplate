package com.vasy.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vasy.springboot.model.Employee;
import com.vasy.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public List<Employee> getAllData() {
		List<Employee> employee = empRepo.findAll();		
		return employee;
	}

	@Override
	public Employee getEmployeeById(long id) {
		return empRepo.findById(id).get();
	}
	
	@Override
	public void deleteEmployeeById(long id) {
		empRepo.deleteById(id);
		
	}
	
	@Override
	public Employee addNewEmp(Employee employee) {
		return empRepo.save(employee);
	}
}
