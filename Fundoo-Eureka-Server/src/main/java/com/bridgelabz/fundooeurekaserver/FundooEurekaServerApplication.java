package com.bridgelabz.fundooeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FundooEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundooEurekaServerApplication.class, args);
	}

}
