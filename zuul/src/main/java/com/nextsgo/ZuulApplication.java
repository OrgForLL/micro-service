package com.nextsgo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
@SpringBootApplication
@EnableDiscoveryClient
public class ZuulApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
	}

//	@Bean
//	public AccessFilter accessFilter() {
//		return new AccessFilter();
//	}
//	
//	@Bean
//	public RateLimitFilter rateLimiterFilter() {
//		return new RateLimitFilter();
//	}
//	
//	@Bean
//	public ResultFilter resultFilter() {
//		return new ResultFilter();
//	}
//	
//	@Bean
//	public UuidFilter uuidFilter() {
//		return new UuidFilter();
//	}
//	
//	@Bean
//	public ValidateFilter validateFilter() {
//		return new ValidateFilter();
//	}
//	
//	@Bean
//	public ErrorFilter errorFilter() {
//		return new ErrorFilter();
//	}

}
