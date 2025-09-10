package com.triclope.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import com.nimbusds.jose.jwk.source.ImmutableSecret;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration:86400}")
    private long jwtExpiration;

    private JwtEncoder jwtEncoder;

    private JwtEncoder getJwtEncoder() {
        if (jwtEncoder == null) {
            SecretKeySpec secretKey = new SecretKeySpec(
                jwtSecret.getBytes(StandardCharsets.UTF_8), 
                "HmacSHA256"
            );
            JWKSource<SecurityContext> jwkSource = new ImmutableSecret<>(secretKey);
            jwtEncoder = new NimbusJwtEncoder(jwkSource);
        }
        return jwtEncoder;
    }

    public String generateToken(String username) {
        Instant now = Instant.now();
        
        JwtClaimsSet claims = JwtClaimsSet.builder()
            .issuer("triclope")
            .expiresAt(now.plus(jwtExpiration, ChronoUnit.SECONDS))
            .subject(username)
            .claim("scope", "read write")
            .build();
        JwsHeader jwsHeader = JwsHeader.with(MacAlgorithm.HS256).build();
        return getJwtEncoder().encode(JwtEncoderParameters.from(jwsHeader, claims)).getTokenValue();
    }

    public String generateRefreshToken(String username) {
        Instant now = Instant.now();
        
        JwtClaimsSet claims = JwtClaimsSet.builder()
            .issuer("triclope")
            .issuedAt(now)
            .expiresAt(now.plus(jwtExpiration * 7, ChronoUnit.SECONDS)) // 7 jours
            .subject(username)
            .claim("scope", "refresh")
            .build();

        return getJwtEncoder().encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}