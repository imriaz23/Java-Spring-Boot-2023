package com.example.jpamapping.oneToMany.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

    @Column
    private String title;

  @ManyToOne
  @JoinColumn(name = "author_id")
  @JsonBackReference
  private Author author;
}
