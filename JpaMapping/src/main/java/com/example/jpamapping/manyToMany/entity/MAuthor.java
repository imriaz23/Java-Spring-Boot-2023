package com.example.jpamapping.manyToMany.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Data
public class MAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column private String name;

  @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
  @Cascade({CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
  //  @JsonManagedReference
  private List<MBook> books = new ArrayList<>();
}
