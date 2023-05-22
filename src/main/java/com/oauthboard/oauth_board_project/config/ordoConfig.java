package com.oauthboard.oauth_board_project.config;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@RequiredArgsConstructor
//@ComponentScan(basePackageClasses = Appendable.class)
//@ComponentScan(basePackages = "com.oauthboard.oauth_board_project")
public class ordoConfig {




  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    http.csrf().disable().cors().disable()
        .authorizeHttpRequests(request ->request.dispatcherTypeMatchers(DispatcherType.FORWARD)
            .permitAll()
            .requestMatchers("/ordo/join", "/ordo/loginRedirect", "/ordo/joinRedirect", "/ordo/search", "/ordo/login", "/ordo/board/**") // 로그인안해도 들어갈수 있는 페이지
            .permitAll().anyRequest().authenticated())
        .formLogin(login ->login.loginPage("/ordo/welcome") // url에서 들어올때 진입되는 페이지
//            .loginProcessingUrl("/ordo/loginRedirect") // 로그인버튼 누를시 전송되는 form action
//            .usernameParameter("email").passwordParameter("pw")
            .defaultSuccessUrl("http://192.168.0.8:3000/board",true)
            .permitAll())
        .logout(Customizer.withDefaults());



    return http.build();
  }


  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.addAllowedOrigin("*");
    configuration.addAllowedMethod("*");
    configuration.addAllowedHeader("*");
    configuration.setMaxAge(3600L);
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
