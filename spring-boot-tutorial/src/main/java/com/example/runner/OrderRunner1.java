package com.example.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OrderRunner1 implements CommandLineRunner {

	public OrderRunner1() {
		// TODO Auto-generated constructor stub
		System.out.println("orderRunner1  is runing");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("orderrunner1 run is running");
	}

}
