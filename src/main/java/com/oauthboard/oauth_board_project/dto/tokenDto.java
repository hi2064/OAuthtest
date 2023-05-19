package com.oauthboard.oauth_board_project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class tokenDto {

  private String grantType;   // JWT 대한 인증타입

  private String accessToken;

  private String refreshToken;

}
