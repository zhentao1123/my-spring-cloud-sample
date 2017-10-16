package com.example.demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("eureka-client-02")
public interface SampleClient_02 {
	
	 @RequestMapping(value = "/subtract" ,method = RequestMethod.GET)
	 public Integer subtract(@RequestParam("a") Integer a, @RequestParam("b") Integer b);
	
}
