package org.bphc.RideShare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.bphc.RideShare")
public class RideShareApplication {

	public static void main(String[] args) {
		SpringApplication.run(RideShareApplication.class, args);
	}

}

