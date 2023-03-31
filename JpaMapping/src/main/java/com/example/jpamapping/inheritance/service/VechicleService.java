package com.example.jpamapping.inheritance.service;

import com.example.jpamapping.inheritance.entity.CarPage;
import com.example.jpamapping.inheritance.entity.Vehicle;
import com.example.jpamapping.inheritance.repository.VeichleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "vehicle_cache") public class VechicleService {
    @Autowired VeichleRepository veichleRepository;

  @Cacheable(cacheNames = "vehicles")
  public List<Vehicle> getVehicles() {
        return veichleRepository.findAll();
    }
    @CacheEvict(cacheNames = "vehicles",allEntries = true)
    public void save(List<Vehicle> vehicles){
        veichleRepository.saveAll(vehicles);
    }
//    @Cacheable(cacheNames = "vehicles")
    public Page<Vehicle> getCars(CarPage carPage){
      Sort sort = Sort.by(carPage.getSortDirection(),carPage.getSortBy());

    Pageable pageable = PageRequest.of(carPage.getPageNumber(),carPage.getPageSize(),sort);
        return veichleRepository.findAll(pageable);
    }
}
