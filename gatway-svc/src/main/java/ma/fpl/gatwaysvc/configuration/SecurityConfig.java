package ma.fpl.gatwaysvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
        private RsaConfig rsaConfig;
        public SecurityConfig(RsaConfig rsaConfig) {
            this.rsaConfig = rsaConfig;
        }
        @Bean
        public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
            http
                    .csrf(csrf -> csrf.disable())
                    .authorizeExchange(auth -> auth
                            .pathMatchers("/EQUIPE/api/v1/equip/**").hasAuthority("SCOPE_RESPONSABLE_PRINCIPALE")
                            .pathMatchers("/JOUEUR/api/v1/equip/**").hasAuthority("SCOPE_RESPONSABLE_SECONDAIRE")
                    )
                    .oauth2ResourceServer(oauth2 -> oauth2.jwt());
            return http.build();
        }
        @Bean
        public ReactiveJwtDecoder jwtDecoder() {
            return NimbusReactiveJwtDecoder.withPublicKey(rsaConfig.publicKey()).build();
        }
    }

