package com.bae.bookingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BookingSystemApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BookingSystemApp.class, args);
	}

}
