package com.example.jpamapping.oneToMany.api;

import com.example.jpamapping.oneToMany.entities.Author;
import com.example.jpamapping.oneToMany.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {
  @Autowired
  AuthorService authorService;

  @GetMapping("/get/{id}")
  public ResponseEntity<Author> getAuthor(@PathVariable Long id) {
    Author author = authorService.getAuthor(id);
    return ResponseEntity.ok(author);
  }

}
