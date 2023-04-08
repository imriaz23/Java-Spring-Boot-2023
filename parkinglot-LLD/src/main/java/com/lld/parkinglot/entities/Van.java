package com.lld.parkinglot.entities;

public class Van extends Vehicle{
  @Override
  public void assignTicket(ParkingTicket ticket) {
    System.out.println("Assigned ticket to van");
  }
}
