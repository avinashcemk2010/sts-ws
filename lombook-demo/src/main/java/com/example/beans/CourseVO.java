package com.example.beans;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseVO {
	
	private final int cid;
	private final String coursename;
	private final List<Integer> studentsenrolled; 

}
