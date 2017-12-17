package com.nextsgo;



import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServer {
	public static void main(String[] args) {
			
			System.out.println(test());
	        SpringApplication.run(EurekaServer.class, args);
	    }
	public static String test() {
		 Map<String, Integer> oneGrade = new HashMap<String, Integer>();
		 oneGrade.put("b", 123);
		 HashMap<String, Integer> oneGrade2 = new HashMap<String, Integer>();
		 oneGrade2.put("a", 12);
		 return oneGrade2.toString();
	}
}
