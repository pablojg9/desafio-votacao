package com.gntech.voting.Voting.application.core.usecase;

import com.gntech.voting.Voting.application.core.domain.Agenda;
import com.gntech.voting.Voting.application.port.out.InsertAgendaOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class InsertAgendaUseCaseTest {

  @Mock
  private InsertAgendaOutputPort insertAgendaOutputPort;

  @InjectMocks
  private InsertAgendaUseCase insertAgendaUseCase;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    insertAgendaUseCase = new InsertAgendaUseCase(insertAgendaOutputPort);
  }

  @Test
  @DisplayName("should insert agenda success")
  void shouldInsertAgendaSuccessAndNotNull() {
    Agenda agenda = new Agenda(UUID.randomUUID(),
        "Votao1",
        LocalDateTime.now(),
        LocalDateTime.now(),
        new ArrayList<>());
    insertAgendaUseCase.insert(agenda);
    verify(insertAgendaOutputPort, times(1)).insert(agenda);
  }
}