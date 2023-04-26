package com.example.pharmacy_project;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

  // Entity가 생성되어 저장될 때 시간이 자동 저장된다.
  @CreatedDate
  @Column(updatable = false) // 최초 저장 후 수정 금지
  private LocalDateTime createdDate;

  // 조회한 Entity의 값을 변경할 때 시간이 자동 저장된다.
  @LastModifiedDate
  private LocalDateTime modifiedDate;

  // @CreatedBy 생성자
  // @LastModifiedBy 수정자

}
