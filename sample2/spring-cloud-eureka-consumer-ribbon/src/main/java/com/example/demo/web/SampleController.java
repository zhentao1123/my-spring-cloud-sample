package com.example.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SampleController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    RestTemplate restTemplate;
    
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        //RestTemplate注册的时候加了@LoadBalanced注解；该处可直接使用服务名
    		String url = "http://eureka-client-01/add?a="+a+"&b="+b;
        Integer result = restTemplate.getForObject(url, Integer.class);
        return result;
    }
    
    @RequestMapping(value = "/subtract" ,method = RequestMethod.GET)
    public Integer subtract(@RequestParam Integer a, @RequestParam Integer b) {
    		//RestTemplate注册的时候加了@LoadBalanced注解；该处可直接使用服务名
    		String url = "http://eureka-client-02/subtract?a="+a+"&b="+b;
        Integer result = restTemplate.getForObject(url, Integer.class);
        return result;
    }
}
