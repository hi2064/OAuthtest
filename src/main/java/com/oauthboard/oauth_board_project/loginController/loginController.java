package com.oauthboard.oauth_board_project.loginController;

import com.oauthboard.oauth_board_project.dto.joinDto;

import com.oauthboard.oauth_board_project.loginservice.joinservice;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/ordo")
public class loginController {


  private final joinservice joinservice;

  // 로그인페이지 요청
  @GetMapping(value = "/welcome")
  public String loginPage() {

    return "/login";
  }

  @GetMapping(value = "/main")
  public String mainPage() {
    return "/loginRedirect";
  }

  // 로그인처리
  @PostMapping(value = "/loginRedirect")
  public String login(HttpServletRequest request, HttpServletResponse response) {
    System.out.println("컨트롤러");

    System.out.println("컨트롤러");


    return "/login";
  }


  @GetMapping(value = "/join" )
  public String joinOrdo() {
    return "/join";
  }

  @PostMapping(value = "/joinRedirect")
  public String joinRedirect(HttpServletRequest request) {
    return joinservice.join(request);
  }

  @PostMapping(value = "/search")
  @ResponseBody
  public int searchEmail(HttpServletRequest request) {


    return joinservice.searchEmail(request.getParameter("email"));
  }


}
