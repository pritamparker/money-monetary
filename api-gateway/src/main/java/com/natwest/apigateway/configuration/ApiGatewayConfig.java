package com.natwest.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {
	
	@Bean
	public RouteLocator buildRoutes(RouteLocatorBuilder build) {
		return build.routes().route(r -> 
							  r.path("/api/v1/user/**")
							  .uri("lb://user-api"))
							 .route(r -> 
							 r.path("/api/v1/accounts/**")
							 .uri("lb://accounts-api"))
							 .route(r -> 
							 r.path("/api/v1/transaction/**")
							 .uri("lb://transaction-api"))
							 .build();
}
}