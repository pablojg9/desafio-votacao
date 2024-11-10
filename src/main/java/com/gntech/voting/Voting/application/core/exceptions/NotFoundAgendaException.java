package com.gntech.voting.Voting.application.core.exceptions;

public class NotFoundAgendaException extends ValidationException {

  public NotFoundAgendaException() {
  }

  public NotFoundAgendaException(String message) {
    super(message);
  }

  public NotFoundAgendaException(String message, Throwable cause) {
    super(message, cause);
  }
}
