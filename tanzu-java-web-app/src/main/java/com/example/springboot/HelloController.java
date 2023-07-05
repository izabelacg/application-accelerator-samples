package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@Autowired
	private Environment environment;

	String getGreeting_FromEnvironment() {
		return environment.getProperty("greeting");
	}
	@RequestMapping("/")
	public String index() {
		String greeting = "Spring Boot + Tanzu";
		if (!getGreeting_FromEnvironment().isEmpty()) {
			greeting = getGreeting_FromEnvironment();
		}
		return String.format("Greetings from %s!", greeting);
	}

}