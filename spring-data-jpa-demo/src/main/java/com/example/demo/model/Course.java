package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Course {
	
	@Id
	@SequenceGenerator(
			name = "course_sequence",
			sequenceName = "course_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "course_sequence" 
			)
	private Long courseid;
	private String title;
	private int credit;
	
	//Bi directional one to one mapping
	//mapped by tells that this is already mapped by course attribute in other class
	@OneToOne(
			mappedBy = "course"
			)
	private CourseMaterial coursematerial;
	
	@ManyToOne(
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL
			)
	@JoinColumn(
			name = "teacher_id",
			referencedColumnName = "teacherid"
			)
	private Teacher teacher;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "student_course_map",
			joinColumns = @JoinColumn(
					name = "course_id",
					referencedColumnName = "courseid"
					),
			inverseJoinColumns = @JoinColumn(
					name = "student_id",
					referencedColumnName = "studentid"
					)
			)
	private List<Student> students;
	

}
