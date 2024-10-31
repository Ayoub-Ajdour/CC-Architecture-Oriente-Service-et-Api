package ma.fpl.equipesecurity.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class OAuth2ResourceServerConfigurer {
    private AuthenticationManager authenticationManager;
    private JwtEncoder jwtEncoder;

    public OAuth2ResourceServerConfigurer(AuthenticationManager authenticationManager, JwtEncoder jwtEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtEncoder = jwtEncoder;
    }

    @PostMapping("/login")
    public Map<String, String> login(String username, String password, String userType){

        String c = username+":"+userType;
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(c, password)
        );
        Instant instant = Instant.now();
        String scope =  authenticate.getAuthorities().stream().map(auth -> auth.getAuthority()).collect(Collectors.joining(" "));
        JwtClaimsSet jwtClaimsSet_Access_token =  JwtClaimsSet.builder()
                .issuer("Equipe_Security")
                .subject(authenticate.getName())
                .issuedAt(instant)
                .expiresAt(instant.plus(5, ChronoUnit.MINUTES))
                .claim("name",authenticate.getName())
                .claim("scope",scope)
                .build();
                String Acces_Token = jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet_Access_token)).getTokenValue();
        JwtClaimsSet jwtClaimsSet_refresh_token =  JwtClaimsSet.builder()
                .issuer("Equipe_Security")
                .subject(authenticate.getName())
                .issuedAt(instant)
                .expiresAt(instant.plus(10, ChronoUnit.MINUTES))
                .claim("name",authenticate.getName())
                .build();
        String RefrechToken = jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet_refresh_token)).getTokenValue();
        Map<String, String> ID_Token = new HashMap<>();
        ID_Token.put("Access_Token",Acces_Token);
        ID_Token.put("Refresh_Token",RefrechToken);
        return ID_Token;
    }

    public static void jwt(org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer<HttpSecurity> httpSecurityOAuth2ResourceServerConfigurer) {
    }
}
