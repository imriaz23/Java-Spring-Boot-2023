package com.example.jpamapping.inheritance.repository;

import com.example.jpamapping.inheritance.entity.Car;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends VeichleRepository<Car> {
}
