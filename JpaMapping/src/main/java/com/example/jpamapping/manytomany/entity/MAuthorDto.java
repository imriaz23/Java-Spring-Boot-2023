package com.example.jpamapping.manytomany.entity;

import java.util.List;
import lombok.Data;

/**
 * A DTO for the {@link MAuthor} entity
 */
@Data
public class MAuthorDto {
  private Long id;
  private String name;
  private List<MBookDto> books;
}