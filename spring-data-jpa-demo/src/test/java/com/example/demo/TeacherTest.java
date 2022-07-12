package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Course;
import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;

@SpringBootTest
class TeacherTest {
	
	@Autowired
	private TeacherRepository teacherrepository;

	@Test
	public void saveteacher() {
		
		Course course1 = Course.builder()
				.title("Java")
				.credit(2)
				.build();
		
		Course course2 = Course.builder()
				.title("FLAT")
				.credit(5)
				.build();
		
		Teacher teacher = Teacher.builder()
				.firstname("raju")
				.lastname("jha")
				//.courses(List.of(course1, course2))
				.build();
		
		teacherrepository.save(teacher);
	}

}
