package com.lld.parkinglot.entities;

public class Car extends Vehicle{
  @Override
  public void assignTicket(ParkingTicket ticket) {
    System.out.println("Assigned Car ticket");
  }
}
