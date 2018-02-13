package com.juliuskrah.server.handlers;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

public interface HelloHandler {
	public Mono<ServerResponse> sendGreeting(ServerRequest request);
	public Mono<ServerResponse> sendGreetingOnPath(ServerRequest request);
}
