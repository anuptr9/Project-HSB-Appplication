package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HsbUserRoomTypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HsbUserRoomTypeApplication.class, args);
	}

}
