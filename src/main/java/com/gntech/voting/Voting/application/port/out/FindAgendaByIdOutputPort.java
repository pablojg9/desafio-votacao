package com.gntech.voting.Voting.application.port.out;

import com.gntech.voting.Voting.application.core.domain.Agenda;

import java.util.Optional;
import java.util.UUID;

public interface FindAgendaByIdOutputPort {

  Optional<Agenda> find(UUID uuid);

}
