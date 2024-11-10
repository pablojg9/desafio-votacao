package com.gntech.voting.Voting.adapter.out.repository.mapper;

import com.gntech.voting.Voting.adapter.out.repository.entity.AgendaEntity;
import com.gntech.voting.Voting.adapter.out.repository.entity.VoteEntity;
import com.gntech.voting.Voting.application.core.domain.Agenda;
import com.gntech.voting.Voting.application.core.domain.Vote;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-10T01:21:28-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class AgendaEntityMapperImpl implements AgendaEntityMapper {

    @Override
    public AgendaEntity agendaToAgendaEntity(Agenda agenda) {
        if ( agenda == null ) {
            return null;
        }

        AgendaEntity agendaEntity = new AgendaEntity();

        agendaEntity.setId( agenda.getId() );
        agendaEntity.setName( agenda.getName() );
        agendaEntity.setStartTime( agenda.getStartTime() );
        agendaEntity.setEndTime( agenda.getEndTime() );
        agendaEntity.setVotes( voteListToVoteEntityList( agenda.getVotes() ) );

        return agendaEntity;
    }

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
        agenda1.setVotes( voteEntityListToVoteList( agenda.getVotes() ) );

        return agenda1;
    }

    protected VoteEntity voteToVoteEntity(Vote vote) {
        if ( vote == null ) {
            return null;
        }

        VoteEntity voteEntity = new VoteEntity();

        voteEntity.setId( vote.getId() );
        voteEntity.setCpf( vote.getCpf() );
        voteEntity.setVote( vote.getVote() );
        voteEntity.setAgenda( agendaToAgendaEntity( vote.getAgenda() ) );

        return voteEntity;
    }

    protected List<VoteEntity> voteListToVoteEntityList(List<Vote> list) {
        if ( list == null ) {
            return null;
        }

        List<VoteEntity> list1 = new ArrayList<VoteEntity>( list.size() );
        for ( Vote vote : list ) {
            list1.add( voteToVoteEntity( vote ) );
        }

        return list1;
    }

    protected Vote voteEntityToVote(VoteEntity voteEntity) {
        if ( voteEntity == null ) {
            return null;
        }

        Vote vote = new Vote();

        vote.setId( voteEntity.getId() );
        vote.setCpf( voteEntity.getCpf() );
        vote.setVote( voteEntity.getVote() );
        vote.setAgenda( agendaEntityToAgenda( voteEntity.getAgenda() ) );

        return vote;
    }

    protected List<Vote> voteEntityListToVoteList(List<VoteEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Vote> list1 = new ArrayList<Vote>( list.size() );
        for ( VoteEntity voteEntity : list ) {
            list1.add( voteEntityToVote( voteEntity ) );
        }

        return list1;
    }
}
