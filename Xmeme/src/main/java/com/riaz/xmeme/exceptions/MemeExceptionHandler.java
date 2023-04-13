package com.riaz.xmeme.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, List<String>>> handleValidationErrors(
      MethodArgumentNotValidException ex) {
    List<String> errors = ex.getBindingResult().getFieldErrors().
        stream()
        .map(FieldError::getDefaultMessage).collect(Collectors.toList());
    System.out.println(errors);
    Map<String, List<String>> errorResponse = new HashMap<>();
    errorResponse.put("errors", errors);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((errorResponse));

  }

}
