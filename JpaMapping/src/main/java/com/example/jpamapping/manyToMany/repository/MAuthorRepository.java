package com.example.jpamapping.manyToMany.repository;

import com.example.jpamapping.manyToMany.entity.MAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MAuthorRepository extends JpaRepository <MAuthor,Long>{}
