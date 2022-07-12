package com.luv2code.springboot.crud.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.crud.demo.entity.Employee;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao{

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> findAll() {
		System.out.println("Getting all employees from EmployeeDaoHibernateImpl");
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee emp = currentSession.get(Employee.class, id);
		return emp;
	}

	@Override
	public void save(Employee emp) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(emp);
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee emp = currentSession.get(Employee.class, id);
		currentSession.delete(emp);
	}

}
