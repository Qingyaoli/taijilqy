package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.ConfigBean;

@RestController 
@EnableConfigurationProperties({ConfigBean.class})
public class ConfigController {
	@Autowired
	ConfigBean configBean;
	
	@RequestMapping(value="/config")
	public String config() {
		return configBean.toString();
	}
	
	/*@Autowired
	User user;
	@RequestMapping(value="/config")
	public String user() {
		return user.toString();
	}*/
}
