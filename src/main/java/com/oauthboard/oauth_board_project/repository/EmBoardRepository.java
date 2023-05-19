package com.oauthboard.oauth_board_project.repository;

import com.oauthboard.oauth_board_project.entity.EmBoard;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmBoardRepository extends JpaRepository<EmBoard, Long> {

  List<EmBoard> findAllBy();

  Optional<EmBoard> findById(Long id);

  void deleteById(Long id);

}
