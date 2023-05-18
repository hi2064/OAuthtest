package com.oauthboard.oauth_board_project.loginservice;
import com.oauthboard.oauth_board_project.dto.joinDto;
import jakarta.servlet.http.HttpServletRequest;

public interface joinservice {

  String join(HttpServletRequest request);

  int searchEmail(String email);

}
