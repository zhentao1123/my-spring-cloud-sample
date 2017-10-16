package com.example.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SampleClient_01;
import com.example.demo.service.SampleClient_02;

@RestController
public class SampleController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
    
	@Autowired
	SampleClient_01 sampleClient_01;
	
	@Autowired
	SampleClient_02 sampleClient_02;
    
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        Integer result = sampleClient_01.add(a, b);
        return result;
    }
    
    @RequestMapping(value = "/subtract" ,method = RequestMethod.GET)
    public Integer subtract(@RequestParam Integer a, @RequestParam Integer b) {
        Integer result = sampleClient_02.subtract(a, b);
        return result;
    }
}
