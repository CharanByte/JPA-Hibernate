package com.xworkz.food.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.xworkz.food")
@EnableWebMvc
public class FoodConfiguration {

	public FoodConfiguration() {
		System.out.println("running  FoodConfiguration");
	}

}
