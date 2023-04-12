package com.riaz.xmeme.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MemeExceptionHandler {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(MemeNotFoundExecption.class)
  public ErrorResponse handleUserNotFoundException(MemeNotFoundExecption memeNotFoundExecption) {
    return ErrorResponse.builder().
        message(memeNotFoundExecption.getMessage())
        .build();
  }

  @ResponseStatus(HttpStatus.CONFLICT)
  @ExceptionHandler(DuplicatePostException.class)
  public ErrorResponse handleDuplicatePostFoundException(
      DuplicatePostException duplicatePostException) {
    return ErrorResponse.builder().
        message(duplicatePostException.getMessage())
        .build();
  }
}
