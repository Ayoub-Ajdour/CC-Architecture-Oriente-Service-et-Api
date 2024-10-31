package ma.fpl.gatwaysvc;

import ma.fpl.gatwaysvc.configuration.RsaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(RsaConfig.class)
public class GatwaySvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatwaySvcApplication.class, args);
    }
    @Bean
    DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp){
        return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
    }
    @Bean
    RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder
                .routes()
                .route(r-> r.path("/api/v1/**")
                        .filters(f-> f.addRequestHeader("token","ttt"))
                        .uri("http://localhost:8883"))
                .route(r-> r.path("/api/v1/equip/**").uri("http://localhost:8881"))
                .route(r-> r.path("/api/v1/joueur/**").uri("http://localhost:8882"))
                .build();
    }

}
