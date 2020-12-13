package com.pablopb3.tiempoemojis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TiempoEmojisApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiempoEmojisApplication.class, args);
	}

}
