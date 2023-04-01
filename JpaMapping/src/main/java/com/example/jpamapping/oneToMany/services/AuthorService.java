package com.example.jpamapping.oneToMany.services;

import com.example.jpamapping.oneToMany.entities.Author;
import com.example.jpamapping.oneToMany.repository.AuthorRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@CacheConfig(cacheNames = "authorCache")
public class AuthorService {
  @Autowired
  AuthorRepository authorRepository;

  //  @Cacheable(cacheNames = "authors")
  public Author getAuthor(Long id) {
    Optional<Author> optionalAuthor = authorRepository.findById(id);
    if (optionalAuthor.isPresent()) {
      return optionalAuthor.get();
    }
    return optionalAuthor.orElseThrow();
  }

//  @CacheEvict(cacheNames = "authors",allEntries = true)

  public boolean saveAuthor(Author author) {
    authorRepository.save(author);
    return true;
  }
}
