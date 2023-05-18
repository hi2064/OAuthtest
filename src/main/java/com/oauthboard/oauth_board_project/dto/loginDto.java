package com.oauthboard.oauth_board_project.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
public class loginDto {
  private String email;

  private String password;


}
