package com.example.meven.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebappApplication {

	@Autowired
	private CustomProperties props;

	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
	}
}
