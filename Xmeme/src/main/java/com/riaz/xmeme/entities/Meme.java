package com.riaz.xmeme.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.Instant;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Meme {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String userName;
  private String caption;
  private String url;
  @CreatedDate
  @JsonIgnore
  private Instant createdAt;
}
