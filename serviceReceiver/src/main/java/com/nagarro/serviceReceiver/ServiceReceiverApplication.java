package com.nagarro.serviceReceiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.jms.annotation.EnableJms;
@EnableDiscoveryClient
@EnableJms
@EnableAutoConfiguration
@SpringBootApplication
public class ServiceReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceReceiverApplication.class, args);
	}

}
