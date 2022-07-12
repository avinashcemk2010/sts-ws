package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.repository.CourseRepository;

@SpringBootTest
class CourseTest {
	
	@Autowired
	private CourseRepository courserepository;

	@Test
	public void printcourses() {
		List<Course> allcourse = courserepository.findAll();
		allcourse.forEach(System.out::println);
	}
	
	@Test
	public void savecoursewithtest() {
		
		Teacher teacher = Teacher.builder()
				.firstname("suman")
				.lastname("jha")
				.build();
		
		Course course = Course.builder()
				.title("python")
				.credit(3)
				.teacher(teacher)
				.build();
		
		courserepository.save(course);
	}
	
	@Test
	public void findallpagination() {
		
		Pageable firstpagewiththreerecord = PageRequest.of(0, 3);
		//Pageable firstpagewithtworecord = PageRequest.of(1, 2);
		
		List<Course> courses = courserepository.findAll(firstpagewiththreerecord).getContent();
		System.out.println("My content:" + courses);
		
		Long totalelements = courserepository.findAll(firstpagewiththreerecord).getTotalElements();
		System.out.println(totalelements);
		
		long totalpages = courserepository.findAll(firstpagewiththreerecord).getTotalPages();
		System.out.println(totalpages);
	}

	@Test
	public void findallsorting() {
		Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
		System.out.println(courserepository.findAll(sortByTitle).getContent());
		
		Pageable sortByCredit = PageRequest.of(0, 2, Sort.by("credit").descending());
		System.out.println(courserepository.findAll(sortByCredit).getContent());
		
		Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title").and(Sort.by("credit")));
		System.out.println(courserepository.findAll(sortByTitleAndCreditDesc).getContent());
	}
	
	@Test
	public void printFindByTileContaining() {
		
		Pageable firstPageTenRecords = PageRequest.of(0, 10);
		List<Course> courses = courserepository.findByTitleContaining("D", firstPageTenRecords).getContent();
		System.out.println(courses);
		
	}
	
	@Test
	public void savecoursewithstudentandteacher() {
		
		Teacher teacher = Teacher.builder()
				.firstname("Lizzie")
				.lastname("Morgan")
				.build();
		
		Student stud = Student.builder()
				.firstname("abhishek")
				.lastname("singh")
				.emailid("abhik@gmail.com")
				.build();
		
		Course course = Course.builder()
				.title("ai")
				.credit(12)
				.teacher(teacher)
				.students(List.of(stud))
				.build();
		
		courserepository.save(course);
	}
}
