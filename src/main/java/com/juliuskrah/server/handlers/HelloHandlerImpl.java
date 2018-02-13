package com.juliuskrah.server.handlers;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Service
public class HelloHandlerImpl implements HelloHandler {

	@Override
	public Mono<ServerResponse> sendGreeting(ServerRequest request) {
		// int personId = Integer.valueOf(request.pathVariable("id"));
		// Mono<ServerResponse> notFound = ServerResponse.notFound().build();
		return ServerResponse.ok().contentType(APPLICATION_JSON).body(fromObject("Hello World!"));
	}

	@Override
	public Mono<ServerResponse> sendGreetingOnPath(ServerRequest request) {
		String user = request.pathVariable("user");
		return ServerResponse.ok().contentType(APPLICATION_JSON).body(fromObject("Hello " + user + "!"));
	}

}
