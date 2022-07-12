package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.CourseVO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping(path = "/course")
public class CourseController {
	
	@GetMapping(path = "/") 
	public ResponseEntity<String> greeting() {
		log.info("Inside greeting method from course");
		return new ResponseEntity<String>("My courses", HttpStatus.OK);
	}
	
	//Parameter is passed as raw json from postman
	@PostMapping(path = "/add")
	public ResponseEntity<String> addCourse(@RequestBody CourseVO c) {
		CourseVO course = new CourseVO(c.getCid(), c.getCoursename(), c.getStudentsenrolled());
		log.info(course.toString());
		return new ResponseEntity<String>("My courses was added", HttpStatus.OK);
		
	}

}
