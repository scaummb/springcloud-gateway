package com.momoubin.gateway.filter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author moubin.mo
 * @date: 2021/2/7 18:26
 */
@Configuration
public class UriKeyResolver implements KeyResolver {
	@Override
	public Mono<String> resolve(ServerWebExchange exchange) {
		return Mono.just(exchange.getRequest().getURI().getPath());
	}

	@Bean
	public UriKeyResolver uriKeyResolver() {
		return new UriKeyResolver();
	}
}
