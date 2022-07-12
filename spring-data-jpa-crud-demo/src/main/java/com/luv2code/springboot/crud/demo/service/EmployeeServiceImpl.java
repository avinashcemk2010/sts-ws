package com.luv2code.springboot.crud.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.crud.demo.dao.EmployeeRepository;
import com.luv2code.springboot.crud.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		Employee emp = null;
		
		if(result.isPresent()) {
			emp = result.get();
		} else {
			throw new RuntimeException("employee is not present");
		}
		
		return emp;
	}

	@Override
	public void save(Employee emp) {
		employeeRepository.save(emp);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

}
