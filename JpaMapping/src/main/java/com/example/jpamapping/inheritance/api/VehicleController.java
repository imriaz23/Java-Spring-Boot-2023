package com.example.jpamapping.inheritance.api;

import com.example.jpamapping.inheritance.entity.CarPage;
import com.example.jpamapping.inheritance.service.VechicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

  @Autowired
  VechicleService vechicleService;

  @GetMapping("/get")
  public ResponseEntity<?> getVehicles() {
    return ResponseEntity.ok(vechicleService.getVehicles());
  }

  @GetMapping("/get/pageable")
  public ResponseEntity<?> getVehiclesInPageable(CarPage carPage) {

    return ResponseEntity.ok(vechicleService.getCars(carPage));
  }
}
