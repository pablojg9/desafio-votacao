package com.gntech.voting.Voting.adapter.out.client.mapper;

import com.gntech.voting.Voting.adapter.out.repository.entity.AgendaEntity;
import com.gntech.voting.Voting.application.core.domain.Agenda;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-10T01:22:04-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class AgendaClientMapperImpl implements AgendaClientMapper {

    @Override
    public Agenda agendaEntityToAgenda(AgendaEntity agenda) {
        if ( agenda == null ) {
            return null;
        }

        Agenda agenda1 = new Agenda();

        agenda1.setId( agenda.getId() );
        agenda1.setName( agenda.getName() );
        agenda1.setStartTime( agenda.getStartTime() );
        agenda1.setEndTime( agenda.getEndTime() );

        return agenda1;
    }
}
