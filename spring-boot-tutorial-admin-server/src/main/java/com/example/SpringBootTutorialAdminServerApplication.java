package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.config.EnableAdminServer;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class SpringBootTutorialAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTutorialAdminServerApplication.class, args);
	}
}
