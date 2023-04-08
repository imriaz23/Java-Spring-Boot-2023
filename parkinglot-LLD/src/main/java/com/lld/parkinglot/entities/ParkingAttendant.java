package com.lld.parkinglot.entities;

public class ParkingAttendant extends Account{
  @Override
  public boolean resetPassword(String password) {
    setPassword(password);
    return true;
  }
  public boolean processTicket(String ticketNumber){
    System.out.println("Processing the ticket");
    return true;
  }
}
