package com.gntech.voting.Voting.application.port.out;

import com.gntech.voting.Voting.application.core.domain.Agenda;

public interface InsertAgendaOutputPort {

  Agenda insert(Agenda agenda);

}
