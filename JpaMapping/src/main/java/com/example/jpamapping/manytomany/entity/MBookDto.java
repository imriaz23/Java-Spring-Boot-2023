package com.example.jpamapping.manytomany.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * A DTO for the {@link MBook} entity
 */
@Data
public class MBookDto{
  private Long id;
  private String title;
  @JsonBackReference
  private List<MAuthorDto> authors;
}