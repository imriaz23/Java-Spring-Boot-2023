package com.lld.parkinglot.entities;

public class Handicapped extends ParkingSpot{
  @Override
  public boolean assignVehicle(Vehicle vehicle) {
    setVehicle(vehicle);
    setFree(false);
    return true;
  }
}
