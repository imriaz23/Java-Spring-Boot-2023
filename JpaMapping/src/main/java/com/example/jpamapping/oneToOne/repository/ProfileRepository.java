package com.example.jpamapping.oneToOne.repository;

import com.example.jpamapping.oneToOne.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long>{}
