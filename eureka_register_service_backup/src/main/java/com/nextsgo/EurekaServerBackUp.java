package com.nextsgo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerBackUp {
	public static void main(String[] args) {
	        SpringApplication.run(EurekaServerBackUp.class, args);
	    }
}
