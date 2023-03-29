package com.example.jpamapping.oneToOne.api;

import com.example.jpamapping.oneToOne.entities.User;
import com.example.jpamapping.oneToOne.exceptions.UserNotFoundException;
import com.example.jpamapping.oneToOne.repository.UserRepository;
import com.example.jpamapping.oneToOne.services.UserService;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired UserService userService;
  Logger logger = LoggerFactory.getLogger(UserController.class);

  @GetMapping("/get/{id}")
  public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
      User user = userService.getUser(id);
      return ResponseEntity.ok(user);
  }
}
