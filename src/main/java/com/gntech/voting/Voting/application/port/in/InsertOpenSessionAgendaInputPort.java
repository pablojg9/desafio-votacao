package com.gntech.voting.Voting.application.port.in;

import java.util.UUID;

public interface InsertOpenSessionAgendaInputPort {

  void insert(final UUID agendaId, final Integer timeMinutes);

}
