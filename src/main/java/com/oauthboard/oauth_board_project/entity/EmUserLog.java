package com.oauthboard.oauth_board_project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@NoArgsConstructor
@DynamicUpdate
@Table(name = "userlog", catalog = "ordo")
@Entity
public class EmUserLog {

  @Id
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String createAt;
}
