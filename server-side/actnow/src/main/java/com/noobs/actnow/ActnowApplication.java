package com.noobs.actnow;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ActnowApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActnowApplication.class, args);
	}


}
