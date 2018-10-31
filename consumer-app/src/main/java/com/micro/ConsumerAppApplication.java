package com.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务消费者实例
 * 注解 @EnableDiscoveryClient 作用：自动注册为eureka上的服务
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerAppApplication {
	/**
	 * 自动注册为bean 开启负载均衡能力
	 * @return
	 */
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * 服务启动入口
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConsumerAppApplication.class, args);
	}
}
