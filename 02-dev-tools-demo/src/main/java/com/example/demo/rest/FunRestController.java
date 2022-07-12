package com.example.demo.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FunRestController {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello world. Time on server:" + LocalDateTime.now();
	}
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "coach name:" + coachName + "\n" + "team name:" + teamName;
	}

}
