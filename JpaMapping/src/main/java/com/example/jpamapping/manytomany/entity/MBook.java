package com.example.jpamapping.manytomany.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Data
public class MBook {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String title;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "author_id")
  @Cascade({CascadeType.PERSIST, CascadeType.SAVE_UPDATE, CascadeType.MERGE})
  @JsonBackReference
  private List<MAuthor> authors = new ArrayList<>();
}
