package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@ToString(exclude = "course")
public class CourseMaterial {
	
	@Id
	@SequenceGenerator(
			name = "coursematerial_sequence",
			sequenceName = "coursematerial_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "coursematerial_sequence" 
			)
	private Long coursematerialid;
	private String url;
	
	
	//cascading will save the course class before saving course material
	@OneToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			optional = false
			)
	@JoinColumn(
			name = "course_id",
			referencedColumnName = "courseid"
			)
	private Course course;

}
