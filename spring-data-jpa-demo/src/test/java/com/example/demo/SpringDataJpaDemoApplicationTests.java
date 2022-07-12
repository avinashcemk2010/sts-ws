package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Guardian;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@SpringBootTest
//@DataJpaTest
class SpringDataJpaDemoApplicationTests {
	
	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void saveStudent() {
		Student student = Student.builder()
				.emailid("avinash.jha@broadridge.com")
				.firstname("avinash")
				.lastname("jha")
				//.guardianemail("brajendra.jha@email.com")
				//.guardianname("brajendra")
				//.guardianmobile("9874295597")
				.build();
		
		studentRepository.save(student);
	}
	
	@Test
	public void saveStudentwithguardian() {
		
		Guardian guardian = Guardian.builder()
				.name("arun")
				.email("arun.sharma@br.com")
				.mobile("9876789876")
				.build();
		
		Student student = Student.builder()
				.emailid("shivam.jha@broadridge.com")
				.firstname("shivam")
				.lastname("jha")
				.guardian(guardian)
				.build();
		
		studentRepository.save(student);
	}
	
	@Test
	public void printAllStudent() {
		List<Student> list = studentRepository.findAll();
		list.forEach(System.out::println);
	}
	
	@Test
	public void printfindByFirstname() {
		List<Student> list= studentRepository.findByfirstname("shivam");
		list.forEach(System.out::println);
	}
	
	@Test
	public void printfindByFirstnamecontaining() {
		List<Student> list= studentRepository.findByfirstnameContaining("sh");
		list.forEach(System.out::println);
	}
	
	@Test
	public void printfindByGuardianName() {
		List<Student> list= studentRepository.findByGuardianName("arun");
		list.forEach(System.out::println);
	}
	
	@Test
	public void printStudentByemailAddress() {
		Student s= studentRepository.getStudentByEmailAddress("shivam.jha@broadridge.com");
		System.out.println(s);
	}
	
	@Test
	public void printStudentByemailAddressNative() {
		Student s= studentRepository.getStudentByEmailAddressNative("shivam.jha@broadridge.com");
		System.out.println(s);
	}
	
	@Test
	public void printStudentByemailAddressNamed() {
		Student s= studentRepository.getStudentByEmailAddressNamedPara("shivam.jha@broadridge.com");
		System.out.println(s);
	}
	
	@Test
	public void printupdateStudentNameByEmailid() {
		int s= studentRepository.updateStudentNameByEmailid("Shivam mehra","shivam.jha@broadridge.com");
		System.out.println(s);
	}

}
