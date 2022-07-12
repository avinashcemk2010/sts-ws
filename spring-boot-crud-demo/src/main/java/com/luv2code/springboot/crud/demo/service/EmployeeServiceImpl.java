package com.luv2code.springboot.crud.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.crud.demo.dao.EmployeeDao;
import com.luv2code.springboot.crud.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		return employeeDao.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee emp) {
		employeeDao.save(emp);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		employeeDao.deleteById(id);
	}

}
