package com.example.deliveryproviderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeliveryProviderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryProviderServiceApplication.class, args);
	}
}
