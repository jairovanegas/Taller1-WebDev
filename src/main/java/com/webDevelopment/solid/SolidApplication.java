package com.webDevelopment.solid;

import com.webDevelopment.solid.DB.DB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SolidApplication {
	public static void main(String[] args) {
		DB db = DB.getInstance();
		SpringApplication.run(SolidApplication.class, args);
	}

}
