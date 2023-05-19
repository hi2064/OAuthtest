package com.oauthboard.oauth_board_project.repository;

import com.oauthboard.oauth_board_project.entity.EmUsers;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmUsersRepository extends JpaRepository<EmUsers, Long> {

  Optional<EmUsers> findByEmail(String email);

  EmUsers findAllByEmail(String email);

  Optional<EmUsers> findById(Long id);






}
