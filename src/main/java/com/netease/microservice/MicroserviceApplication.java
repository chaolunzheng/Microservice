package com.netease.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);
	}
}
