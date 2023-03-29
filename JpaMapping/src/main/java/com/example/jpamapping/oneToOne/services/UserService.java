package com.example.jpamapping.oneToOne.services;

import com.example.jpamapping.oneToOne.entities.User;
import com.example.jpamapping.oneToOne.repository.UserRepository;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = "userCache")
public class UserService {
  @Autowired
  UserRepository userRepository;

  @Cacheable(cacheNames = "user")
  public User getUser(Long id) {
      Optional<User> optionalUser = userRepository.findById(id);
      if(optionalUser.isPresent()){
          return optionalUser.get();
      }
      return optionalUser.orElseThrow();
  }
}
