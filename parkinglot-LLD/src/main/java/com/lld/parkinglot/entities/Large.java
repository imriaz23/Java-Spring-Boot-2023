package com.lld.parkinglot.entities;

public class Large extends ParkingSpot{

  @Override
  public boolean assignVehicle(Vehicle vehicle) {
    setVehicle(vehicle);
    setFree(false);
    return true;
  }

}
