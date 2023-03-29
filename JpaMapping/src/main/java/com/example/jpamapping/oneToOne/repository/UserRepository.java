package com.example.jpamapping.oneToOne.repository;

import com.example.jpamapping.oneToOne.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
