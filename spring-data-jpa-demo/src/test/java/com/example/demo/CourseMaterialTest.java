package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Course;
import com.example.demo.model.CourseMaterial;
import com.example.demo.repository.CourseMaterialRepository;

@SpringBootTest
class CourseMaterialTest {
	
	@Autowired
	private CourseMaterialRepository coursematerialrepository;

	@Test
	public void savecoursematerial() {
		
		Course c = Course.builder()
				.title(".net")
				.credit(6)
				.build();
		
		CourseMaterial cm = CourseMaterial.builder()
				.url("www.dailycodebuffer.com")
				.course(c) 
				.build();
		
		coursematerialrepository.save(cm);
	}
	
	@Test
	public void printallcourses() {
		List<CourseMaterial> allcourse = coursematerialrepository.findAll();
		allcourse.forEach(System.out::println);
	}

}
