package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
				.addMapping("/**")
				.allowedOrigins("*")
				.allowedHeaders("x-requested-with", "Content-Type", "auth_token", "external_client_token", "Accept-Language", "x-app-id", "x-fingerprint")
				.maxAge(3600)
				.allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE");
	}
}
