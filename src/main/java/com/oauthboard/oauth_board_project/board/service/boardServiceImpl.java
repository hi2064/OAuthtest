package com.oauthboard.oauth_board_project.board.service;

import com.oauthboard.oauth_board_project.entity.EmBoard;
import com.oauthboard.oauth_board_project.entity.EmUsers;
import com.oauthboard.oauth_board_project.repository.EmBoardRepository;
import com.oauthboard.oauth_board_project.dto.boardDto;
import com.oauthboard.oauth_board_project.repository.EmUsersRepository;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.transaction.Transactional;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class boardServiceImpl implements boardService{

  private final EmBoardRepository emBoardRepository;
  private final EmUsersRepository emUsersRepository;


  @Override
  public List<EmBoard> getBoardList(){

    return emBoardRepository.findAllBy();
  }

  @Override
  public Optional<EmBoard> getBoardDetail(Long id) {
    return emBoardRepository.findById(id);
  }

  @Transactional
  @Override
  public Long createBoard(Long id, boardDto req){
    int user = (int) emUsersRepository.findById(id).stream().count();

    if(user == 0){
      throw new NullPointerException("없는 회원입니다.");
    }
    EmBoard board = EmBoard.builder()
        .title(req.getTitle())
        .content(req.getTitle())
        .build();
    emBoardRepository.save(board);

    return board.getId();
  }

  @Transactional
  @Override
  public void deleteBoard(Long id){

    emBoardRepository.deleteById(id);
  }

  @Transactional
  @Override
  public Long updateBoard(Long id, boardDto req) {
    EmBoard board = emBoardRepository.findById(id).orElseThrow(()->new NullPointerException("존재하지 않는 글입니다."));

    board.update(req.getTitle(), req.getContent());

    return board.getId();
  }


  @Value("${jwt.password}")
  private String secretKey;


  public String getToken(String email) {
    Date now = new Date();
    Date expiration = new Date(now.getTime() + Duration.ofHours(3).toMillis());
    EmUsers usersDetail = this.emUsersRepository.findAllByEmail(email);

    String token = Jwts.builder()
        .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
        .setIssuer(usersDetail.getName())
        .setIssuedAt(now)
        .setExpiration(expiration)
        .setSubject(email)
        .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(secretKey.getBytes()))
        .compact();
    return token;
  }


}
