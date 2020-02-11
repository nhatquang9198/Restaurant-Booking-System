package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//@EnableJpaRepositories(basePackages = "com.repository")
//@ComponentScan(basePackages = "com.*")
//@EntityScan(basePackages = "com.model")
public class RestaurantBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantBookingApplication.class, args);
	}

}
