package com.lld.parkinglot.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Getter
@Setter
@Builder
public class Address {
  private int zipcode;
  private String address;
  private String city;
  private String state;
  private String country;

}
