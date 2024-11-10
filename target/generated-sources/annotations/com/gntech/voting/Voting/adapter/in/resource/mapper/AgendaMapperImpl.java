package com.gntech.voting.Voting.adapter.in.resource.mapper;

import com.gntech.voting.Voting.adapter.in.resource.request.AgendaRequest;
import com.gntech.voting.Voting.adapter.in.resource.response.AgendaResponse;
import com.gntech.voting.Voting.application.core.domain.Agenda;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-10T01:21:28-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class AgendaMapperImpl implements AgendaMapper {

    @Override
    public Agenda agendaRequestToAgenda(AgendaRequest agendaRequest) {
        if ( agendaRequest == null ) {
            return null;
        }

        Agenda agenda = new Agenda();

        agenda.setName( agendaRequest.name() );

        return agenda;
    }

    @Override
    public AgendaResponse agendaToAgendaResponse(Agenda agenda) {
        if ( agenda == null ) {
            return null;
        }

        UUID uuid = null;
        String nameAgenda = null;

        uuid = agenda.getId();
        nameAgenda = agenda.getName();

        AgendaResponse agendaResponse = new AgendaResponse( uuid, nameAgenda );

        return agendaResponse;
    }
}
