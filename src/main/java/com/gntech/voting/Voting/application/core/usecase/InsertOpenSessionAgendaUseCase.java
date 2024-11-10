package com.gntech.voting.Voting.application.core.usecase;

import com.gntech.voting.Voting.application.core.domain.Agenda;
import com.gntech.voting.Voting.application.core.exceptions.NotFoundAgendaException;
import com.gntech.voting.Voting.application.port.in.InsertOpenSessionAgendaInputPort;
import com.gntech.voting.Voting.application.port.out.FindAgendaByIdOutputPort;
import com.gntech.voting.Voting.application.port.out.InsertAgendaOutputPort;

import java.time.LocalDateTime;
import java.util.UUID;

public class InsertOpenSessionAgendaUseCase implements InsertOpenSessionAgendaInputPort {

  private final FindAgendaByIdOutputPort findAgendaByIdOutputPort;

  private final InsertAgendaOutputPort insertAgendaOutputPort;

  public InsertOpenSessionAgendaUseCase(final FindAgendaByIdOutputPort findAgendaByIdOutputPort,
                                        final InsertAgendaOutputPort insertAgendaOutputPort) {
    this.findAgendaByIdOutputPort = findAgendaByIdOutputPort;
    this.insertAgendaOutputPort = insertAgendaOutputPort;
  }

  @Override
  public void insert(final UUID agendaId, final Integer timeMinutes) {
    Agenda agenda = findAgendaByIdOutputPort.find(agendaId).orElseThrow(() -> new NotFoundAgendaException("agenda was not found"));
    agenda.setStartTime(LocalDateTime.now());
    agenda.setEndTime(LocalDateTime.now().plusMinutes(timeMinutes));
    insertAgendaOutputPort.insert(agenda);
  }
}
