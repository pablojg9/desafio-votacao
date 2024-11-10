package com.gntech.voting.Voting.application.core.usecase;

import com.gntech.voting.Voting.application.core.domain.Agenda;
import com.gntech.voting.Voting.application.core.domain.Vote;
import com.gntech.voting.Voting.application.core.domain.utils.localdatetime.LocalDateTimeUtils;
import com.gntech.voting.Voting.application.core.exceptions.AgendaException;
import com.gntech.voting.Voting.application.port.in.InsertRegistryVoteInputPort;
import com.gntech.voting.Voting.application.port.out.FindAgendaByIdOutputPort;
import com.gntech.voting.Voting.application.port.out.FindByCpfAndAgendaOutputPort;
import com.gntech.voting.Voting.application.port.out.InsertVoteOutputPort;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

public class InsertRegistryVoteUseCase implements InsertRegistryVoteInputPort {

  private final FindAgendaByIdOutputPort findAgendaByIdOutputPort;

  private final InsertVoteOutputPort insertVoteOutputPort;

  private final FindByCpfAndAgendaOutputPort findByCpfAndAgendaOutputPort;

  public InsertRegistryVoteUseCase(FindAgendaByIdOutputPort findAgendaByIdOutputPort, InsertVoteOutputPort insertVoteOutputPort, FindByCpfAndAgendaOutputPort findByCpfAndAgendaOutputPort) {
    this.findAgendaByIdOutputPort = findAgendaByIdOutputPort;
    this.insertVoteOutputPort = insertVoteOutputPort;
    this.findByCpfAndAgendaOutputPort = findByCpfAndAgendaOutputPort;
  }

  @Override
  public void insert(UUID agendaUUID, Vote vote) {
    Agenda agenda = findAgendaByIdOutputPort.find(agendaUUID)
        .orElseThrow(() -> new RuntimeException("Agenda was not found"));

    requireNonNull(agenda.getStartTime(), "Agenda start time was null, start agenda");
    requireNonNull(agenda.getEndTime(), "Agenda end time was null, start agenda");

    findByCpfAndAgendaOutputPort.find(vote.getCpf(), agenda.getId());

    if (LocalDateTimeUtils.localDateVerification(agenda.getStartTime(), agenda.getEndTime())) {
      throw new AgendaException("start time is after end time");
    }

    vote.setAgenda(agenda);
    insertVoteOutputPort.insert(vote);
  }
}
