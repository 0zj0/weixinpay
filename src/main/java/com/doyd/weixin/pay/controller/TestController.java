package com.doyd.weixin.pay.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@RequestMapping(value="/hello")
	public String testHello(){
		return "Hello world!";
	}
	
	
	@RequestMapping(value="/welcome/{name}",method = RequestMethod.POST)
	public String testWelcomeName(@PathVariable("name") String name){
		return "welcome "+name;
	}
}
