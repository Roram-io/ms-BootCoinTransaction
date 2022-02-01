package com.nttdata.msbootcointransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class MsBootcoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBootcoinApplication.class, args);
	}

}
