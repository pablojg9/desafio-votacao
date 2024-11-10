package com.gntech.voting.Voting.adapter;

import com.gntech.voting.Voting.adapter.out.client.mapper.AgendaClientMapper;
import com.gntech.voting.Voting.adapter.out.repository.AgendaRepository;
import com.gntech.voting.Voting.adapter.out.repository.entity.AgendaEntity;
import com.gntech.voting.Voting.application.core.domain.Agenda;
import com.gntech.voting.Voting.application.core.exceptions.NotFoundAgendaException;
import com.gntech.voting.Voting.application.port.out.FindAgendaByIdOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

@Component
public class FindAgendaByIdAdapter implements FindAgendaByIdOutputPort {

  private final AgendaRepository agendaRepository;

  private final AgendaClientMapper agendaClientMapper;

  public FindAgendaByIdAdapter(final AgendaRepository agendaRepository, final AgendaClientMapper agendaClientMapper) {
    this.agendaRepository = agendaRepository;
    this.agendaClientMapper = agendaClientMapper;
  }

  @Override
  public Optional<Agenda> find(UUID uuid) {
    Optional<AgendaEntity> agendaEntity = agendaRepository.findById(uuid);
    Agenda agenda = agendaClientMapper.agendaEntityToAgenda(agendaEntity.get());

    return Optional.of(agenda);
  }
}
