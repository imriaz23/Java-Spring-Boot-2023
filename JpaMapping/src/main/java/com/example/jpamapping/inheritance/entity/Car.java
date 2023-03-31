package com.example.jpamapping.inheritance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Car extends Vehicle {
  @Column
  private String steering;
}
