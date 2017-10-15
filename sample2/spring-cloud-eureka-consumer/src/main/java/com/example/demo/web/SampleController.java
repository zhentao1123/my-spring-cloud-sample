package com.example.demo.web;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Maps;

@RestController
public class SampleController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    LoadBalancerClient loadBalancerClient;
    
    @Autowired
    RestTemplate restTemplate;
    
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
    		ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client-01");
    		/*
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/add";
        HashMap<String, String> paramMap = Maps.newHashMap();
        paramMap.put("a", a.toString());
        paramMap.put("b", b.toString());
        Integer result = restTemplate.getForObject(url, Integer.class, paramMap);
        */
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/add?a="+a+"&b="+b;
        logger.debug(url);
        Integer result = restTemplate.getForObject(url, Integer.class);
        return result;
    }
    
    @RequestMapping(value = "/subtract" ,method = RequestMethod.GET)
    public Integer subtract(@RequestParam Integer a, @RequestParam Integer b) {
    		ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client-02");
    		String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/subtract?a="+a+"&b="+b;
    		logger.debug(url);
    		Integer result = restTemplate.getForObject(url, Integer.class);
        return result;
    }
}
