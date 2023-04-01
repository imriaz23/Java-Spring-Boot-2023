package com.example.jpamapping.oneToOne.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {
  @ExceptionHandler(UserNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<String> handleNoUserFoundException(UserNotFoundException userNotFoundException){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userNotFoundException.getMessage());
  }
}
