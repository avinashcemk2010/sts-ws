package com.luv2code.springboot.crud.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.crud.demo.entity.Employee;
import com.luv2code.springboot.crud.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{employeeID}")
	public Employee findEmployeeById(@PathVariable int employeeID) {
		Employee emp = employeeService.findById(employeeID);

		if(emp == null) {
			throw new RuntimeException("Employee id not found");
		}

		return emp;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee emp) {
		emp.setId(0);
		employeeService.save(emp);
		return emp;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee emp) {
		System.out.println(emp.getId());
		employeeService.save(emp);
		System.out.println(emp.getId());
		return emp;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee emp = employeeService.findById(employeeId);
		if(emp == null) {
			throw new RuntimeException("Employee doesn't exist in database");
		}
		
		employeeService.deleteById(employeeId);
		
		return "deleted employee:" + employeeId;
	}

}
