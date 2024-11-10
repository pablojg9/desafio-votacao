package com.gntech.voting.Voting.application.core.exceptions;

public class ValidationException extends RuntimeException {

  public ValidationException() {
  }

  public ValidationException(String message) {
    super(message);
  }

  public ValidationException(String message, Throwable cause) {
    super(message, cause);
  }
}
