package com.example.jpamapping.manyToMany.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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
    @Column private String title;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "author_id")
  @Cascade({CascadeType.PERSIST, CascadeType.SAVE_UPDATE, CascadeType.MERGE})
  @JsonBackReference
  private List<MAuthor> authors = new ArrayList<>();
}
