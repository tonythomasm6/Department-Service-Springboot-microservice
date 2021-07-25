package com.microservice.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);

	}

	/**Rest template is made as bean so that it can be autowired and used anywhere**/
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
