package com.minju.firstproject.provider;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {
    
    //* JWT 생성 혹은 검증에 사용될 시크릿 키 
    //* 시크릿 키 같은 데이터는 보안에 유의해야 하기 때문에 
    //* application.properties 또는 환경변수로 등록해서 사용 
    @Value("${jwt.secret-key}")  // application.properties에서 불러온 값 Value
    private String SECRET_KEY = "Secret1!";

    //* JWT 생성 메서드 */
    public String create(String subject) {

        Date expiredDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));

        String jwt =
         Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, subject)
            .setSubject(subject)
            .setIssuedAt(new Date())
            .setExpiration(expiredDate)
            .compact();
        return jwt;

    }

    //* JWT 검증 */
    public String validate(String jwt) {
        Claims claims = 
            Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(jwt)
                .getBody();
                return claims.getSubject();
    }

}
