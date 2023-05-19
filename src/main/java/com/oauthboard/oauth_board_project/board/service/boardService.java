package com.oauthboard.oauth_board_project.board.service;

import com.oauthboard.oauth_board_project.entity.EmBoard;
import com.oauthboard.oauth_board_project.dto.boardDto;
import java.util.List;
import java.util.Optional;

public interface boardService {

  List<EmBoard> getBoardList();

  Optional<EmBoard> getBoardDetail(Long id);

  Long createBoard(Long id, boardDto req);

  void deleteBoard(Long id);

  Long updateBoard(Long id, boardDto req);

}
