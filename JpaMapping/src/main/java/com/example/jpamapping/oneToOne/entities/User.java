package com.example.jpamapping.oneToOne.entities;

import com.example.jpamapping.oneToOne.entities.Profile;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "profile_id")
  @JsonBackReference
  private Profile profile;

  @Column private String firstName;
  @Column private String lastname;

}
