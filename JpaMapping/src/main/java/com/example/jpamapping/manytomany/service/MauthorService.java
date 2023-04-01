package com.example.jpamapping.manytomany.service;

import com.example.jpamapping.manytomany.entity.MAuthor;
import com.example.jpamapping.manytomany.entity.MAuthorDto;
import com.example.jpamapping.manytomany.repository.MAuthorRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@CacheConfig(cacheNames = "mauthor_cache")
@Transactional
public class MauthorService {
  @Autowired
  MAuthorRepository mAuthorRepository;
  Logger logger = LoggerFactory.getLogger(MauthorService.class);


  @CacheEvict(cacheNames = "mauthor", allEntries = true)
  @Transactional
  public void createAuthor(MAuthor mAuthor) {
    mAuthorRepository.save(mAuthor);
  }

  @Cacheable(cacheNames = "mauthor")
  @Transactional
  public MAuthorDto getAuthor(Long id) {
    logger.info("received request{}", id);
    MAuthor mAuthor = mAuthorRepository.findById(id).get();
    ModelMapper modelMapper = new ModelMapper();
    MAuthorDto mAuthorDto = new MAuthorDto();
    modelMapper.map(mAuthor, mAuthorDto);
    return mAuthorDto;
  }
}
