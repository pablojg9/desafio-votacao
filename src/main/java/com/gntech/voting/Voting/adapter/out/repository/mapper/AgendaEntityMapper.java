package com.gntech.voting.Voting.adapter.out.repository.mapper;

import com.gntech.voting.Voting.adapter.out.repository.entity.AgendaEntity;
import com.gntech.voting.Voting.application.core.domain.Agenda;
import com.gntech.voting.Voting.config.mapper.MapperConfiguration;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface AgendaEntityMapper {

  AgendaEntity agendaToAgendaEntity(Agenda agenda);

  Agenda agendaEntityToAgenda(AgendaEntity agenda);
}
