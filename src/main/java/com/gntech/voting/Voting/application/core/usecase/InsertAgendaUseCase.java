package com.gntech.voting.Voting.application.core.usecase;

import com.gntech.voting.Voting.application.core.domain.Agenda;
import com.gntech.voting.Voting.application.port.in.InsertAgendaInputPort;
import com.gntech.voting.Voting.application.port.out.InsertAgendaOutputPort;

public class InsertAgendaUseCase implements InsertAgendaInputPort {

  private final InsertAgendaOutputPort insertAgendaOutputPort;

  public InsertAgendaUseCase(InsertAgendaOutputPort insertAgendaOutputPort) {
    this.insertAgendaOutputPort = insertAgendaOutputPort;
  }

  @Override
  public Agenda insert(Agenda agenda) {
    return insertAgendaOutputPort.insert(agenda);
  }
}
