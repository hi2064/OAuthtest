package com.oauthboard.oauth_board_project.model;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.token.Token;

public class UserAuthToken {
  @Value("${jwt.password}")
  private String secretKey;


//
//  public Token createAccessToken(String email, List<String> role) {
//    Claims claims = Jwts.claims().setSubject(email);    // jwt payload에 저장되는 정보
//    claims.put("role", role);
//    Date now = new Date();
//
//    // Access Token
//    String accessToken = Jwts.builder()
//        .setClaims(claims)
//        .setIssuedAt(now)
//        .setExpiration(new Date(now.getTime() + Duration.ofHours(3).toMillis()))
//        .signWith(SignatureAlgorithm.HS256, secretKey)
//        .compact();
//
//    // Refresh Token
//    String refreshToken = Jwts.builder()
//        .setClaims(claims)
//        .setIssuedAt(now)
//        .setExpiration(new Date(now.getTime() + Duration.ofDays(30).toMillis()))
//        .signWith(SignatureAlgorithm.HS256, secretKey)
//        .compact();
//
//    return Token.class;
//
//
//  }


}
