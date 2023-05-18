package com.oauthboard.oauth_board_project;

import lombok.Getter;

@Getter
public enum roleEnum {

  ADMIN("ROLE_ADMIN"),
  USER("ROLE_USER");

  roleEnum(String value){
    this.value = value;
  }

  private String value;
}
