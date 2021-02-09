package com.momoubin.gateway.filter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author moubin.mo
 * @date: 2021/2/7 18:27
 */
@Configuration
public class UserKeyResolver implements KeyResolver {
	@Override
	public Mono<String> resolve(ServerWebExchange exchange) {
		return Mono.just((String)exchange.getAttributes().get("userName"));
	}

	@Bean
	public UserKeyResolver userKeyResolver(){
		return new UserKeyResolver();
	}
}
