package com.oauthboard.oauth_board_project.loginservice;

import com.oauthboard.oauth_board_project.entity.EmUsers;
import com.oauthboard.oauth_board_project.repository.EmUsersRepository;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class loginserviceImpl implements loginservice {

  private final EmUsersRepository emUsersRepository;



  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//  @Value("${jwt.password}")
//  private final String secretKey;
//
//
//  @Override
//  public String getToken(String email) {
//    Date now = new Date();
//    Date expiration = new Date(now.getTime() + Duration.ofHours(3).toMillis());
//    EmUsers usersDetail = this.emUsersRepository.findAllByEmail(email);
//
//    String token = Jwts.builder()
//        .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
//        .setIssuer(usersDetail.getName())
//        .setIssuedAt(now)
//        .setExpiration(expiration)
//        .setSubject(email)
//        .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(secretKey.getBytes()))
//        .compact();
//    return token;
//  }


}
