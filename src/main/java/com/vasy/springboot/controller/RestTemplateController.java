package com.vasy.springboot.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vasy.springboot.model.Employee;

@RestController
public class RestTemplateController {
	
	private final String URI_EMPLOYEES = "http://localhost:8080/Employee";
	private final String URI_EMPLOYEES_ID = "http://localhost:8080/Employee/";
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/employees")
	public ResponseEntity getAllEmployee() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity < String > entity = new HttpEntity < > (httpHeaders);
        return restTemplate.exchange(URI_EMPLOYEES, HttpMethod.GET, entity, Employee[].class);
	}
	
	@PostMapping("/add-employees")
	public ResponseEntity addEmployee(@RequestBody final Employee employee) {
		HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity < Employee > entity = new HttpEntity < > (employee,httpHeaders);
        return restTemplate.exchange(URI_EMPLOYEES, HttpMethod.POST,entity,String.class);
	}
	
	@GetMapping("/employees/{empId}")
    public ResponseEntity getByIdV2(@PathVariable final long empId) {
		HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity < Employee > entity = new HttpEntity < > (httpHeaders);
        return restTemplate.exchange(URI_EMPLOYEES_ID + empId, HttpMethod.GET, entity, Employee.class);

    }
	
	@DeleteMapping("/employee/{empId}")
    public ResponseEntity deleteV1(@PathVariable final long empId) {
		 HttpHeaders httpHeaders = new HttpHeaders();
	        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	        HttpEntity < Employee > entity = new HttpEntity < > (httpHeaders);
	        return restTemplate.exchange(URI_EMPLOYEES_ID + empId, HttpMethod.DELETE, entity, String.class);
	   }
	
    @PutMapping("/employees")
    public ResponseEntity updateEmployeeV2(@RequestBody Employee newEmployee) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity < Employee > entity = new HttpEntity < > (newEmployee, httpHeaders);
        return restTemplate.exchange(URI_EMPLOYEES ,HttpMethod.PUT, entity, String.class);
    }

}
