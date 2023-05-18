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
@Table(name = "board", catalog = "ordo")
@Entity
public class EmBoard {

  @Id
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String content;

  @Column
  private String createAt;

  @Column
  private String createBy;

  @Column
  private String updatedAt;

  @Column
  private String updatedBy;
}
