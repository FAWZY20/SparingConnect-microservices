package com.example.api_gateway.configuraton;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GatewayDiscoveryConfiguration {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("gestionMessage",p -> p
                        .path("/gestionMessage/**")
                        .uri("lb://GESTIONMESSAGE"))
                .route("gestionProfil",p -> p
                        .path("/gestionProfil/**")
                        .uri("lb://GESTIONPROFIL"))
                .route("gestionUtilisateur",p -> p
                        .path("/gestionUtilisateur/**")
                        .uri("lb://GESTIONUTILISATEUR"))
                .build();
    }
}
