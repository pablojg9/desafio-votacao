package com.gntech.voting.Voting.adapter.in.resource.exception.handle;

import com.gntech.voting.Voting.adapter.in.resource.exception.response.ErrorMessageResponse;
import com.gntech.voting.Voting.application.core.exceptions.AgendaException;
import com.gntech.voting.Voting.application.core.exceptions.NotFoundAgendaException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandleResource {

  private final MessageSource messageSource;

  public ExceptionHandleResource(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<ErrorMessageResponse>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
    List<ErrorMessageResponse> errors = new ArrayList<>();
    exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
      String message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
      errors.add(new ErrorMessageResponse(fieldError.getField(), message));
    });

    return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NotFoundAgendaException.class)
  public ResponseEntity<ErrorMessageResponse> handleNotFoundAgendaException(NotFoundAgendaException exception) {
    ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(
        exception.getMessage(),
        HttpStatus.NOT_FOUND.toString());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessageResponse);
  }

  @ExceptionHandler(NullPointerException.class)
  public ResponseEntity<ErrorMessageResponse> handleNullPointerException(NullPointerException exception) {
    ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(
        exception.getMessage(),
        HttpStatus.BAD_REQUEST.toString());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessageResponse);
  }

  @ExceptionHandler(AgendaException.class)
  public ResponseEntity<ErrorMessageResponse> handleAgendaException(AgendaException exception) {
    ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(
        exception.getMessage(),
        HttpStatus.BAD_REQUEST.toString());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessageResponse);
  }


}
