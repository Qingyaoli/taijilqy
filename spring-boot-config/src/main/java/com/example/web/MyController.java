package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.User;

@RestController
public class MyController {
	
	/*@Value("${my.name}")
	private String name;
	@Value("${my.age}")
	private int age;
	
	@RequestMapping(value="/my")
	public String My() {
		return name+":"+age;
		
	}
*/
//	@Value("${com.example.name}")
//	private String name;
//	@Value("${com.example.age}")
//	private int age;
	
	@Autowired
	private User user;
	
	@RequestMapping(value="/user")
	public String My() {
//		return name+":"+age;
		return user.getName()+":"+user.getAge();
		

	}

}
