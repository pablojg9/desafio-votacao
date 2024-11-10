package com.gntech.voting.Voting.application.core.exceptions;

public class AgendaException extends ValidationException {

  public AgendaException() {
  }

  public AgendaException(String message) {
    super(message);
  }

  public AgendaException(String message, Throwable cause) {
    super(message, cause);
  }
}
