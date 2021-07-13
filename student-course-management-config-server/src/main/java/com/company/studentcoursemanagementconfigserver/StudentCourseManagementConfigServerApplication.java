package com.company.studentcoursemanagementconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class StudentCourseManagementConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentCourseManagementConfigServerApplication.class, args);
	}

}
