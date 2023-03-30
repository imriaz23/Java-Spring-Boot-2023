package com.example.jpamapping.manyToMany.service;

import com.example.jpamapping.manyToMany.entity.MAuthor;
import com.example.jpamapping.manyToMany.repository.MAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@CacheConfig(cacheNames = "mauthor_cache")
@Transactional
public class MAuthorService {
    @Autowired MAuthorRepository mAuthorRepository;
//    @CacheEvict(cacheNames = "mauthor",allEntries = true)
    @Transactional
    public void createAuthor(MAuthor mAuthor){
        mAuthorRepository.save(mAuthor);
    }

//  @Cacheable(cacheNames = "mauthor")
  @Transactional
  public MAuthor getAuthor(Long id) {
        return mAuthorRepository.findById(id).get();
    }
}
