package com.riaz.xmeme.exceptions;

public class DuplicatePostException extends RuntimeException {
  public DuplicatePostException(String message) {
    super(message);
  }
}
