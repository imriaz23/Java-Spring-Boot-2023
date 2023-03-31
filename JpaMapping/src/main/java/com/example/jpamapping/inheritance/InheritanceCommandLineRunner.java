package com.example.jpamapping.inheritance;

import com.example.jpamapping.inheritance.entity.Car;
import com.example.jpamapping.inheritance.entity.Vehicle;
import com.example.jpamapping.inheritance.service.VechicleService;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class InheritanceCommandLineRunner implements CommandLineRunner {
    @Autowired VechicleService vechicleService;
    Logger logger = LoggerFactory.getLogger(InheritanceCommandLineRunner.class);
    @Override public void run(String... args)throws Exception {
        List<Vehicle> vehicles = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            Car car = new Car();
      car.setName(RandomStringUtils.randomAlphabetic(5,7));
      car.setSteering(RandomStringUtils.randomAlphabetic(5,8));
      car.setAmount((int)(Math.random()*100000000));
      vehicles.add(car);
        }
        vechicleService.save(vehicles);

    }}
