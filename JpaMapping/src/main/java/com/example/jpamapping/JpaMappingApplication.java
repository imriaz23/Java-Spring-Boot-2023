package com.example.jpamapping;

import com.example.jpamapping.oneToOne.entities.Profile;
import com.example.jpamapping.oneToOne.entities.User;
import com.example.jpamapping.oneToOne.services.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaMappingApplication implements CommandLineRunner {
  Logger logger = LoggerFactory.getLogger(JpaMappingApplication.class);
  @Autowired
  UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(JpaMappingApplication.class, args);
    }

@Override public void run(String... args)throws Exception {
        User user = new User();
        user.setFirstName(RandomStringUtils.randomAlphabetic(5));
        user.setLastname(RandomStringUtils.randomAlphabetic(7));
        Profile profile = new Profile();
        profile.setUser(user);
        user.setProfile(profile);
        userService.save(user);
        Long id = 1L;
//        logger.info("ebfwoie {}",userRepository.findById(id).get().getProfile().getId());
    }}
