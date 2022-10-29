package com.pubsub.redispubsub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( "com.pubsub.redispubsub")
public class RedispubsubApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedispubsubApplication.class, args);
	}

}
