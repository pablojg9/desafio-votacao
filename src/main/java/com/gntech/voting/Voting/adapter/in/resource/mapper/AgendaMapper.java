package com.gntech.voting.Voting.adapter.in.resource.mapper;

import com.gntech.voting.Voting.adapter.in.resource.request.AgendaRequest;
import com.gntech.voting.Voting.adapter.in.resource.response.AgendaResponse;
import com.gntech.voting.Voting.application.core.domain.Agenda;
import com.gntech.voting.Voting.config.mapper.MapperConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface AgendaMapper {

  @Mapping(target = "votes", ignore = true)
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "startTime", ignore = true)
  @Mapping(target = "endTime", ignore = true)
  Agenda agendaRequestToAgenda(AgendaRequest agendaRequest);

  @Mapping(target = "uuid", source = "id")
  @Mapping(target = "nameAgenda", source = "name")
  AgendaResponse agendaToAgendaResponse(Agenda agenda);

}
