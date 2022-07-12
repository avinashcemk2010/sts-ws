package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	public List<Student> findByfirstname(String firstname);
	
	List<Student> findByfirstnameContaining(String name);
	
	List<Student> findByGuardianName(String guardianName);
	
	//JPQL
	@Query("select s from Student s where s.emailid = ?1")
	Student getStudentByEmailAddress(String emailid);
	
	//Native query
	@Query(
			value = "select * from tbl_student s where s.email_address = ?1",
			nativeQuery = true
			)
	Student getStudentByEmailAddressNative(String emailid);
	
	//Native named para
	@Query(
			value = "select * from tbl_student s where s.email_address = :emailid",
			nativeQuery = true
			)
	Student getStudentByEmailAddressNamedPara(@Param("emailid") String emailid);
	
	@Modifying
	@Transactional
	@Query(
			value = "update tbl_student set firstname = ?1 where email_address = ?2",
			nativeQuery = true
			)
	int updateStudentNameByEmailid(String firstname, String emailid);

}
