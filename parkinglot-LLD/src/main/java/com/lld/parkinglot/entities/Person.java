package com.lld.parkinglot.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Person {
  private Long id;
  private String name;
  private Address address;
  private String email;
  private String phone;
}
