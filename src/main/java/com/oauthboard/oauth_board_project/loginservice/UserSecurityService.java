package com.oauthboard.oauth_board_project.loginservice;

import com.oauthboard.oauth_board_project.entity.EmUsers;
import com.oauthboard.oauth_board_project.repository.EmUsersRepository;
import com.oauthboard.oauth_board_project.roleEnum;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {

  private final EmUsersRepository emUsersRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
    Optional<EmUsers> users = this.emUsersRepository.findByEmail(email);

    if(users.isEmpty()){
      throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
    }

    EmUsers emUsers = users.get();
    List<GrantedAuthority> authorities = new ArrayList<>();
    if("admin".equals(email)){
      authorities.add(new SimpleGrantedAuthority(roleEnum.ADMIN.getValue()));
    }else{
      authorities.add(new SimpleGrantedAuthority(roleEnum.USER.getValue()));
    }

    return new User(emUsers.getEmail(), emUsers.getPassword(), authorities);
  }


//
//
//  @Value("${jwt.password}")
//  private String secretKey;
//
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
