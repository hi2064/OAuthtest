package com.oauthboard.oauth_board_project.loginservice;

import com.oauthboard.oauth_board_project.entity.EmUsers;
import com.oauthboard.oauth_board_project.repository.EmUsersRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class loginserviceImpl implements loginservice {

  private final EmUsersRepository emUsersRepository;



  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


}
