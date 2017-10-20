package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableConfigServer
@SpringBootApplication
@RestController
public class Application {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		return "I'm a Config Server";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
