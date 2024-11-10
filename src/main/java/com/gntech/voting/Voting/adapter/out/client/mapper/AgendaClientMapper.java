package com.gntech.voting.Voting.adapter.out.client.mapper;

import com.gntech.voting.Voting.adapter.out.repository.entity.AgendaEntity;
import com.gntech.voting.Voting.application.core.domain.Agenda;
import com.gntech.voting.Voting.config.mapper.MapperConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface AgendaClientMapper {

  @Mapping(target = "votes", ignore = true)
  Agenda agendaEntityToAgenda(AgendaEntity agenda);
}
