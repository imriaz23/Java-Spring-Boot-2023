package com.lld.parkinglot.entities;

public class Admin extends Account{
  @Override
  public boolean resetPassword(String password) {
    setPassword(password);
    System.out.println("Password is changed");
    return true;
  }
  public boolean addParkingSpot(ParkingSpot parkingSpot){
    System.out.println("parkingSpot added successfully");
    return true;
  }
  public boolean addDisplayBoard(DisplayBoard displayBoard){
    System.out.println("Added display-board successfully");
    return true;
  }
  public boolean addEntrance(Entrance entrance){
    System.out.println("Entrance added successfully");
    return true;
  }
  public boolean addExit(Exit exit){
    System.out.println("Exit added successfully");
    return true;
  }
}
