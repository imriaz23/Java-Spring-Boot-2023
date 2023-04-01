package com.example.jpamapping.manytomany.repository;

import com.example.jpamapping.manytomany.entity.MAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MAuthorRepository extends JpaRepository<MAuthor, Long> {
}
