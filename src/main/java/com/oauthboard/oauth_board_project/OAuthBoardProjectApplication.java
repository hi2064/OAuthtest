package com.oauthboard.oauth_board_project;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableJpaAuditing
@RequiredArgsConstructor
@SpringBootApplication
@EnableWebMvc
//@ComponentScan(basePackageClasses = Appendable.class)
@ComponentScan(basePackages = "com.oauthboard")
public class OAuthBoardProjectApplication {

  public static void main(String[] args) {
    SpringApplication.run(OAuthBoardProjectApplication.class, args);
  }

//  @Bean
//  public WebMvcConfigurer webMvcConfigurer() {
//    return new WebMvcConfigurer() {
//      @Override
//      public void addCorsMappings(CorsRegistry corsRegistry){
//        corsRegistry.addMapping("/**").allowedOrigins("/**").allowedHeaders("*");
//      }
//    };
//  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("/**").allowedHeaders("*");
      }
    };
  }

}
