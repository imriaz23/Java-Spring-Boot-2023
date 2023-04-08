package com.lld.parkinglot.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ParkingSpot {
  private Long id;
  private boolean isFree;
  private Vehicle vehicle;

  public  boolean isAvailable(){
    return isFree();
  }
  public abstract boolean assignVehicle(Vehicle vehicle);
  public  boolean removeVehicle(){
    setFree(true);
    return true;
  }

}
