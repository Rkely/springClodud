package com.appsdeveloperblog.photoapp.api.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;


@SpringBootApplication
@EnableDiscoveryClient
public class PhotoAppApiUsersApplication {

	@Autowired
	Environment environment;
	
	public static void main(String[] args) {
		SpringApplication.run(PhotoAppApiUsersApplication.class, args);
	}
	

	public String createNotProductionBean() {
		System.out.println("Not Production bean created. myapplication.environment = " + environment.getProperty("myapplication.environment"));
		return "Not production bean";
	}
}
