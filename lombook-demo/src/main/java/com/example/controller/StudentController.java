package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.StudentVO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping(path = "/student")
public class StudentController {
	
	@GetMapping(path = "/") 
	public ResponseEntity<String> greeting() {
		log.info("Inside greeting method");
		return new ResponseEntity<String>("Hello User", HttpStatus.OK);
	}
	
	//Parameter is passed as form data from postman
	@PostMapping(path = "/add")
	public ResponseEntity<String> addStudent(StudentVO student) {
		StudentVO stud = new StudentVO();
		stud.setSsid(student.getSsid());
		stud.setCourse(student.getCourse());
		stud.setName(student.getName());
		log.info("Inside add student method");
		log.info(stud.toString());
		return new ResponseEntity<String>("student added successfully", HttpStatus.CREATED);
	}

}
