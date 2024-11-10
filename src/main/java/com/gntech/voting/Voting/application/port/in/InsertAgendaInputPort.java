package com.gntech.voting.Voting.application.port.in;

import com.gntech.voting.Voting.application.core.domain.Agenda;

public interface InsertAgendaInputPort {

  Agenda insert(Agenda agenda);
}
