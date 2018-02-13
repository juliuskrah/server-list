package com.juliuskrah.server;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.juliuskrah.server.handlers.HelloHandler;

import lombok.extern.slf4j.Slf4j;

// @Builder
@Slf4j
@EnableWebFluxSecurity
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public MapReactiveUserDetailsService userDetailsRepository() {
		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
				.build();
		return new MapReactiveUserDetailsService(user);
	}

	@Bean
	public RouterFunction<ServerResponse> routingHelloFunction(HelloHandler handler) {
		return route(GET("/"), handler::sendGreeting).andRoute(GET("/{user}"), handler::sendGreetingOnPath);
	}
	
	@Bean
	public ApplicationRunner init(MongoProperties props) {
		return (args) -> {
			log.info("Decrypted URI: {}", props.getUri());
		};
	}

}
