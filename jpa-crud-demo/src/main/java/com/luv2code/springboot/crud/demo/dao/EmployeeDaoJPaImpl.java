package com.luv2code.springboot.crud.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.crud.demo.entity.Employee;

@Repository
public class EmployeeDaoJPaImpl implements EmployeeDao {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> findAll() {
		System.out.println("Getting all employees from EmployeeDaoJPaImpl");
		Query theQuery = entityManager.createQuery("from Employee");
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int id) {
		Employee emp = entityManager.find(Employee.class, id);
		return emp;
	}

	@Override
	public void save(Employee emp) {
		Employee employee = entityManager.merge(emp);
		emp.setId(employee.getId());
		System.out.println(employee);
	}

	@Override
	public void deleteById(int id) {
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", id);
		theQuery.executeUpdate();

	}

}
