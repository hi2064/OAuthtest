package com.oauthboard.oauth_board_project.loginservice;

import com.oauthboard.oauth_board_project.dto.joinDto;
import com.oauthboard.oauth_board_project.entity.EmUsers;
import com.oauthboard.oauth_board_project.repository.EmUsersRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class JoinServiceImpl implements joinservice{

  private final EmUsersRepository emUsersRepository;




  @Override
  @Transactional
  public String join(HttpServletRequest request) {
    try{
      if(request.getParameter("email") == null || request.getParameter("email") == "" || request.getParameter("pw") == null || request.getParameter("pw") == ""){
        throw new NullPointerException();
      }
    }catch(Exception e){

    }
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(BCryptVersion.$2A);
    String encodedPassword = encoder.encode(request.getParameter("pw"));


    EmUsers Users = EmUsers.builder()
            .email(request.getParameter("email"))
            .pw(encodedPassword)
            .name(request.getParameter("name"))
            .phone(request.getParameter("phone"))
            .site("Common")
            .build();
    emUsersRepository.save(Users);
    return "/login";
  }

  @Override
  @Transactional
  public int searchEmail(String email) {
    int check;
    Optional<EmUsers> find = emUsersRepository.findByEmail(email);
    System.out.println("확인");
    System.out.println(email);
    System.out.println(find.toString());

    if(find.isEmpty()){
      check = 0;
    }else{
      check = 1;
    }
    return check;
  }

}
