package dev.buddly.factorycrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EducatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducatorApplication.class, args);
	}

}
