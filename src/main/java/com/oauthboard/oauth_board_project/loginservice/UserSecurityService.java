package com.oauthboard.oauth_board_project.loginservice;

import com.oauthboard.oauth_board_project.entity.EmUsers;
import com.oauthboard.oauth_board_project.repository.EmUsersRepository;
import com.oauthboard.oauth_board_project.roleEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {

  private final EmUsersRepository emUsersRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
    Optional<EmUsers> users = this.emUsersRepository.findByEmail(email);
    if(users.isEmpty()){
      throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
    }

    EmUsers emUsers = users.get();
    List<GrantedAuthority> authorities = new ArrayList<>();
    if("admin".equals(email)){
      authorities.add(new SimpleGrantedAuthority(roleEnum.ADMIN.getValue()));
    }else{
      authorities.add(new SimpleGrantedAuthority(roleEnum.USER.getValue()));
    }
    return new User(emUsers.getEmail(), emUsers.getPassword(), authorities);
  }

}
