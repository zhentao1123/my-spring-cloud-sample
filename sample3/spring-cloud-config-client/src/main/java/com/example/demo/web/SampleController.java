package com.example.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${from}")
	String profile;
	
	@RequestMapping(value="readConfig")
	public String readConfig() {
		return profile;
	}
}
