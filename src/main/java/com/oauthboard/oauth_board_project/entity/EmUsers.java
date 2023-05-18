package com.oauthboard.oauth_board_project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@NoArgsConstructor
@DynamicUpdate
@Table(name = "users", catalog = "ordo")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class EmUsers {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "email",nullable = false)
  private String email;

  @Column(name="name")
  private String name;

  @Column(name = "password",nullable = false)
  private String password;

  @Column(name = "phone")
  private String phone;

  @Column(name = "create_at")
  @CreatedDate
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/seoul")
  private LocalDateTime createAt;

  @Column(name = "updated_by")
  @LastModifiedDate
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/seoul")
  private LocalDateTime updatedBy;

  @Column(name = "site",nullable = false)
  private String site;

  @Builder
  public EmUsers(String email, String pw, String name, String phone,String site){
    System.out.println("빌더들어옴");
    this.email = email;
    this.password = pw;
    this.name = name;
    this.phone = phone;
    this.site = site;
  }



}
