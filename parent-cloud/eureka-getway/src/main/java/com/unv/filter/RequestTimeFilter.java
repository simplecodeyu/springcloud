package com.unv.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 此方法可以计算某一个端口请求的到响应的耗时情况
 */
@Component
public class RequestTimeFilter implements GatewayFilter, Ordered {
    private static final String REQUEST_TIME_BEGIN = "requestTimeBegin";
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(REQUEST_TIME_BEGIN,System.currentTimeMillis());
        return chain.filter(exchange).then(
                Mono.fromRunnable(()->{
                    Long startTime = exchange.getAttribute(REQUEST_TIME_BEGIN);
                    if (startTime != null){
                        System.out.println(exchange.getRequest().getURI().getRawPath()+":"+(System.currentTimeMillis() -startTime));
                    }
                })
        );
    }

    @Override
    public int getOrder() {
        return 0;
    }
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder){
        return builder.routes().route(r -> r.path("/get/**").filters(f->f.filter(new RequestTimeFilter())
                .addRequestHeader("X-request-DOO","DEDE"))
                .uri("http://httpbin.org:80")
                .order(0)
                .id("costoer_filter_router")
        ).build();
    }
}
