package com.oauthboard.oauth_board_project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@NoArgsConstructor
@DynamicUpdate
@Table(name = "board", catalog = "ordo")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class EmBoard {

  @Id
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String content;

  @Column(name = "create_at")
  @CreatedDate
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/seoul")
  private LocalDateTime createAt;

  @Column(name = "create_by")
  @CreatedBy
  private String createBy;

  @Column(name = "updated_at")
  @LastModifiedDate
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/seoul")
  private LocalDateTime updatedAt;

  @Column(name = "updated_by")
  @LastModifiedBy
  private String updatedBy;

  @Builder
  public EmBoard(String title, String content){
    this.title = title;
    this.content = content;
  }

  public void update(String title, String content){
    this.title = title;
    this.content = content;
  }

}
