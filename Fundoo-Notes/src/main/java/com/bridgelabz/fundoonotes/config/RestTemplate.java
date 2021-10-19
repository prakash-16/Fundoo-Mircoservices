package com.bridgelabz.fundoonotes.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestTemplate {
	@Bean
	@LoadBalanced
	public RestTemplate restTemp() {
		return new RestTemplate();
	}
	
}
