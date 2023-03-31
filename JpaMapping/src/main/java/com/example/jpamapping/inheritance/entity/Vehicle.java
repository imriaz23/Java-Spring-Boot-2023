package com.example.jpamapping.inheritance.entity;

import jakarta.persistence.*;
import lombok.Data;

@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Entity
public abstract class Vehicle {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

    @Column
    private String name;
    private Integer amount;
}
