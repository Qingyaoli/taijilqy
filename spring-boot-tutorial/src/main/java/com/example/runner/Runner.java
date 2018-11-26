package com.example.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
	
	public void run(String... args) {
		System.out.println("Runner implements CommandLineRunner ....");
	}

}
