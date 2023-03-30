package com.example.jpamapping.oneToOne.services;

import com.example.jpamapping.oneToOne.entities.User;
import com.example.jpamapping.oneToOne.repository.UserRepository;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "userCache")
public class UserService {
  @Autowired
  UserRepository userRepository;
  Logger logger = LoggerFactory.getLogger(UserService.class);

  @Cacheable(cacheNames = "user")
  public User getUser(Long id) {
      Optional<User> optionalUser = userRepository.findById(id);
      if(optionalUser.isPresent()){
          logger.info("fnwkfw efhweoifw {}",optionalUser.get().getProfile().getId());
          return optionalUser.get();
      }
      return optionalUser.orElseThrow();
  }
  @CacheEvict(cacheNames = "user",allEntries = true)
    public void save(User user){
      userRepository.save(user);
  }
}
