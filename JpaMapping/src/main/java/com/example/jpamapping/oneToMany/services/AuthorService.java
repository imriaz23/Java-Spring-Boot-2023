package com.example.jpamapping.oneToMany.services;

import com.example.jpamapping.oneToMany.entities.Author;
import com.example.jpamapping.oneToMany.repository.AuthorRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@CacheConfig(cacheNames = "authorCache")
@Transactional
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

  @Cacheable(cacheNames = "authors")
  @Transactional
  public Author getAuthor(Long id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if(optionalAuthor.isPresent()){
            return optionalAuthor.get();
        }
        return optionalAuthor.orElseThrow();
    }

  @CacheEvict(cacheNames = "authors",allEntries = true)
  @Transactional
  public boolean saveAuthor(Author author) {
        authorRepository.save(author);
        return true;
    }
}
