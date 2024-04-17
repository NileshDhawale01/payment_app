package com.nsd.payment_app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Nilesh Dhawale
 * @Since 15-April-2024
 * @Version 1.0
 */

@Configuration
public class CrossOrigin implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**").allowedOrigins("http://localhost:3000") // Allow requests from this origin
				.allowedMethods("GET", "POST", "PUT", "DELETE") // Allow these methods
				.allowedHeaders("*");
	}

}
