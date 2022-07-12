package com.luv2code.springboot.crud.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.crud.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
}
