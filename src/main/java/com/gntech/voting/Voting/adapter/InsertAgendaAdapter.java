package com.gntech.voting.Voting.adapter;

import com.gntech.voting.Voting.adapter.out.repository.AgendaRepository;
import com.gntech.voting.Voting.adapter.out.repository.entity.AgendaEntity;
import com.gntech.voting.Voting.adapter.out.repository.mapper.AgendaEntityMapper;
import com.gntech.voting.Voting.application.core.domain.Agenda;
import com.gntech.voting.Voting.application.port.out.InsertAgendaOutputPort;
import org.springframework.stereotype.Component;

@Component
public class InsertAgendaAdapter implements InsertAgendaOutputPort {

  private final AgendaRepository agendaRepository;
  private final AgendaEntityMapper agendaEntityMapper;

  public InsertAgendaAdapter(AgendaRepository agendaRepository, AgendaEntityMapper agendaEntityMapper) {
    this.agendaRepository = agendaRepository;
    this.agendaEntityMapper = agendaEntityMapper;
  }

  @Override
  public Agenda insert(Agenda agenda) {
    AgendaEntity agendaEntity = agendaEntityMapper.agendaToAgendaEntity(agenda);
    agendaRepository.save(agendaEntity);
    return agendaEntityMapper.agendaEntityToAgenda(agendaEntity);
  }
}
