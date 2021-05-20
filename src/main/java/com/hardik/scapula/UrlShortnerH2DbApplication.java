package com.hardik.scapula;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class UrlShortnerH2DbApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlShortnerH2DbApplication.class, args);
	}

	@Bean
	@Primary
	public UrlValidator urlValidator() {
		return new UrlValidator(new String[] { "http", "https" });
	}
}
