package com.vasy.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vasy.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
