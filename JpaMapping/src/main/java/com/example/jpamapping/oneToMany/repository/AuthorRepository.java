package com.example.jpamapping.oneToMany.repository;

import com.example.jpamapping.oneToMany.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository public interface AuthorRepository extends JpaRepository <Author,Long>{}
