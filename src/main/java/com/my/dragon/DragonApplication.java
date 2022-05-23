package com.my.dragon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.my.dragon.repository")
public class DragonApplication {

	public static void main(String[] args) {
		SpringApplication.run(DragonApplication.class, args);
	}

}
