package com.company.studentcoursemanagementserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class StudentCourseManagementServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentCourseManagementServiceRegistryApplication.class, args);
	}

}
