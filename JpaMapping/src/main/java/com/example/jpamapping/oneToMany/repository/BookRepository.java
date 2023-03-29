package com.example.jpamapping.oneToMany.repository;

import com.example.jpamapping.oneToMany.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {}
