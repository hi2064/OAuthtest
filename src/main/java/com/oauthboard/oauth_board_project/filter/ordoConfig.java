package com.oauthboard.oauth_board_project.filter;

import com.oauthboard.oauth_board_project.dto.loginDto;
import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@RequiredArgsConstructor
public class ordoConfig {

//  private final loginDto logindto;


//  @Bean
//  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//    http.csrf()
//        .disable()
//        .authorizeRequests().requestMatchers(HttpMethod.DELETE)
//        .hasRole("Admin").requestMatchers("/Admin/**")
//        .hasAnyRole("USER", "ADMIN")
//        .requestMatchers("/login/**")
//        .anonymous()
//        .anyRequest().authenticated().and().httpBasic().and().sessionManagement().sessionCreationPolicy(
//            SessionCreationPolicy.STATELESS);
//
//    return http.build();
//  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    http.csrf().disable().cors().disable()
        .authorizeHttpRequests(request ->request.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll().requestMatchers("/ordo/join", "/ordo/loginRedirect", "/ordo/joinRedirect", "/ordo/search", "/ordo/login") // 로그인안해도 들어갈수 있는 페이지
            .permitAll().anyRequest().authenticated())
        .formLogin(login ->login.loginPage("/ordo/welcome") // url에서 들어올때 진입되는 페이지
//            .loginProcessingUrl("/ordo/loginRedirect") // 로그인버튼 누를시 전송되는 form action
//            .usernameParameter("email").passwordParameter("pw")
            .defaultSuccessUrl("/ordo/main",true).permitAll())
        .logout(Customizer.withDefaults());



    return http.build();
  }

//  @Bean
//  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http.authorizeHttpRequests().requestMatchers(
//            new AntPathRequestMatcher("/**")).permitAll()
//        .and()
//        .csrf().ignoringRequestMatchers(
//            new AntPathRequestMatcher("/h2-console/**"))
//        .and()
//        .headers()
//        .addHeaderWriter(new XFrameOptionsHeaderWriter(
//            XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
//        .and()
//        .formLogin()
//        .loginPage("/ordo/welcome")
//        .defaultSuccessUrl("/")
//    ;
//
//    return http.build();
//  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
