package com.lld.parkinglot.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Vehicle {
  private Long id;
  private String licenseNo;
  public abstract void assignTicket(ParkingTicket ticket);
}
