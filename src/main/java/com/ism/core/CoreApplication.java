package com.ism.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		System.out.println("Test");
		SpringApplication.run(CoreApplication.class, args);
	}

}
