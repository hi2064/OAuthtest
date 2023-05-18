package com.oauthboard.oauth_board_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class OAuthBoardProjectApplication {

  public static void main(String[] args) {
    SpringApplication.run(OAuthBoardProjectApplication.class, args);
  }

}
