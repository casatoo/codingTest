package com.KMS.java.codingTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class ProgramingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgramingApplication.class, args);
	}
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ProgramingApplication.class);
	}

}
