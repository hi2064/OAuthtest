package com.oauthboard.oauth_board_project.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class boardDto {


  private String title;

  private String content;

  private String createAt;

  private String createBy;

  private String updatedAt;

  private String updatedBy;

}
