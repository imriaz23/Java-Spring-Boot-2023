package com.example.jpamapping.inheritance.repository;

import com.example.jpamapping.inheritance.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface VeichleRepository extends JpaRepository<Vehicle, Long> {}
