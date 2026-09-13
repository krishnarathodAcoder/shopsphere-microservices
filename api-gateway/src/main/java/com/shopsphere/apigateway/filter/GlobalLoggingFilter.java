package com.shopsphere.apigateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class GlobalLoggingFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            GatewayFilterChain chain) {

        System.out.println("PRE → Request received");

        return chain.filter(exchange)
                .then(Mono.fromRunnable(() -> {

                    System.out.println(
                            "POST → Response status: "
                                    + exchange.getResponse().getStatusCode()
                    );

                }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}