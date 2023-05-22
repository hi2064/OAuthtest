package com.oauthboard.oauth_board_project.board.controller;

import com.oauthboard.oauth_board_project.entity.EmBoard;
import com.oauthboard.oauth_board_project.board.service.boardService;
import com.oauthboard.oauth_board_project.dto.boardDto;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/ordo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class boardController {

  private final boardService boardService;

  // 글목록

  @GetMapping(value = "/board/list")
  public List<EmBoard> getBoardList() {
    return boardService.getBoardList();
  }

  // 글상세
  @GetMapping(value = "/board/{id}/detail")
  public Optional<EmBoard> getBoardDetail(@PathVariable("id") Long id) {
    return boardService.getBoardDetail(id);
  }

  // 글생성
  @PostMapping(value = "/board/{id}/create")
  public Long createBoard(@PathVariable("id") Long id,boardDto req){

    return boardService.createBoard(id, req);
  }

  // 글삭제
  @GetMapping(value = "/board/{id}/delete")
  public void deleteBoard(@PathVariable("id") Long id){
    boardService.deleteBoard(id);
  }

  // 글수정
  @PostMapping(value = "/board/{id}/update")
  public Long updateBoard(@PathVariable("id") Long id, boardDto req){
    return boardService.updateBoard(id, req);
  }

}
